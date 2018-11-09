package com.jt.gucce;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class IndexPageEntity implements HtmlBean {
	@Href(value="href")
	@HtmlField(cssPath="a")
	private String pageName;
	
	@Text
	@HtmlField(cssPath="a")
	private String pageUrl;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	

}
