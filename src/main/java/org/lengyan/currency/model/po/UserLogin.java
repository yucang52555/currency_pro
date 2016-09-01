package org.lengyan.currency.model.po;

/**
 * tb_user_login 实体类
 * 2016-09-01 冷眼
 */ 
public class UserLogin{
	private long id;
	private String login_name;
	private String pass_word;

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setLogin_name(String login_name){
		this.login_name = login_name;
	}

	public String getLogin_name(){
		return login_name;
	}

	public void setPass_word(String pass_word){
		this.pass_word = pass_word;
	}

	public String getPass_word(){
		return pass_word;
	}

}

