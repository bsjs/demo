package com.demo.maildemo.mail.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailEntity {

	@Value("${spring.mail.host}")
	private String mailHost;
	
	@Value("${spring.mail.username}")
	private String userName;
	
	@Value("${spring.mail.password}")
	private String passwd;
	
	public void setMailHost(String mailHost)
	{
		this.mailHost = mailHost;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setPassWord(String passwd)
	{
		this.passwd = passwd;
	}
	
	public String getMailHost()
	{
		return this.mailHost;
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public String setPassWord()
	{
		return this.passwd;
	}
}
