package cn.succy.geccospider.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public final class MysqlUtils {
	public static final String Driver = "com.mysql.jdbc.Driver";  
    public static final String url = "jdbc:mysql://127.0.0.1:3306/jtdb?useUnicode=true&characterEncoding=UTF-8";  
    public static final String user = "root";  
    public static final String password = "root";  
  
    static {  
        try {  
            Class.forName(Driver);  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
    public static Connection getConnection() throws SQLException{  
        Connection conn = null;  
        conn = DriverManager.getConnection(url,user,password);  
        return conn;  
    }  


}
