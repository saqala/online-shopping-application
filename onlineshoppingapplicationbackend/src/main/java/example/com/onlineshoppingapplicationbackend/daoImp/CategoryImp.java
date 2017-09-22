package example.com.onlineshoppingapplicationbackend.daoImp;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.RespectBinding;

import org.springframework.stereotype.Repository;

import example.com.onlineshoppingapplicationbackend.dao.CategoryDao;
import example.com.onlineshoppingapplicationbackend.dto.Category;

@Repository
public class CategoryImp implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("first");
		category.setDescription("describe first");
		category.setImageUrl("first.png");		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("second");
		category.setDescription("describe second");
		category.setImageUrl("second.png");		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("thrid");
		category.setDescription("describe third");
		category.setImageUrl("third.png");		
		categories.add(category);
		
	}
	@Override
	public List<Category> listCategory() {
		System.out.println(categories.get(1).getName());
		return categories;
	}
	@Override
	public Category get(int id) {
		for (Category category : categories) {
			
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
