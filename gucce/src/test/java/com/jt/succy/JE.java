package com.jt.succy;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;

public class JE {
	public static void main(String[] args) {
		 GeccoEngine.create()
         //工程的包路径
         .classpath("com.jt.succy")
         //开始抓取的页面地址
         .start("http://www.jd.com/allSort.aspx")
         //开启几个爬虫线程
         .thread(10)
         //单个爬虫每次抓取完一个请求后的间隔时间
         .interval(5)
         //使用pc端userAgent
         .mobile(false)
         //开始运行
         .run();
	    }
	}

