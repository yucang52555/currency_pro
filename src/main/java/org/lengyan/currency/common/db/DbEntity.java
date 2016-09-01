package org.lengyan.currency.common.db;

/**
 * 数据库操作实体类
 * @author ktc
 * 2016年8月31日 下午5:53:02
 */
public class DbEntity {
	
	private String url;//url
	
	private String userName;//登录用户名
	
	private String passWord;//登录密码
	
	private String driverClass;//驱动类
	
	public DbEntity(){}
	
	public DbEntity(String url, String userName, String passWord, String driverClass) {
		this.url = url;
		this.userName = userName;
		this.passWord = passWord;
		this.driverClass = driverClass;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getDriverClass() {
		return driverClass;
	}
	
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
}
