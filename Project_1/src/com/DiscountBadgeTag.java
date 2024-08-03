package com;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DiscountBadgeTag extends TagSupport {
	private int discount;
	
	public void setDiscount(int discount) {
        this.discount = discount;
    }
	
	@Override
	public int doStartTag() throws JspException {
		try {
			String badgeText = getBadgeText(discount);
			pageContext.getOut().print(badgeText);
		} catch (IOException e) {
			throw new JspException("Error in DiscountBadgeTag", e);
		}
		return SKIP_BODY;
	}
	
	
	public String getBadgeText(int discount) {
		if(discount >= 76) {
			return "<span class='badge badge-insane'>Insane Savings</span>";
		} else if(discount >= 51) {
			return "<span class='badge badge-unbelievable'>Unbelievable!</span>";
		} else if(discount >= 26) {
			return "<span class='badge badge-great'>Great Deal!</span>";
		} else if(discount >= 10) {
			return "<span class='badge badge-save-big'>Save Big!</span>";
		} else {
			return "";
		}
	}
}
