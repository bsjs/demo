package com.demo.maildemo.mail.timetask;

import java.io.IOException;
import java.util.TimerTask;

import javax.mail.MessagingException;

import com.demo.maildemo.mail.util.MailUtil;

public class timeTask extends TimerTask{

	MailUtil mailUtil = new MailUtil();	

	@Override
	public void run() {
		int result = -1;
		
		try {
			System.out.print("test-->task");
			result =  mailUtil.reciveMail();
			} catch (MessagingException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("test-->"+Integer.toString(result));	
	}

}
