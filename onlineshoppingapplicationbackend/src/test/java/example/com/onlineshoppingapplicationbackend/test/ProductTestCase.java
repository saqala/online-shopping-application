package example.com.onlineshoppingapplicationbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.com.onlineshoppingapplicationbackend.dao.ProductDao;
import example.com.onlineshoppingapplicationbackend.dto.Product;



public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDao productDAO;
	
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("example.com.onlineshoppingapplicationbackend");
		context.refresh();
		productDAO = (ProductDao) context.getBean("productDao");
	}

	@Test
	public void testCRUDProduct() {

		// create operation
		product = new Product();

		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Successfully added a product!", true, productDAO.add(product));

		// reading and updating the category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Successfully updated a product!", true, productDAO.update(product));

		assertEquals("Successfully deleted a product!", true, productDAO.delete(product));

		// list
		assertEquals("Successfully fetched all products", 6, productDAO.list().size());

	}

}
