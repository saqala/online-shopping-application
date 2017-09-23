package example.com.onlineshoppingapplicationbackend.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.Temporal;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.com.onlineshoppingapplicationbackend.dao.CategoryDao;
import example.com.onlineshoppingapplicationbackend.dto.Category;

public class CategoryTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("example.com.onlineshoppingapplicationbackend");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	
	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("fourth category");
		category.setDescription("Description of fourth Category");
		category.setImageUrl("URL Image of fourth category");
		
		assertEquals("Successfuly added fourth category", true, categoryDao.add(category));
	}
		
}
