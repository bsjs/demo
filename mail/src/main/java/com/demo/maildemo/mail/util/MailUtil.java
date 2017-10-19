package com.demo.maildemo.mail.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

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
	
	public int reciveMail() throws MessagingException, IOException
	{
		int size = -1;
		//配置连接协议
		Properties properties = new Properties();
		properties.setProperty("mail.pop3.host", mailEntity.getMailHost());
		properties.setProperty("mail.store.protocol", mailEntity.getProtocol());
		
		//获取一个会话
		Session session = Session.getInstance(properties);
		//session.setDebug(true);
		
		//打开邮件文件夹
		Store store = session.getStore();
		store.connect(mailEntity.getMailHost(),mailEntity.getUserName(),mailEntity.getPassWord());
		
		//获取邮箱内的邮件夹Floder对象，以“只读”打开
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		
		//pop3 不支持了
		Flags flag = folder.getPermanentFlags();
		System.out.print("all mail count"+"-->"+Integer.toString(folder.getMessageCount())+"\n");
		
		//获取邮件夹Folder内所有的邮件Message对象
		Message [] messages = folder.getMessages();
		
		printMail(messages);
		size = folder.getMessageCount();
		
		System.out.print("new mail"+"-->"+Integer.toString(folder.getNewMessageCount()));
		System.out.print("unread mail"+"-->"+Integer.toString(folder.getUnreadMessageCount()));
		//设置已读属性
		for(int i=0;i<size;i++)
		{
			messages[i].setFlag(Flags.Flag.SEEN, true);
		}
		
		size = folder.getUnreadMessageCount();
        //size = messages.length;
		System.out.print("test"+ "-->"+ Integer.toString(size));
		
		
		size = folder.getMessageCount();
		System.out.print("test"+ "-->"+ Integer.toString(size));
		
		
		
		//关闭资源
		folder.close(false);
		store.close();
		return size;
	}
	
	public void printMail(Message[] messages) throws IOException, MessagingException
	{
	     Message message = messages[0];
	     
	     //复合类型
	     if(message.isMimeType("multipart/*"))
	     {
	    	 Multipart multipart = (Multipart) message.getContent();
	    	 
	    	 for(int i=0;i<multipart.getCount();i++)
	    	 {
	    		 BodyPart bodyPart = multipart.getBodyPart(i);
	    		 if(bodyPart.isMimeType("text/plain"))
	    		 {
	    			 String[] string = bodyPart.getContent().toString().split("\n");
	    			 for(int j= 0 ;j<string.length;j++)
	    			 {
	    			 
	    				 System.out.print("index" +Integer.toString(j) + " "+ string[j]);
	    			 }
	    		 }
	    	 }
	     }
	     /*
	     String[] string = (message.toString()).split("/n");
	     
	     for(String s:string)
	     {
	    	 System.out.println(s);
	     }
	     */
	}
}
