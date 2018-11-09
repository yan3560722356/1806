package cn.succy.geccospider.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * mongodb的工具类，可以用作获取数据库的客户端连接对象，数据库对象，数据库的集合对象
 * 
 * @Title MongoUtils.java
 * @Description
 * @author Succy
 * @date 2016年11月17日 下午2:43:01
 * @version 1.0
 * @Company www.succy.cn
 */
public final class MongoUtils {
	private static String HOST; // mongo服务器地址
	private static String DBNAME; // 要连接的数据库名
	private static String COLLECTION;// 要操作的集合，这里假定只操作这一个集合

	private static MongoClient client;
	private static MongoDatabase db;
	private static MongoCollection<Document> colle;

	private MongoUtils(){}
	
	/**
	 * 通过配置文件把配置的参数取出
	 */
	static {
		Properties prop = new Properties();
		InputStream inStream = ClassLoader.getSystemResourceAsStream("mongo.properties");
		try {
			prop.load(inStream);
			HOST = prop.getProperty("mongo.host");
			DBNAME = prop.getProperty("mongo.dbName");
			COLLECTION = prop.getProperty("mongo.collection");

			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void init() {
		client = new MongoClient(HOST);
		db = client.getDatabase(DBNAME);
		colle = db.getCollection(COLLECTION);
	}

	/**
	 * 获取客户端对象
	 * 
	 * @return client
	 */
	public static MongoClient getClient() {
		return client;
	}

	/**
	 * 获取MongoDatabase对象
	 * 
	 * @return db
	 */
	public static MongoDatabase getDb() {
		return db;
	}

	/**
	 * 获取MongoCollection<Document>对象
	 * 
	 * @return collection
	 */
	public static MongoCollection<Document> getCollection() {
		return colle;
	}
}
