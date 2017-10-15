package com.demo.maildemo.mail.timetask;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.maildemo.mail.util.MailUtil;

public class task implements Runnable{

	@Autowired
	MailUtil mailUtil;	

	@Override
	public void run() {
		int result = -1;
		
		try {
			System.out.print("test-->task");
			result =  mailUtil.reciveMail();
			} catch (MessagingException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			}
			System.out.print("test-->"+Integer.toString(result));	
	}
}
