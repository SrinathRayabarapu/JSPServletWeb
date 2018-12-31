package com.tablib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CheckNumber extends TagSupport {
	
	private String number;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public int doEndTag() throws JspException {
		int num = Integer.parseInt(number);
		JspWriter jspWriter = pageContext.getOut();
		if(num%2==0){
			try {
				jspWriter.print("Even number");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				jspWriter.print("Odd number");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}
