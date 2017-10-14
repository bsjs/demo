package com.demo.maildemo.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.maildemo.mail.util.MailUtil;

@RestController
public class MailController {

	/**
	 * 邮件操作对象
	 */
	@Autowired
	private MailUtil mailUtil;
	
	@RequestMapping(value= "/email",method=RequestMethod.GET)
	public Object sendMail()
	{
		String sendTo = "*****@163.com";  
        String titel = "测试邮件标题";  
        String content = "测试邮件内容"; 
        
        mailUtil.sendSimpleMail(sendTo, titel, content);
		return "success";
	} 
}
