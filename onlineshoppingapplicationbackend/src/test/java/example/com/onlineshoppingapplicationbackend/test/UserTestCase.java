package example.com.onlineshoppingapplicationbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.com.onlineshoppingapplicationbackend.dao.UserDao;
import example.com.onlineshoppingapplicationbackend.dto.Address;
import example.com.onlineshoppingapplicationbackend.dto.Cart;
import example.com.onlineshoppingapplicationbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("example.com.onlineshoppingapplicationbackend");
		context.refresh();
		
		userDao = (UserDao) context.getBean("userDao");
	}
	
/*	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
				
		if(user.getRole().equals("USER")) {
			
			cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			

		}

		// add the user
		assertEquals("Failed to add the user!", true, userDao.addUser(user));	
	}*/
	
/*	@Test
	public void testUpdateCart() {
		user = userDao.getByEmail("hr@gmail.com");
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDao.UpdateCart(cart));			
	} */
	
/*	@Test
	public void testAddAddress() {
		user = userDao.get(1);
		
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressLineTwo("Near Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400000");
				
		address.setUser(user);
		// add the address
		assertEquals("Failed to add the address!", true, userDao.addAddress(address));	
	}*/
/*	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		cart = new Cart();
		
		// linked the address with the user
		address.setUser(user);
		
		// linked the cart with the user
		cart.setUser(user);
		// link the user with the cart
		user.setCart(cart);
		
		// add the user
		assertEquals("Failed to add the user!", true, userDao.add(user));	
		// add the address
		assertEquals("Failed to add the billing address!", true, userDao.addAddress(address));

				
		// add the shipping address
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setUser(user);
		assertEquals("Failed to add the shipping address!", true, userDao.addAddress(address));
		
	}*/
	
	@Test
	public void testUpdateCart() {
		user = userDao.get(1);
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDao.updateCart(cart));			
	} 

}
