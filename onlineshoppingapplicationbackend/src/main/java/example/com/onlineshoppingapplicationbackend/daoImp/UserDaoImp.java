package example.com.onlineshoppingapplicationbackend.daoImp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import example.com.onlineshoppingapplicationbackend.dao.UserDao;
import example.com.onlineshoppingapplicationbackend.dto.Address;
import example.com.onlineshoppingapplicationbackend.dto.Cart;
import example.com.onlineshoppingapplicationbackend.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImp implements UserDao {

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
		return true;
	}

	@Override
	public boolean addAddress(Address address) {
		sessionFactory.getCurrentSession().persist(address);
		return true;
	}



	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class)
					.setParameter("email", email).
					getSingleResult();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean UpdateCart(Cart cart) {
		sessionFactory.getCurrentSession().update(cart);
		return true;
	}



}
