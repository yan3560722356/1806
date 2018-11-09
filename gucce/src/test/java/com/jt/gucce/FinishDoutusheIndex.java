package com.jt.gucce;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.TextUtils;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.google.gson.Gson;

@PipelineName(value="doutusheIndex")
public class FinishDoutusheIndex implements Pipeline<DoutuSheIndex> {
	@Override
	public void process(DoutuSheIndex doutuSheIndex) {
		if (doutuSheIndex.getIdList()!=null) {
			System.out.println("\n\n抓到结果2："+doutuSheIndex.getIdList().toString());
		}else {		System.out.println("\n\n抓到结果2为空");
		}
		System.out.println("\n\n抓到结果1:"+new Gson().toJson(doutuSheIndex.getPageList()));
			for (int i = 0; i < doutuSheIndex.getIdList().size(); i++) {
				if (TextUtils.isEmpty(doutuSheIndex.getNameList().get(i))) {
			
				String url = doutuSheIndex.getIdList().get(i);
				System.out.println(url);
				HttpRequest currRequest=doutuSheIndex.getRequest();
				SchedulerContext.into(currRequest.subRequest(url));
			}		
		}

		for (int i = 0; i < doutuSheIndex.getPageList().size(); i++) {
			
			String url = doutuSheIndex.getPageList().get(i).getPageUrl();
			//System.out.println("pageName"+pageName);
			if (url!=null&&url.equals("下一页")) {
				//System.out.println("url"+url);
				String pageName = doutuSheIndex.getPageList().get(i).getPageName();
				HttpRequest currRequest =doutuSheIndex.getRequest();
				SchedulerContext.into(currRequest.subRequest(pageName));
				

			}

		}



	}
}
