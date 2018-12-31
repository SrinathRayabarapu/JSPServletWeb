package com.controlpack;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelpack.Action;

public class Secretary {
	public void process(HttpServletRequest req,HttpServletResponse res)
	{
		try{
			String page=req.getParameter("page");
			Properties prop=new Properties();
			HttpSession session=req.getSession();
			ServletContext app=session.getServletContext();
			String fullpath=app.getRealPath("/WEB-INF/config.properties");
			
			prop.load(new FileInputStream(fullpath));
			
			String actionclass=prop.getProperty(page);
			Action action=(Action)Class.forName(actionclass).newInstance();
			
			String result=action.execute(req, res);

			String nextpage=prop.getProperty(result);

			RequestDispatcher rd=req.getRequestDispatcher(nextpage);
			rd.forward(req,res);
			
		}catch(Exception e){e.printStackTrace();}
	}
}
