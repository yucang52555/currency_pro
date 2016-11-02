package org.lengyan.entry.mail;

import java.net.MalformedURLException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.lengyan.currency.common.mail.MailSender;
import org.lengyan.currency.common.mail.MailInfo;

public class SendMail {
	
	public static void main(String[] args) throws EmailException, GeneralSecurityException, MalformedURLException {
//		send_163_text_apache();
//		send_163_attach_apache();
		send_163_html_apache();
	}
	
	public static void send_163_text_apache() throws EmailException {
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
	
	public static void send_163_attach_apache() throws EmailException {
		//邮件基本信息
		MailInfo mailInfo = new MailInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort(25);
		mailInfo.setUserName("kangtiancheng002");
		mailInfo.setPassword("ktc123456");
		mailInfo.setFromAddress("kangtiancheng002@163.com");
		mailInfo.setSubject("测试附件邮件2");
		mailInfo.setContent("测试一下邮箱发送工具类2 :-)");
		mailInfo.setToAddress("kangtiancheng001@163.com");
		//添加附件
		List<EmailAttachment> attachmentFiles = new ArrayList<EmailAttachment>();
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:\\Users\\Dell\\Downloads\\152114779941825751.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("邮件附件描述2");
		attachment.setName("152114779941825751.jpg");
		attachmentFiles.add(attachment);

		
		mailInfo.setAttachmentFile(attachmentFiles);
		MailSender mailSender = new MailSender();
		mailSender.sendAttachEmail(mailInfo);
	}
	
	public static void send_163_html_apache() throws EmailException, MalformedURLException {
		//邮件基本信息
		MailInfo mailInfo = new MailInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort(25);
		mailInfo.setUserName("kangtiancheng002");
		mailInfo.setPassword("ktc123456");
		mailInfo.setFromAddress("kangtiancheng002@163.com");
		mailInfo.setSubject("测试附件邮件2");
		mailInfo.setContent("测试一下邮箱发送工具类2 :-)");
		mailInfo.setToAddress("kangtiancheng001@163.com");

		MailSender mailSender = new MailSender();
		mailSender.sendHtmlEmail(mailInfo);
	}
}
