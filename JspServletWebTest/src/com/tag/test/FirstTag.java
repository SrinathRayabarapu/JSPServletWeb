package com.tag.test;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class FirstTag implements Tag,Serializable{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	private PageContext context;
	private Tag tag;
	private String name;
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			
			if(name != ""){
				context.getOut().write("Hello "+name+" !");
			}else{
				context.getOut().write("You didnt enter a name");
				context.getOut().write(", what are you afraid of ?");
			}
		} catch (IOException e) {
			throw new JspTagException();
		}
		return SKIP_BODY;
	}
	
	@Override
	public Tag getParent() {
		return tag;
	}
	
	@Override
	public void release() {
		context = null;
		tag = null;
		name = null;
	}
	
	@Override
	public void setPageContext(PageContext arg0) {
		context = arg0;
	}
	
	@Override
	public void setParent(Tag arg0) {
		tag = arg0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}