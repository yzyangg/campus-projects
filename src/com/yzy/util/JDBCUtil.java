package com.yzy.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author com.yzy
 * @version 1.0
 * @description TODO
 * @date 2023/6/21 16:41
 */
public class JDBCUtil {


    public static Connection getConnection() {
        Properties properties = new Properties();
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Connection connection = null;
        try {
            properties.load(inputStream);
            String driverClassName = properties.getProperty("db.driver");
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        //一起关闭所有资源
        if (resultSet != null) try {
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (connection != null) try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (preparedStatement != null) try {
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
