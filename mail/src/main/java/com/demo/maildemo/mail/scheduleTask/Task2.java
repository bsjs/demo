package com.demo.maildemo.mail.scheduleTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task2 {
	private static final Logger logger = LoggerFactory.getLogger(Task.class);
	 
    //@Scheduled(cron="0 0/2 * * * ?")
	@Scheduled(fixedRate=1000)
    public void executeFileDownLoadTask() {
 
        // 间隔2分钟,执行任务    
        Thread current = Thread.currentThread(); 
        System.out.println("定时任务2:"+current.getId());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务2:"+current.getId()+ ",name:"+current.getName());
    }
}
