package com.modelpack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		DBCon dbcon=DBCon.getDBCon();
		String uname=req.getParameter("uname");
		String upass=req.getParameter("upass");
		String rollno=req.getParameter("rollno");

		HttpSession session=req.getSession();
		boolean validuser = dbcon.checkUserPresent(uname);
		if(!validuser)
		{
			boolean validregister = dbcon.registerUser(uname,upass,rollno);
			if(validregister)
			{
				dbcon.changeStatus(uname, 1);
				session.setAttribute("uname",uname);
				return "register.success";
			}
			else
			{
				return "register.failure";
			}
		}
		else
		{
			return "register.alreadyregistered";
		}
	}
}
