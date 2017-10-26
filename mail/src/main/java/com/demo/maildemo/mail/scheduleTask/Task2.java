package com.demo.maildemo.mail.scheduleTask;

import java.io.IOException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.maildemo.mail.util.MailUtil;

@Component
public class Task2 {
	private static final Logger logger = LoggerFactory.getLogger(Task.class);
	@Autowired
	MailUtil mailUtil;
    //@Scheduled(cron="0 0/2 * * * ?")
	@Scheduled(fixedRate=5000)
    public void executeFileDownLoadTask() {
 
		int result = -1;
		try {
			System.out.print("-------task-------------"+"\n");
			Thread current = Thread.currentThread(); 
	        System.out.println("定时任务2:"+current.getId());
			result =  mailUtil.reciveMail();
			} catch (MessagingException e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("----------test-->"+Integer.toString(result));
    }
}
