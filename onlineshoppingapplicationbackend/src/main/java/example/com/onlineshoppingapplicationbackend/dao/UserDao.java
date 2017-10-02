package example.com.onlineshoppingapplicationbackend.dao;

import java.util.List;

import example.com.onlineshoppingapplicationbackend.dto.Address;
import example.com.onlineshoppingapplicationbackend.dto.Cart;
import example.com.onlineshoppingapplicationbackend.dto.User;

public interface UserDao {
	
	// user related operation
	User getByEmail(String email);
	User get(int id);

	boolean add(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	boolean updateCart(Cart cart);
	

}
