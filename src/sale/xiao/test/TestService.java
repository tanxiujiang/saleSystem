package sale.xiao.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sale.xiao.serviceInter.AdminServiceInter;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:META-INF/applicationContext.xml")
//@ContextConfiguration(locations="classpath:E:/git/github/saleSystem/META-INF/applicationContext.xml")
public class TestService {
	
	@Resource
	private AdminServiceInter adminService;

	@Test
	public void testHello(){
		//System.out.println(adminService.sayHello("harry"));
	}
	
	
	@Test
	public void TestAdminService(){
		 ApplicationContext context = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/applicationContext.xml");
		 AdminServiceInter userService = (AdminServiceInter)context.getBean("adminService");
         System.out.println(userService.GetStores());
	}
}
