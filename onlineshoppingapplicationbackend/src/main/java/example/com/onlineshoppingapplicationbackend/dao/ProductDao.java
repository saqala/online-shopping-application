package example.com.onlineshoppingapplicationbackend.dao;

import java.util.List;

import example.com.onlineshoppingapplicationbackend.dto.Product;


public interface ProductDao {

	Product get(int productId);
	List<Product> list();	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	// business methods
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);

}
