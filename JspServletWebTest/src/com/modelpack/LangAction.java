package com.modelpack;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LangAction extends Action{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String language=req.getParameter("language");
		Locale locale=new Locale(language);
		
		ResourceBundle rb=ResourceBundle.getBundle("dictionary",locale);
	
		HttpSession session=req.getSession();
		
		session.setAttribute("rb",rb);
		
		return "lang.success";
	}
}
