package com.jt.gucce;

import java.util.List;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="https://doutushe.com/portal/article/index/id/{id}",pipelines="doutusheEntity")
public class DoutusheEntity implements HtmlBean{
	@Request
	private HttpRequest request;
	
	@HtmlField(cssPath="div.col-xs-12 blockquote p")
	private String title;
	
	@Image({"data-original","src"})
	@HtmlField(cssPath=".lazy")
	private List<String> imgList;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
	
	
	
}
