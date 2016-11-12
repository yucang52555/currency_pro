package org.lengyan.currency.common.mail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.lengyan.currency.common.utils.CommonUtils;

/**
 * 邮件发送器
 * @author ktc
 * 2016年10月22日 下午5:53:57
 */
public class MailSender {
	/**
	 * 发送简易版文本邮件
	 * @param mailSenderInfo
	 * @return
	 * @throws EmailException 
	 */
	public boolean sendTextEmail(MailInfo mailInfo) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName(mailInfo.getMailServerHost());
		email.setSmtpPort(mailInfo.getMailServerPort());
		MailAuthenticator mailAuthenticator = new MailAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		email.setAuthenticator(mailAuthenticator);
		email.setSSLOnConnect(true);
		email.setFrom(mailInfo.getFromAddress());
        email.setSubject(mailInfo.getSubject());
        email.setMsg(mailInfo.getContent());
        email.addTo(mailInfo.getToAddress());
        email.send();  
		return true;
	}
	
	/**
	 * 发送简易版文本格式，带附件邮件
	 * @param mailInfo
	 * @return
	 * @throws EmailException
	 */
	public boolean sendAttachEmail(MailInfo mailInfo) throws EmailException {
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(mailInfo.getMailServerHost());
		email.addTo(mailInfo.getToAddress());
		email.setFrom(mailInfo.getFromAddress());
		email.setSubject(mailInfo.getSubject());
		email.setMsg(mailInfo.getContent());
		MailAuthenticator mailAuthenticator = new MailAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		email.setAuthenticator(mailAuthenticator);
		
		List<EmailAttachment> emailAttachments = mailInfo.getAttachmentFile();
		int size = CommonUtils.sizeOf(emailAttachments);
		for (int i = 0; i < size; i++) {
			email.attach(emailAttachments.get(i));
		}
		email.send();
		return true;
	}
	
	/**
	 * 发送Html格式邮件
	 * 该行为存在以下安全隐患：
	 * 	1） 邮件客户端未经有效识别，不能有效保证帐户安全性，存在帐号密码泄漏的风险；
	 * 	2） 数据传输安全性低，存在数据泄漏风险。
	 * @param mailInfo
	 * @return
	 * @throws EmailException
	 * @throws MalformedURLException 
	 */
	public boolean sendHtmlEmail(MailInfo mailInfo) throws EmailException, MalformedURLException {
		HtmlEmail email = new HtmlEmail();
		email.setHostName(mailInfo.getMailServerHost());
		email.addTo(mailInfo.getToAddress());
		email.setFrom(mailInfo.getFromAddress());
		email.setSubject(mailInfo.getSubject());
		email.setMsg(mailInfo.getContent());
		
		MailAuthenticator mailAuthenticator = new MailAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		email.setAuthenticator(mailAuthenticator);
		
		URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
		String cid = email.embed(url, "Apache logo");
		email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");
		email.setTextMsg("Your email client does not support HTML messages");
		
		email.send();
		return true;
	}
}
