package org.lengyan.entry.genEntity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import org.apache.log4j.Logger;
import org.lengyan.currency.common.db.DbEntity;
import org.lengyan.currency.common.db.DbHelper;
import org.lengyan.currency.common.utils.DateUtils;
import org.lengyan.currency.common.utils.FileUtils;

/**
 * 根据mysql的表生成实体类
 * @author ktc
 * 2016年8月11日 下午8:10:15
 */
public class GenEntityFromMysql {
	
	private static final Logger LOG = Logger.getLogger(GenEntityFromMysql.class);
	
	private String[] colnames; // 列名数组
	private String[] colTypes; //列名类型数组
	private int[] colSizes; //列名大小数组
	private boolean f_util = false; // 是否需要导入包java.util.*
	private boolean f_sql = false; // 是否需要导入包java.sql.*

	private String packageOutPath = "org.lengyan.currency.model.po";//指定实体生成所在包的路径
	private String authorName = "冷眼";//作者名字
	private String tablename = "tb_user_login";//表名
	private String entityName = "UserLogin";//实体类名称
	private String sql = "select * from " + tablename;

	public static void main(String[] args) {
		new GenEntityFromMysql();
	}
	
	/**
	 * 数据库数据初始化
	 */
	private void baseDataInit() {
		PreparedStatement pStemt = null;
		try {
			DbHelper dbHelper = new DbHelper();
			DbEntity dbEntity = dbHelper.initDbEntity();
			try {
				Class.forName(dbEntity.getDriverClass());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			Connection con = dbHelper.getConnection();
			pStemt = con.prepareStatement(sql);
			ResultSetMetaData rsmd = pStemt.getMetaData();
			int size = rsmd.getColumnCount();//统计列
			colnames = new String[size];
			colTypes = new String[size];
			colSizes = new int[size];
			for (int i = 0; i < size; i++) {
				colnames[i] = rsmd.getColumnName(i + 1);
				colTypes[i] = rsmd.getColumnTypeName(i + 1);
				if(colTypes[i].equalsIgnoreCase("datetime")){
					f_util = true;
				}
				if(colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")){
					f_sql = true;
				}
				colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
			}
		} catch (Exception e) {
			LOG.info(e);
			throw new RuntimeException();
		}
	}
	
	/** 
	 * 解析生成实体类主体代码
	 * @param colnames
	 * @param colTypes
	 * @param colSizes
	 * @return
	 */
	private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
		StringBuffer sb = new StringBuffer();
		//判断是否导入工具包
		if(f_util){
			sb.append("import java.util.Date;\r\n");
		}
		if(f_sql){
			sb.append("import java.sql.*;\r\n");
		}
		sb.append("package " + this.packageOutPath + ";\r\n");
		sb.append("\r\n");
		//注释部分
		sb.append("/**\r\n");
		sb.append(" * " + tablename + " 实体类\r\n");
		sb.append(" * " + DateUtils.getCurDateStr() + " " + this.authorName+"\r\n");
		sb.append(" */ \r\n");
		//实体部分
		sb.append("public class " + entityName + "{\r\n");
		processAllAttrs(sb);//属性
		processAllMethod(sb);//get set方法
		sb.append("}\r\n");
		//System.out.println(sb.toString());
		return sb.toString();
	}

	/** 
	 * 生成所有属性 
	 * @param stringBuffer 
	 */
	private void processAllAttrs(StringBuffer stringBuffer) {
		for (int i = 0; i < colnames.length; i++) {
			stringBuffer.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colnames[i] + ";\r\n");
		}
		stringBuffer.append("\r\n");
	}
	
	/** 
	 * 生成所有方法 
	 * @param stringBuffer 
	 */
	private void processAllMethod(StringBuffer stringBuffer) {
		for (int i = 0; i < colnames.length; i++) {
			stringBuffer.append("\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " " + 
					colnames[i] + "){\r\n");
			stringBuffer.append("\t\tthis." + colnames[i] + " = " + colnames[i] + ";\r\n");
			stringBuffer.append("\t}\r\n\r\n");
			stringBuffer.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
			stringBuffer.append("\t\treturn " + colnames[i] + ";\r\n");
			stringBuffer.append("\t}\r\n\r\n");
		}
	}

	/** 
	 * 功能：将输入字符串的首字母改成大写 
	 * @param str 
	 * @return 
	 */
	private String initcap(String str) {
		char[] ch = str.toCharArray();
		if(ch[0] >= 'a' && ch[0] <= 'z'){
			ch[0] = (char)(ch[0] - 32);
		}
		return new String(ch);
	}

	/** 
	 * 功能：获得列的数据类型 
	 * @param sqlType 
	 * @return 
	 */
	private String sqlType2JavaType(String sqlType) {
		if(sqlType.equalsIgnoreCase("bit")){
			return "boolean";
		}else if(sqlType.equalsIgnoreCase("tinyint")){
			return "byte";
		}else if(sqlType.equalsIgnoreCase("smallint")){
			return "short";
		}else if(sqlType.equalsIgnoreCase("int")){
			return "int";
		}else if(sqlType.equalsIgnoreCase("bigint")){
			return "long";
		}else if(sqlType.equalsIgnoreCase("float")){
			return "float";
		}else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") 
				|| sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money") 
				|| sqlType.equalsIgnoreCase("smallmoney")){
			return "double";
		}else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") 
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar") 
				|| sqlType.equalsIgnoreCase("text")){
			return "String";
		}else if(sqlType.equalsIgnoreCase("datetime")){
			return "Date";
		}else if(sqlType.equalsIgnoreCase("image")){
			return "Blod";
		}
		return null;
	}

	public GenEntityFromMysql() {
		baseDataInit();
		String content = parse(colnames,colTypes,colSizes);
		try {
			File directory = new File("");
			//System.out.println("绝对路径："+directory.getAbsolutePath());
			//System.out.println("相对路径："+directory.getCanonicalPath());
			String path=this.getClass().getResource("").getPath();
			System.out.println(path);
			System.out.println("src/?/"+path.substring(path.lastIndexOf("/org/", path.length())) );
			//String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initcap(tablename) + ".java";
			String outputPath = directory.getAbsolutePath()+ "\\src\\main\\java\\"+this.packageOutPath.replace(".", "\\")+"\\"+initcap(entityName) + ".java";
			System.out.println(outputPath);
			FileUtils.createNewFile(outputPath);
			FileWriter fw = new FileWriter(outputPath);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(content);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
