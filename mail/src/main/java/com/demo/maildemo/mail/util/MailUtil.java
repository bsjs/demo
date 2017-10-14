package com.demo.maildemo.mail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailUtil {

	/**
	 * mail的代理对象
	 */
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * 发送者
	 */
	@Autowired
	private MailEntity mailEntity; 
	
	
	/**
	 * 发送简单邮件
	 * @param sendTo
	 * @param titel
	 * @param content
	 */
	public void sendSimpleMail(String sendTo, String titel, String content) {  
        SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom(mailEntity.getUserName()); 
        message.setTo(sendTo);  
        message.setSubject(titel);  
        message.setText(content);  
        mailSender.send(message);  
    }  
}
