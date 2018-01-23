package example.com.onlineshoppingapplicationbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.com.onlineshoppingapplicationbackend.dao.UserDao;
import example.com.onlineshoppingapplicationbackend.dao.VisitorDao;
import example.com.onlineshoppingapplicationbackend.dto.Address;
import example.com.onlineshoppingapplicationbackend.dto.Cart;
import example.com.onlineshoppingapplicationbackend.dto.User;
import example.com.onlineshoppingapplicationbackend.dto.Visitor;

public class VisitorTestCase {
	private static AnnotationConfigApplicationContext context;
	private static VisitorDao visitorDao;
	private Visitor visitor = null;

	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("example.com.onlineshoppingapplicationbackend");
		context.refresh();
		
		visitorDao = (VisitorDao) context.getBean("visitorDao");
	}
	
	@Test
	public void testAddUser() {
		
		visitor = new Visitor() ;
		visitor.setFirstName("Ilias");		
		visitor.setEmail("iliasvfx@live.fr");
		visitor.setContactNumber("1234512345");
		visitor.setSubject("complaint");
		visitor.setMessage("Sir, you need to improve your website.");


		// add the visitor
		assertEquals("Failed to add the visitor!", true, visitorDao.add(visitor));	
	}
	


}
