package com.itwill.user;

import org.springframework.mail.javamail.JavaMailSender;

public interface MailService {
	
	boolean mailsender(String user_id, String invi_email) throws Exception;

}
