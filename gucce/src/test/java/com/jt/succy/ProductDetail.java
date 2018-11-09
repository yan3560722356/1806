package com.jt.succy;

import com.geccocrawler.gecco.annotation.Ajax;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class ProductDetail implements HtmlBean{
	 private static final long serialVersionUID = -377053120283382723L;
	 
	 @RequestParameter
	    private String code;
	 
	    /**
	     * 标题
	     */
	    @Text
	    @HtmlField(cssPath="#name > h1")
	    private String title;
	 
	    /**
	     * ajax获取商品价格
	     */
	    @Ajax(url="http://p.3.cn/prices/get?skuIds=J_[code]")
	    private JDPrice price;
	 
	    /**
	     * 商品的推广语
	     */
	    @Ajax(url="http://cd.jd.com/promotion/v2?skuId={code}&area=1_2805_2855_0&cat=737%2C794%2C798")
	    private JDad jdAd;
	 
	    /*
	     * 商品规格参数
	     */
	    @HtmlField(cssPath="#product-detail-2")
	    private String detail;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public JDPrice getPrice() {
			return price;
		}

		public void setPrice(JDPrice price) {
			this.price = price;
		}

		public JDad getJdAd() {
			return jdAd;
		}

		public void setJdAd(JDad jdAd) {
			this.jdAd = jdAd;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

	 
}
