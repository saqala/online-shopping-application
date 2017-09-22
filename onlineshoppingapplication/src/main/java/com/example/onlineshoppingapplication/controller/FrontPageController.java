package com.example.onlineshoppingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import example.com.onlineshoppingapplicationbackend.dao.CategoryDao;
import example.com.onlineshoppingapplicationbackend.dto.Category;

@Controller
public class FrontPageController {

	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value= {"/", "home","index"} )
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDao.listCategory());
		return mv;
	}
	
	@RequestMapping(value= "/about" )
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");		
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= "/contact" )
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");		
		mv.addObject("userClickContact", true);
		return mv;
	}
	
/*	@RequestMapping(value= {"testvariable"} )
	public ModelAndView test(@RequestParam(value="greetings", required=false) String sc) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greetings", sc);
		return mv;
	}*/
	
/*	@RequestMapping(value= {"/testvariable/{greetings}"} )
	public ModelAndView test(@PathVariable(value="greetings") String sc) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greetings", sc);
		return mv;
	}*/
	
	@RequestMapping(value= {"/show/all/products"} )
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDao.listCategory());
		return mv;
	}
	
	
	@RequestMapping(value= {"/show/category/{id}/products"} )
	public ModelAndView showCategory(@PathVariable("id") int id) {
		Category category = null;
		category = categoryDao.get(id);		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("category", category);
		mv.addObject("categories", categoryDao.listCategory());
		return mv;
	}
	
}
