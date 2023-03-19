package cn.edu.sut.hotel_management.sql;

import cn.edu.sut.hotel_management.util.Api;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update {
    public static int updateCurUser(Long id, String name, String id_card, String tel, String user_name) throws SQLException {
        Api api = new Api();
        String sql = "UPDATE `user` SET `name` = ?, `id_card` = ?, `tel` = ?, `user_name` = ? WHERE `id` = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, name);
        pStatement.setString(2, id_card);
        pStatement.setString(3, tel);
        pStatement.setString(4, user_name);
        pStatement.setLong(5, id);
        return api.update(pStatement);
    }

    public static int updateUser(Long id, String name, String tel, String user_name) throws SQLException {
        Api api = new Api();
        String sql = "UPDATE `user` SET `name` = ?, `tel` = ?, `user_name` = ? WHERE `id` = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, name);
        pStatement.setString(2, tel);
        pStatement.setString(3, user_name);
        pStatement.setLong(4, id);
        return api.update(pStatement);
    }

    public static int updatePassword(Long id, String password) throws SQLException {
        Api api = new Api();
        String sql = "UPDATE `user` SET `password` = ? WHERE `id` = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, password);
        pStatement.setLong(2, id);
        return api.update(pStatement);
    }

    public static int setAdmin(String id) throws SQLException {
        Api api = new Api();
        String sql = "UPDATE `user` SET `admin` = 1 WHERE `id` = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, id);
        return api.update(pStatement);
    }

    public static int unsetAdmin(String id) throws SQLException {
        Api api = new Api();
        String sql = "UPDATE `user` SET `admin` = 0 WHERE `id` = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, id);
        return api.update(pStatement);
    }

    public static int updateRoom(String id, String num, String type_id, String price_id) throws SQLException {
        Api api = new Api();
        String sql = "UPDATE `room` SET `num` = ?, `type_id` = ?, `price_id` = ? WHERE `id` = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, num);
        pStatement.setString(2, type_id);
        pStatement.setString(3, price_id);
        pStatement.setString(4, id);
        return api.update(pStatement);
    }
}
