package cn.edu.sut.hotel_management.util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

    static {
        try {
            Class.forName(dbconfig.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(dbconfig.JDBC_URL, dbconfig.JDBC_USER, dbconfig.JDBC_PASSWORD);
        } catch (
                SQLException e) {
            JOptionPane.showMessageDialog(null, "数据库连接失败！", "提示", JOptionPane.ERROR_MESSAGE);
//            throw new RuntimeException(e);
        }
        return null;
    }
}

