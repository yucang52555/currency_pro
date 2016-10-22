package org.lengyan.currency.common.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
}
