package com.mindtree.controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MyListener implements HttpSessionListener {
    ServletContext ctx=null;  
    static int total=0,current=0;  
    public MyListener() {
    }  
    public void sessionCreated(HttpSessionEvent e) {  
    total++;  
    current++;   
    ctx=e.getSession().getServletContext();  
    ctx.setAttribute("totalusers", total);  
    ctx.setAttribute("currentusers", current);      
    }  
    public void sessionDestroyed(HttpSessionEvent e) {  
        current--;  
        ctx.setAttribute("currentusers",current);  
    }  
	
}
