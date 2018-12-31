package com.modelpack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action{
@Override
public String execute(HttpServletRequest req, HttpServletResponse res) {
	HttpSession session=req.getSession();
	String uname=session.getAttribute("uname").toString();
	
	DBCon dbcon=DBCon.getDBCon();
	dbcon.changeStatus(uname, 0);
	return "logout.success";
}
}
