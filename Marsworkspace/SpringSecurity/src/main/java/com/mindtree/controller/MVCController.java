package com.mindtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class MVCController {
		@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	    public String homePage(ModelMap modelMap) {
	 
	        modelMap.addAttribute("head", "Home");
	        modelMap.addAttribute("body", "This is HOME Page");
	        return "hello";
	    }
	    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
	    public ModelAndView adminPage() {
	 
	        ModelAndView modelAndView = new ModelAndView("admin");
	        modelAndView.addObject("head", "Admin");
	        modelAndView.addObject("body", "This is ADMIN page");
	        return modelAndView;
	    }
}