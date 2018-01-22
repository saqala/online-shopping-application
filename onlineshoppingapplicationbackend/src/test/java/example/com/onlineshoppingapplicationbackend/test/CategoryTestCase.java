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
	
/*	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("fourth category");
		category.setDescription("Description of fourth Category");
		category.setImageUrl("URL Image of fourth category");
		
		assertEquals("Successfuly added fourth category", true, categoryDao.add(category));
	}
	
	@Test
	public void testGetCategory() {
		
		category = categoryDao.get(1);
		
		assertEquals("Successfuly fetched fourth category", "fourth category", category.getName());
	}
	
	@Test
	public void testUpdateCategory() {
		
		category = categoryDao.get(1);
		category.setName("fourth");
		assertEquals("Successfuly Updated fourth category", true, categoryDao.update(category));
	}
	
	@Test
	public void testDeleteCategory() {
		
		category = categoryDao.get(1);
		
		assertEquals("Successfuly Updated fourth category", true, categoryDao.delete(category));
	}
	
	@Test
	public void testListCategory() {
		
		
		
		assertEquals("Successfuly retrieved all Active categories", Integer.valueOf(0), Integer.valueOf(categoryDao.listCategory().size()));
	}*/
	
	@Test
	public void testCRUDOperations() {
		
		category = new Category();
		
		category.setName("fourth category");
		category.setDescription("Description of fourth Category");
		category.setImageUrl("URL Image of fourth category");
		
		
		assertEquals("Successfuly added fourth category", true, categoryDao.add(category));		
		
		category = categoryDao.get(1);
		
		assertEquals("Successfuly fetched fourth category", "fourth", category.getName());
		
		category.setName("fourth");
		assertEquals("Successfuly Updated fourth category", true, categoryDao.update(category));
		assertEquals("Successfuly Updated fourth category", true, categoryDao.delete(category));
		assertEquals("Successfuly retrieved all Active categories", Integer.valueOf(9), Integer.valueOf(categoryDao.listCategory().size()));

		
	}
	
		
}
