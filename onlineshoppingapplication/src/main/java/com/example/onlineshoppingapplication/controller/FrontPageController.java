package com.example.onlineshoppingapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.onlineshoppingapplication.Utils.FileUtil;
import com.example.onlineshoppingapplication.exception.ProductNotFoundException;
import com.example.onlineshoppingapplication.validator.ContactValidator;
import com.example.onlineshoppingapplication.validator.ProductValidator;

import example.com.onlineshoppingapplicationbackend.dao.CategoryDao;
import example.com.onlineshoppingapplicationbackend.dao.ProductDao;
import example.com.onlineshoppingapplicationbackend.dao.VisitorDao;
import example.com.onlineshoppingapplicationbackend.dto.Category;
import example.com.onlineshoppingapplicationbackend.dto.Product;
import example.com.onlineshoppingapplicationbackend.dto.Visitor;

@Controller
@RequestMapping("/")
public class FrontPageController {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private VisitorDao visitorDao;
	
	@Autowired
	private ProductDao productDao;
	
	private static final Logger logger = LoggerFactory.getLogger(FrontPageController.class);
	
	@RequestMapping(value= {"/", "home","index"} )
	public ModelAndView index() {
		logger.info("Inside FrontPage Controller -- Home page");
		logger.debug("Inside FrontPage Controller -- Home page -- DEBUG");
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
		mv.addObject("categories", categoryDao.listCategory());

		return mv;
	}
	
	
	@RequestMapping(value= "/contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		Visitor vs = new Visitor();
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");		
		mv.addObject("userClickContact", true);
		mv.addObject("categories", categoryDao.listCategory());
		mv.addObject("visitor", vs);
		return mv;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("visitor") Visitor visitor, BindingResult result,
			Model model, HttpServletRequest request) {

			
		if(result.hasErrors()) {
			model.addAttribute("userClickContact", true);
			model.addAttribute("title", "Contact");
			model.addAttribute("message", "Validation failed for Contact Submission!");
			return "page";
		}
		

		logger.info(visitor.toString());
		
		if(visitor.getId() == 0)
			visitorDao.add(visitor);


		return "redirect:/home";
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
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDao.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		
		productDao.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
	    // Removes the authentication from securitycontext 		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout) {
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		mv.addObject("categories", categoryDao.listCategory());

		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}
	
	@RequestMapping(value= {"/access-denied"} )
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Access Denied");
		mv.addObject("errorTitle", "Wrong!");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		mv.addObject("categories", categoryDao.listCategory());

		return mv;
	}
	

	
}
