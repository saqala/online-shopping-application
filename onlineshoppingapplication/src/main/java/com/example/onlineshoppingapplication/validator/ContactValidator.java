package com.example.onlineshoppingapplication.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import example.com.onlineshoppingapplicationbackend.dto.Product;
import example.com.onlineshoppingapplicationbackend.dto.Visitor;

public class ContactValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Visitor.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors error) {
			Product product = (Product) arg0;
			
			if(product.getFile().getOriginalFilename().equals("") || product.getFile() == null) {
				error.rejectValue("file", null, "Please select an image file to upload!");
				return;
			}
			
			if(! (product.getFile().getContentType().equals("image/jpeg") || 
					product.getFile().getContentType().equals("image/png")) ||
					product.getFile().getContentType().equals("image/gif")
				 )
				{
				error.rejectValue("file", null, "Please select an image file to upload!");
					return;	
				}
	}
	
	

}
