package com.example.onlineshoppingapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontPageController {

	@RequestMapping(value= {"/", "home","index"} )
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greetings", "Welcome to Spring MVC");
		return mv;
	}
	
/*	@RequestMapping(value= {"testvariable"} )
	public ModelAndView test(@RequestParam(value="greetings", required=false) String sc) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greetings", sc);
		return mv;
	}*/
	
	@RequestMapping(value= {"/testvariable/{greetings}"} )
	public ModelAndView test(@PathVariable(value="greetings") String sc) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greetings", sc);
		return mv;
	}
}
