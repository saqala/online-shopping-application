package example.com.onlineshoppingapplicationbackend.dao;

import example.com.onlineshoppingapplicationbackend.dto.Visitor;

public interface VisitorDao {

	// user related operation
	Visitor getByEmail(String email);

	Visitor get(int id);

	boolean add(Visitor visitor);

}
