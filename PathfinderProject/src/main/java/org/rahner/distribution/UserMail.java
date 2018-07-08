package org.rahner.distribution;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class UserMail {

	public static void sendRegistrationVerificationLink(String sessionId, int userId, String emailAddress)
			throws EmailException {

		Email email = new SimpleEmail();
		email.setHostName("s134.goserver.host");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("web248p1", "1a$B.C+26zhnji9"));
		email.setSSLOnConnect(false);
		email.setFrom("pathfindertest@web248.s134.goserver.host");
		email.setSubject("Registration Verification");
		email.setMsg("Please click on the following link "
				+ "http://localhost:8080/PathfinderProject/register/verifyEmail?sessionId=" + sessionId + "&userId="
				+ userId);
		email.addTo(emailAddress);
		email.send();
	}
}
