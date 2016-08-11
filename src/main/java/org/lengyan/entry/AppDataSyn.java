package org.lengyan.entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDataSyn {

	public static void main(String[] args) throws InterruptedException {
		
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:init-data.xml");
        context.start();
        Thread.sleep(500);
        context.close();
        String stime = "2016-07-01 00:00";//起始时间 >=
        String etime = "2016-07-31 00:00";//结束时间  <
        System.out.println( "数据操作 ...     起始时间："+stime+"   结束时间："+etime ); // 显示调用结果
	}

}
