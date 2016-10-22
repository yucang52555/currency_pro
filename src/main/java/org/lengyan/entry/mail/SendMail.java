package org.lengyan.entry.mail;

import java.security.GeneralSecurityException;

import org.apache.commons.mail.EmailException;
import org.lengyan.currency.common.mail.MailSender;
import org.lengyan.currency.common.mail.MailInfo;

public class SendMail {
	
	public static void main(String[] args) throws EmailException, GeneralSecurityException {
		send_163_apache();
	}
	
	public static void send_163_apache() throws EmailException {
		MailInfo mailInfo = new MailInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort(25);
		mailInfo.setUserName("kangtiancheng002");
		mailInfo.setPassword("ktc123456");
		mailInfo.setFromAddress("kangtiancheng002@163.com");
		mailInfo.setSubject("测试邮件");
		mailInfo.setContent("测试一下邮箱发送工具类 :-)");
		mailInfo.setToAddress("kangtiancheng001@163.com");
		MailSender mailSender = new MailSender();
		mailSender.sendTextEmail(mailInfo);
	}
}
