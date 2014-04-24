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
			if (name.contains("pharm")) spamScore += 25;
			if (Str.containsDigit(name)) spamScore += 10;
		}

		if (text != null) {
			text = text.toLowerCase();
			if (text.contains("http://") || text.contains("https://")) spamScore += 25;
			if (text.contains("Very nice site!")) spamScore += 25;
			if (text.contains("cheap goods")) spamScore += 25;
			if (text.contains("opeaixy2.com")) spamScore += 49;
		}

		if (spamScore >= 50) throw new RuntimeException("HTTP Request identified as SPAM.");
	}

}
