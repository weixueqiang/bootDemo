package wd.bt.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMain {

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new  AnnotationConfigApplicationContext(DemoConfiguration.class);
		DemoDao dao = ctx.getBean(DemoDao.class);
		List<String> listData = dao.listData();
		listData.forEach((o)->System.out.println(o));
		ctx.close();
	}
	
}
