package com.example.onlineshoppingapplication.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.onlineshoppingapplication.Utils.FileUtil;
import com.example.onlineshoppingapplication.validator.ProductValidator;

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
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");

		Product nProduct = new Product();

		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully");
			}
		}
		return mv;

	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDao.listCategory();
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
			Model model, HttpServletRequest request) {

		
			new ProductValidator().validate(mProduct, result);
		if(result.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			new FileUtil().uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		logger.info(mProduct.toString());
		productao.add(mProduct);

		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	
	public String handleProductActivation(@PathVariable int id) {
		
		Product product = productao.get(id);
		boolean isActive = product.isActive();
		
		product.setActive(!product.isActive());
		
		productao.update(product);
		
		return (isActive) 
				? "You have successfully deactivated the product with id " + product.getId() 
				:	"You have successfully activated the product with id " + product.getId() ;
	}
}
