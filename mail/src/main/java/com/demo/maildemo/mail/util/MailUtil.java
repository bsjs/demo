package com.demo.maildemo.mail.util;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

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
	
	public int reciveMail() throws MessagingException
	{
		//配置连接协议
		Properties properties = new Properties();
		properties.setProperty("mail.pop3.host", mailEntity.getMailHost());
		properties.setProperty("mail.store.protocol", mailEntity.getProtocol());
		
		//获取一个会话
		Session session = Session.getInstance(properties);
		session.setDebug(true);
		
		//打开邮件文件夹
		Store store = session.getStore();
		store.connect(mailEntity.getMailHost(),mailEntity.getUserName(),mailEntity.getPassWord());
		
		//获取邮箱内的邮件夹Floder对象，以“只读”打开
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		
		//获取邮件夹Folder内所有的邮件Message对象
		Message [] messages = folder.getMessages();
		
		System.out.print(messages.length);
		return messages.length;
	}
}
