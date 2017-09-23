package example.com.onlineshoppingapplicationbackend.daoImp;

import java.util.ArrayList;
import java.util.List;


import javax.xml.ws.RespectBinding;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import example.com.onlineshoppingapplicationbackend.dao.CategoryDao;
import example.com.onlineshoppingapplicationbackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryImp implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();
	@Autowired
	private SessionFactory sessionfactory;
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
		String listCategory = "From Category Where active=:active";
		Query query = sessionfactory.getCurrentSession().createQuery(listCategory);
		query.setParameter("active",true);
		return query.getResultList();
		
	}
	@Override
	public Category get(int id) {
		return sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	@Override
	
	public Boolean add(Category category) {
		try {
			sessionfactory.getCurrentSession().persist(category);
			
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	@Override
	public Boolean update(Category category) {
		try {
			
			sessionfactory.getCurrentSession().update(category);
			
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	@Override
	public Boolean delete(Category category) {
try {
			category.setActive(false);
			sessionfactory.getCurrentSession().update(category);
			
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
