package metier.dto;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	private static Session session;

	private final static String companyAdress = "roombooking48@gmail.com";
	private final static String password = "room123456789";

	public static Session initSession() {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(companyAdress, password);
			}
		});

		return session;

	}
	

	public static void send(String mail, String corpsMessage, Session session) {

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(companyAdress));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject("Confirmation de réservation");
			message.setText(corpsMessage);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
