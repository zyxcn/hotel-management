package cn.edu.sut.hotel_management.util;

import javax.swing.*;
import java.sql.*;

public class Api {

    public ResultSet select(PreparedStatement sql) {
        try {
            return sql.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int insert(PreparedStatement sql) {
        try {
            return sql.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int update(PreparedStatement sql) {
        try {
            return sql.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int delete(PreparedStatement sql) {
        try {
            return sql.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
            return JDBC.getConnection();
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            Connection connection = JDBC.getConnection();
            return connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PreparedStatement getPreparedStatementWithKey(String sql) {
        try {
            Connection connection = JDBC.getConnection();
            return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
