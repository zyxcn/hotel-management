package cn.edu.sut.hotel_management.sql;

import cn.edu.sut.hotel_management.util.Api;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {

    public static int deleteOrder(Long id) throws SQLException {
        Api api = new Api();
        String sql = "DELETE FROM `order` WHERE `id` = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setLong(1, id);
        return api.update(pStatement);
    }

    public static int deleteUser(String id) throws SQLException {
        Api api = new Api();
        String sql = "DELETE FROM `user` WHERE `id` = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, id);
        return api.update(pStatement);
    }
}
