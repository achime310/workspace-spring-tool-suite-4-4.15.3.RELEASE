package com.itwill.user;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

	@Override
	public boolean mailsender( String user_id, String invi_email) throws Exception {
		
		System.out.println("param: "+user_id+invi_email);
		boolean b=false;
		JavaMailSenderImpl sender=new JavaMailSenderImpl();
		String id="browncarrotmarket@gmail.com";
		String passwd= "ltxxmvgyzxwwfgpc";
		
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername(id);
		sender.setPassword(passwd);
		sender.setDefaultEncoding("UTF-8");
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);


		/*
		 * javaMailProperties.put("mail.smtp.ssl.enable", true);
		 * javaMailProperties.put("mail.smtp.ssl.trust","smtp.gmail.com" );
		 */
		sender.setJavaMailProperties(javaMailProperties);
		
		MimeMessagePreparator preparator= new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(invi_email)); //수신 메일
				mimeMessage.setSubject("흙당근 마켓","UTF-8");
				mimeMessage.setText("흙당근 마켓 메일 테스트입니다","UTF-8");
			}
		};
		
		try {
			sender.send(preparator);
			b=true;
		}
		catch(MailException mex){
			System.out.println(mex.getMessage());
		}


		
		return b ;


	}

}
