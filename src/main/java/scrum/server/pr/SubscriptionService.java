/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package scrum.server.pr;

import ilarkesto.auth.PasswordHasher;
import ilarkesto.core.base.Str;
import ilarkesto.core.logging.Log;
import ilarkesto.core.scope.In;
import ilarkesto.persistence.AEntity;

import java.util.Set;

import scrum.client.common.LabelSupport;
import scrum.client.common.ReferenceSupport;
import scrum.server.admin.SystemConfig;
import scrum.server.project.Project;

public class SubscriptionService {

	private static final Log log = Log.get(SubscriptionService.class);

	@In
	private SubscriptionDao subscriptionDao;

	@In
	private EmailSender emailSender;

	@In
	private SystemConfig systemConfig;

	public void subscribe(String email, AEntity subject) {
		if (!Str.isEmail(email)) throw new RuntimeException("Invalid email: " + email);
		Subscription subscription = subscriptionDao.getSubscriptionBySubject(subject);
		if (subscription == null) {
			subscription = subscriptionDao.postSubscription(subject);
		}
		subscription.addSubscribersEmail(email);
		log.info(email, "subscribed to", subject);
	}

	public void unsubscribe(String email, AEntity subject, String key) throws InvalidKeyException {
		if (!createKey(email).equals(key)) throw new InvalidKeyException(email);
		if (subject == null) {
			unsubscribeAll(email, key);
			return;
		}
		Subscription subscription = subscriptionDao.getSubscriptionBySubject(subject);
		if (subscription == null || !subscription.containsSubscribersEmail(email)) {
			log.debug(email, "is not subscribed to", subject);
			return;
		}
		subscription.removeSubscribersEmail(email);
		log.info(email, "unsubscribed from", subject);
	}

	private void unsubscribeAll(String email, String key) {
		Set<Subscription> subscriptions = subscriptionDao.getSubscriptionsBySubscribersEmail(email);
		if (subscriptions.isEmpty()) {
			log.debug(email, "is not subscribed to anything");
			return;
		}
		for (Subscription subscription : subscriptions) {
			subscription.removeSubscribersEmail(email);
		}
		log.info(email, "unsubscribed from", subscriptions.size(), "entities");
	}

	public void notifySubscribers(AEntity subject, String message, Project project) {
		Subscription subscription = subscriptionDao.getSubscriptionBySubject(subject);
		if (subscription == null || subscription.isSubscribersEmailsEmpty()) {
			log.debug("No subscribers for", subject);
			return;
		}
		String subjectText = createSubjectText(subject, project);
		for (String email : subscription.getSubscribersEmails()) {
			String text = createText(subject, project, email, message);
			emailSender.sendEmail(null, email, subjectText, text);
		}
	}

	private String createSubjectText(AEntity subject, Project project) {
		StringBuilder sb = new StringBuilder();
		sb.append(systemConfig.getInstanceNameWithApplicationLabel());
		sb.append(": ").append(project.getLabel());
		sb.append(": ").append(subject.toString());
		return sb.toString();
	}

	private String createText(AEntity subject, Project project, String email, String message) {
		String text = project.getSubscriberNotificationTemplate();
		if (subject instanceof ReferenceSupport) {
			text = text.replace("${entity.reference}", ((ReferenceSupport) subject).getReference());
		}
		if (subject instanceof LabelSupport) {
			text = text.replace("${entity.label}", ((LabelSupport) subject).getLabel());
		}
		text = text.replace("${message}", message);
		text = text.replace("${project.label}", project.getLabel());
		text = text.replace("${project.id}", project.getId());
		text = text.replace("${homepage.url}", project.getHomepageUrl());
		text = text.replace("${unsubscribe.url}", createUnsubscribeUrl(email, subject, project));
		text = text.replace("${unsubscribeall.url}", createUnsubscribeUrl(email, null, project));
		text = text.replace("${kunagi.instance}", systemConfig.getInstanceNameWithApplicationLabel());
		text = text.replace("${kunagi.url}", systemConfig.getUrl());
		return text;
	}

	private String createUnsubscribeUrl(String email, AEntity subject, Project project) {
		StringBuilder sb = new StringBuilder();
		sb.append(systemConfig.getUrl());
		sb.append("/unsubscribe");
		sb.append("?email=").append(Str.encodeUrlParameter(email));
		if (subject != null) sb.append("&subject=").append(Str.encodeUrlParameter(subject.getId()));
		sb.append("&key=").append(Str.encodeUrlParameter(createKey(email)));
		return sb.toString();
	}

	private String createKey(String email) {
		return PasswordHasher.hashPassword(email, systemConfig.getSubscriptionKeySeed());
	}

}
