package cn.edu.sut.hotel_management.util;

public interface dbconfig {
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String JDBC_URL = "jdbc:mysql://localhost:3306/hotel_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "root";
}
