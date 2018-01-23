package example.com.onlineshoppingapplicationbackend.daoImp;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import example.com.onlineshoppingapplicationbackend.dao.UserDao;
import example.com.onlineshoppingapplicationbackend.dao.VisitorDao;
import example.com.onlineshoppingapplicationbackend.dto.Address;
import example.com.onlineshoppingapplicationbackend.dto.Cart;
import example.com.onlineshoppingapplicationbackend.dto.User;
import example.com.onlineshoppingapplicationbackend.dto.Visitor;




@Repository("visitorDao")
@Transactional
public class VisitorDAOImpl implements VisitorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Visitor getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Visitor.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
							
	}

	@Override
	public boolean add(Visitor visitor) {
		try {			
			sessionFactory.getCurrentSession().persist(visitor);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	
	@Override
	public Visitor get(int id) {
		try {			
			return sessionFactory.getCurrentSession().get(Visitor.class, id);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	

}
