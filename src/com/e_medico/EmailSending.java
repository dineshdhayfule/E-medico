package com.e_medico;

import javax.mail.*;


import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import java.util.Properties;

public class EmailSending {
	
	public void sendEmail(String to)
	{
		String message = "EMEDICO APP SERVICES ";
		String subject = "MEDICINE LISTS";
		
		String from = "dineshdhayfule@gmail.com";
		System.out.println("Preparing to send message");
		
		String host = "smtp.gmail.com";
		Properties p = System.getProperties();
		System.out.println("Properties = "+p);
		
		p.put("mail.smtp.host", host);
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.auth", "true");
		Session s = Session.getInstance(p, new Authenticator()
				{

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("dineshdhayfule@gmail.com","tyjitkuuqrlwlrbl");
					}
			
				});
		MimeMessage m = new MimeMessage(s);
		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);
			Transport.send(m);
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Completed");
		}
	}
}