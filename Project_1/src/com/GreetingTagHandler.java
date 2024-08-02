package com;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GreetingTagHandler extends SimpleTagSupport {
	private String username;
	
	public void setusername(String username) {
		this.username = username;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("Hello, " + (username != null ? username : "World") + "!");
	}
}
