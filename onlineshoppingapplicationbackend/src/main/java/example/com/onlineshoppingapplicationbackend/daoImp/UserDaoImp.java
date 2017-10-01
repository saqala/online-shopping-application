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
		return false;
	}

	@Override
	public boolean addCart(Cart cart) {
		sessionFactory.getCurrentSession().persist(cart);
		return false;
	}

}
