package org.lengyan.currency.common.mail;

import javax.mail.*;

/**
 * 账号验证
 * @author ktc
 * 2016年10月22日 下午4:47:29
 */
public class MailAuthenticator extends Authenticator {
	
	private String username;//用户名
	
	private String password;//密码
	
	public MailAuthenticator() {
	}

	/**
	 * 创建一个新的实例 MailAuthenticator.
	 * @param username
	 * @param password
	 */
	public MailAuthenticator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
