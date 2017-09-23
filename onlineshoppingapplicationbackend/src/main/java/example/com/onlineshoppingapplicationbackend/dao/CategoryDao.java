package example.com.onlineshoppingapplicationbackend.dao;

import java.util.List;

import example.com.onlineshoppingapplicationbackend.dto.Category;

public interface CategoryDao {

	Boolean add(Category category);
	List<Category> listCategory();

	Category get(int id);
}
