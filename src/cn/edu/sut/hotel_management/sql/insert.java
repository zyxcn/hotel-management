package cn.edu.sut.hotel_management.sql;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.util.Api;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class insert {
    public static int addUser(String id, String nameString, String phoneString, String roomid, int duration, float deposit, String checkin) throws SQLException {
        Api api = new Api();
        String sql = "insert into user values(?, ?, ?, ?, ?,?,?)";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, id);
        pStatement.setString(2, nameString);
        pStatement.setString(3, phoneString);
        pStatement.setString(4, roomid);
        pStatement.setInt(5, duration);
        pStatement.setFloat(6, deposit);
        pStatement.setString(7, checkin);
        return api.update(pStatement);
    }

    public static int addOrder(String begin, int stay, float prepay, float pay, float rental, String id_card, String name, String phone) throws SQLException {
        Api api = new Api();
        String sql = "INSERT INTO `order` (`begin`, `stay`, `prepay`, `pay`, `rental`, `id_card`, `name`, `phone`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pStatement = api.getPreparedStatementWithKey(sql);

        pStatement.setString(1, begin);
        pStatement.setInt(2, stay);
        pStatement.setFloat(3, prepay);
        pStatement.setFloat(4, pay);
        pStatement.setFloat(5, rental);
        pStatement.setString(6, id_card);
        pStatement.setString(7, name);
        pStatement.setString(8, phone);

        pStatement.executeUpdate();
        ResultSet resultSet = pStatement.getGeneratedKeys();
        int idx;
        if (resultSet.next()) {
            idx = resultSet.getInt(1);
            return idx;
        }
        return -1;
    }


    public static int addRealtion(String user_id, String room_id, String order_id, String status) throws SQLException {
        Api api = new Api();
        String sql = "INSERT INTO `hotel_management`.`relation` (`user_id`, `room_id`, `order_id`, `status`) VALUES (?, ?, ?, ?)";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, user_id);
        pStatement.setString(2, room_id);
        pStatement.setString(3, order_id);
        pStatement.setString(4, status);
        return api.update(pStatement);
    }


    public static int register(String account, String password) throws SQLException {
        Api api = new Api();
        String sql = "INSERT INTO `user` (`account`, `password`) VALUES (?,?)";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, account);
        pStatement.setString(2, password);
        return api.update(pStatement);
    }

    public static int addRoom(String num, String type_id, String price_id) throws SQLException {
        Api api = new Api();
        String sql = "INSERT INTO `room` (`num`, `type_id`, `price_id`, `status`) VALUES (?, ?, ?, '新增')";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, num);
        pStatement.setString(2, type_id);
        pStatement.setString(3, price_id);
        return api.update(pStatement);
    }

    public static int addPrice(float prepay, float money) throws SQLException {
        Api api = new Api();
        String sql = "INSERT INTO `price` (`prepay`,`money`) VALUES (?, ?)";
        Connection conn = api.getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pStatement.setFloat(1, prepay);
        pStatement.setFloat(2, money);
        System.out.println(pStatement);
        api.update(pStatement);
        ResultSet resultSet = pStatement.getGeneratedKeys();
        int idx;
        if (resultSet.next()) {
            idx = resultSet.getInt(1);
            return idx;
        }
        return -1;
    }

    public static int addPicture(String path) {
        Api api = new Api();
        try {
            String sql = "UPDATE `user` SET `img` = ? WHERE `id` = ?";
            FileInputStream in = new FileInputStream(path);
            Connection conn = api.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pStatement.setBlob(1, in);
            pStatement.setLong(2, curuser.getId());
            api.update(pStatement);
            ResultSet resultSet = pStatement.getGeneratedKeys();
            int idx;
            if (resultSet.next()) {
                idx = resultSet.getInt(1);
                return idx;
            }
            return -1;
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
