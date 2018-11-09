package com.jt.gucce;

import java.util.List;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl="https://doutushe.com/portal/index/index/p/{page}",pipelines="doutusheIndex")
public class DoutuSheIndex implements HtmlBean{
		@Request
		private HttpRequest request;
	    
		//@Href(click=true)
		@HtmlField(cssPath="a.link-2")
		private List<String> nameList;
		
		@Href(value="href")
		@HtmlField(cssPath="a.link-2")
		private List<String> idList;
		
		@HtmlField(cssPath="ul.pagination li")
		private List<IndexPageEntity> pageList;

		public HttpRequest getRequest() {
			return request;
		}

		public void setRequest(HttpRequest request) {
			this.request = request;
		}

		public List<String> getNameList() {
			return nameList;
		}

		public void setNameList(List<String> nameList) {
			this.nameList = nameList;
		}

		public List<String> getIdList() {
			return idList;
		}

		public void setIdList(List<String> idList) {
			this.idList = idList;
		}

		public List<IndexPageEntity> getPageList() {
			return pageList;
		}

		public void setPageList(List<IndexPageEntity> pageList) {
			this.pageList = pageList;
		}
		
		
		
	
		
	
}
