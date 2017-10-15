package com.demo.maildemo.mail;

import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.demo.maildemo.mail.timetask.task;
import com.demo.maildemo.mail.timetask.timeTask;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan
public class App 
{
    public static void main(String[] args )
    {
    	SpringApplication.run(App.class, args);
       // System.out.println( "Mail Service!" );
        
    	/*
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        
        executor.schedule(new task(), 3, TimeUnit.SECONDS);*/
    	Timer timer = new Timer();
    	timer.schedule(new timeTask(),1,1);
        System.out.println( "Mail Service!" );
    }
}
