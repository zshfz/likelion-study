package common;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    
    public static Connection getConnection(){
        Connection conn = null;
        Properties prop = new Properties();

        try(InputStream input = JDBCTemplate.class.getClassLoader().getResourceAsStream("db.properties")){
            if(input == null){
                throw new RuntimeException("db.properties 파일 없음");
            }
            prop.load(input);

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            System.out.println("DB 연결 성공");
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public static void Close(Connection  conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void Close(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void Close(Statement stmt){
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void commit(Connection conn) {
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
