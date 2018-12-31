package com.tag.test;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomJspTag extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
				DateFormat.MEDIUM);
		try {
			pageContext.getOut().write(df.format(new Date()));
		} catch (IOException ioe) {
			throw new JspTagException(ioe.getMessage());
		}
		return SKIP_BODY;
	}

}
