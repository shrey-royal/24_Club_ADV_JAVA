package com;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		JspWriter out=pageContext.getOut();
	    try{  
	     out.print(Calendar.getInstance().getTime());
	    }catch(Exception e){System.out.println(e);}  
	    return SKIP_BODY;
	}
}
