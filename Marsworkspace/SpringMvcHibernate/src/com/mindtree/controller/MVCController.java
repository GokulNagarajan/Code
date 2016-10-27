package com.mindtree.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MVCController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav=new ModelAndView("index");
		mav.addObject("welcome", "Hi welcome to spring mvc");
		System.out.println("Hi welcome to spring mvc");
		return mav;
	}
	

}
