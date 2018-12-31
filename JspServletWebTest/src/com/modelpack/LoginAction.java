package com.modelpack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action{
@Override
public String execute(HttpServletRequest req, HttpServletResponse res) {
	DBCon dbcon=DBCon.getDBCon();
	String uname=req.getParameter("uname");
	String upass=req.getParameter("upass");
	HttpSession session=req.getSession();
	boolean validuser=dbcon.checkUser(uname,upass);
	if(validuser)
	{
		boolean validstatus=dbcon.checkStatus(uname);
		if(validstatus)
		{
			dbcon.changeStatus(uname, 1);
			session.setAttribute("uname",uname);
			return "login.success";
		}
		else
		{
			return "login.alreadylogedin";
		}
	}
	else
	{
		return "login.invaliduser";
	}
	
	
}
}
