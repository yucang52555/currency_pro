package org.lengyan.currency.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.lengyan.currency.common.utils.PropertyUtils;

/**
 * 
 * @author ktc
 * 2016年8月31日 下午5:52:00
 */
public class DbHelper {
	
	/**
	 * 初始化数据库操作参数实体类
	 * @return
	 */
	public DbEntity initDbEntity() {
		String url = PropertyUtils.getPropertyValue("database.url");
		String userName = PropertyUtils.getPropertyValue("database.username");
		String passWord = PropertyUtils.getPropertyValue("database.password");
		String driverClass = PropertyUtils.getPropertyValue("database.driverClassName");
		return new DbEntity(url, userName, passWord, driverClass);
	}
	
	public Connection getConnection() {
		DbEntity dbEntity = initDbEntity();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbEntity.getUrl(), dbEntity.getUserName(), dbEntity.getPassWord());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
