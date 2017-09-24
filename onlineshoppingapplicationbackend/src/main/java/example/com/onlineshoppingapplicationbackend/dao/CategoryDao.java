package example.com.onlineshoppingapplicationbackend.dao;

import java.util.List;

import example.com.onlineshoppingapplicationbackend.dto.Category;

public interface CategoryDao {

	Boolean add(Category category);
	List<Category> listCategory();
	List<Category> list();
	Category get(int id);
	Boolean update(Category category);
	Boolean delete(Category category);
	
	
}
