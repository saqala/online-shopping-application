package example.com.onlineshoppingapplicationbackend.dao;

import example.com.onlineshoppingapplicationbackend.dto.Address;
import example.com.onlineshoppingapplicationbackend.dto.Cart;
import example.com.onlineshoppingapplicationbackend.dto.User;

public interface UserDao {
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);

}
