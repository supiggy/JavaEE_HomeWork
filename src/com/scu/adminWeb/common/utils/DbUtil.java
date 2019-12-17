package com.scu.adminWeb.common.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
@Deprecated

public class DbUtil {
    private static String driver = null;
    private static String url = null;
    private static String dbUser = null;
    private static String dbPassword = null;

    static {
//        driver = "com.mysql.jdbc.Driver";
//        url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
//        dbUser ="root";
//        dbPassword ="root";
        //类路径加载资源
        try {
            InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/configure/jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            driver = properties.getProperty("db.driver");
            url = properties.getProperty("db.url");
            dbUser = properties.getProperty("db.dbUser");
            dbPassword = properties.getProperty("db.dbPassword");
            Class.forName(driver);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,dbUser,dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
