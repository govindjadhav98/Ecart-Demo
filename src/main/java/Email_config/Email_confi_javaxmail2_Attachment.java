package Email_config;

import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.logging.SessionLogs;

public class Email_confi_javaxmail2_Attachment {

	public static void main(String[] args) {

		String messg="Hello, Have a Good day this message send for security check";
		String subject="Automation Email Test";
		String to="automationtestmail7@gmail.com";
		String from="firstoneplus7@gmail.com";

		SendEmail( messg,subject,to,from);
	}

	private static void SendEmail(String messg, String subject, String to, String from) {
		// TODO Auto-generated method stub
		//host for gmail
		String host="smtp.gmail.com";
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smpt.port", "587");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.auth", "true");
		// session object

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("firstoneplus7@gmail.com", "Balasaheb@1");
			}

		});
		session.setDebug(true);

		MimeMessage m=new MimeMessage(session);
		try {
			m.setFrom(from);
			m.setSubject(subject);
			m.setText(messg);
			m.setRecipients(RecipientType.TO, to);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			MimeMultipart m2=new MimeMultipart();

			File file = new File(System.getProperty("user.dire"));
			MimeBodyPart textbody=new MimeBodyPart();

			textbody.setText(messg);

			MimeBodyPart Filebody=new MimeBodyPart();

			Filebody.attachFile(file);


			m2.addBodyPart(textbody);

			m2.addBodyPart(Filebody);
			
			m.setContent(m2);
			Transport.send(m);
		}catch(Exception e) {
			e.printStackTrace();
		}


		System.out.println("===================================Email Send==================================");
	}
}
