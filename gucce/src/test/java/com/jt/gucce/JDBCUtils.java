package com.jt.gucce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	public static final String Driver = "com.mysql.jdbc.Driver";  
    public static final String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";  
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
