package cn.succy.geccospider.pipeline.jd;

import java.util.List;

import org.bson.Document;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.mongodb.client.MongoCollection;

import cn.succy.geccospider.bean.jd.ProductDetail;
import cn.succy.geccospider.bean.jd.ProductList;
import cn.succy.geccospider.util.MongoUtils;

/**
 * 对抽取出来的ProductList进行入库操作，使用mongodb
 * 
 * @Title MongoPipeline.java
 * @Description
 * @author Succy
 * @date 2016年11月17日 下午2:46:53
 * @version 1.0
 * @Company www.succy.cn
 */
@PipelineName("mongoPipeline")
public class MongoPipeline implements Pipeline<ProductList> {

	@Override
	public void process(ProductList productList) {
		MongoCollection<Document> collection = MongoUtils.getCollection();
		HttpRequest req = productList.getRequest();
		// 从productList里边获取url，目的是为了从之前存进数据库中找到对应url的小类目
		String url = req.getUrl();
		// 把类目名对应的商品详情的列表获取，例如，手机对应到的页面的60条记录
		List<ProductDetail> details = productList.getDetails();
		// 转成json字符串
		String jsonString = JSON.toJSONString(details);
		// 通过url找到数组里边对应url的类目，然后添加一个字段叫做details，并且把details的值
		// 给添加进去
		collection.updateOne(new Document("categories.url", url),
				Document.parse("{\"$set\":{\"categories.$.details\":" + jsonString + "}}"));
	}
}