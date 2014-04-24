package scrum.server.common;

import ilarkesto.core.base.Str;
import ilarkesto.webapp.RequestWrapper;
import scrum.server.WebSession;

public class SpamChecker {

	public static void check(String text, String name, String email, RequestWrapper<WebSession> req) {
		String spamPreventionCode = req.get("spamPreventionCode");
		if (!"no-spam".equals(spamPreventionCode)) throw new RuntimeException("HTTP Request identified as SPAM.");

		int spamScore = 0;

		if (Str.isBlank(name)) spamScore += 10;
		if (Str.isBlank(email)) spamScore += 10;

		if (name != null) {
			name = name.toLowerCase();
			if (name.contains("pharm")) spamScore += 30;
			if (Str.containsDigit(name)) spamScore += 10;
		}

		if (text != null) {
			text = text.toLowerCase();
			if (text.contains("http://")) spamScore += 10;
			if (text.contains("https://")) spamScore += 10;
			if (text.contains("Very nice site!")) spamScore += 30;
			if (text.contains("cheap goods")) spamScore += 30;
		}

		if (spamScore > 50) throw new RuntimeException("HTTP Request identified as SPAM.");
	}

}
