package org.lengyan.currency.model.po;

/**
 * tb_user_login 实体类
 * 2016-09-01 冷眼
 */ 
public class UserLogin{
	private long id;
	private String loginName;
	private String passWord;

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setLoginName(String loginName){
		this.loginName = loginName;
	}

	public String getLoginName(){
		return loginName;
	}

	public void setPassWord(String passWord){
		this.passWord = passWord;
	}

	public String getPassWord(){
		return passWord;
	}

}

