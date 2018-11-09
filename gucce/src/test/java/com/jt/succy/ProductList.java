package com.jt.succy;

import java.util.List;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

public class ProductList implements HtmlBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -513345592370241629L;
	
		@Request
		private HttpRequest request;
		@HtmlField(cssPath="#plist .gl-item")
	    private List<ProductBrief> details;
	    /**
	     * 获得商品列表的当前页
	     */
	    @Text
	    @HtmlField(cssPath="#J_topPage > span > b")
	    private int currPage;
	    /**
	     * 获得商品列表的总页数
	     */
	    @Text
	    @HtmlField(cssPath="#J_topPage > span > i")
	    private int totalPage;
		public HttpRequest getRequest() {
			return request;
		}
		public void setRequest(HttpRequest request) {
			this.request = request;
		}
		public List<ProductBrief> getDetails() {
			return details;
		}
		public void setDetails(List<ProductBrief> details) {
			this.details = details;
		}
		public int getCurrPage() {
			return currPage;
		}
		public void setCurrPage(int currPage) {
			this.currPage = currPage;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
	    
	    
	
}
