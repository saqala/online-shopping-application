package com.example.onlineshoppingapplication.model;

import java.io.Serializable;
import java.util.List;

import example.com.onlineshoppingapplicationbackend.dto.Address;
import example.com.onlineshoppingapplicationbackend.dto.Category;
import example.com.onlineshoppingapplicationbackend.dto.User;

public class RegisterModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Category> cat;
	public List<Category> getCat() {
		return cat;
	}
	public void setCat(List<Category> cat) {
		this.cat = cat;
	}
	private User user;
	private Address billing;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
		
}
