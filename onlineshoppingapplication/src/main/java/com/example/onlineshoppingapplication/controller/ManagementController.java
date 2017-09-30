package com.example.onlineshoppingapplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import example.com.onlineshoppingapplicationbackend.dao.CategoryDao;
import example.com.onlineshoppingapplicationbackend.dao.ProductDao;
import example.com.onlineshoppingapplicationbackend.dto.Category;
import example.com.onlineshoppingapplicationbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productao;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");

		
		Product nProduct = new Product();
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully");
			}
		}
		return mv;

	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		return categoryDao.listCategory();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product mProduct) {
		
		logger.info(mProduct.toString());
		productao.add(mProduct);
		
		return "redirect:/manage/products?operation=product";
	}
}
