package example.com.onlineshoppingapplicationbackend.dao;

import java.util.List;

import example.com.onlineshoppingapplicationbackend.dto.Category;

public interface CategoryDao {

	List<Category> listCategory();

	Category get(int id);
}
