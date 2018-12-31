package com.modelpack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAction extends Action{
	
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		
		boolean bool;
		DBCon dbcon=DBCon.getDBCon();
		
		dbcon.getQuestionAnswerSet();
		
		
		
		
		return null;
	}
}
