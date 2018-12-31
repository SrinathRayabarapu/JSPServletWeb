package com.modelpack;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShopAction extends Action{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession session=req.getSession();
		Enumeration e=req.getParameterNames();
		while(e.hasMoreElements())
		{
			String name=e.nextElement().toString();
			String value=req.getParameter(name);
			session.setAttribute(name,value);
		}
		
		String nextpage=req.getParameter("shop");
		
		if(nextpage.equals("shop1"))
		{
			return "shop.shop2";
		}
		else if(nextpage.equals("shop2"))
		{
			return "shop.shop3";
		}
		else 
		{
			return "shop.invoice";
		}
	}
}
