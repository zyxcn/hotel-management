package cn.edu.sut.hotel_management.sql;

import cn.edu.sut.hotel_management.model.*;
import cn.edu.sut.hotel_management.util.Api;

import java.io.InputStream;
import java.sql.*;

public class select {

    public static order getOrder(long id) throws SQLException {
        Api api = new Api();
        String sql = "select * from `order` where id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setLong(1, id);
        ResultSet rSet = api.select(pStatement);

        if (rSet.next()) {
            return new order(rSet.getInt(1), rSet.getString(2), rSet.getInt(3), rSet.getFloat(4), rSet.getFloat(5), rSet.getFloat(6), rSet.getString(7), rSet.getString(8), rSet.getString(9));
        } else {
            return null;
        }
    }

    public static Object[][] getAllMyOrder(long id) throws SQLException {
        Api api = new Api();
        String sql = "SELECT `order`.*  FROM `order` INNER JOIN relation ON `order`.id = relation.order_id INNER JOIN `user` ON relation.user_id = `user`.id WHERE `user`.id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setLong(1, id);
        ResultSet rSet = api.select(pStatement);

        int row = 0;
        int col = 0;
        while (rSet.next()) {
            row++;
        }
        if (row == 0) {
            return null;
        }
        Object[][] data;
        data = new Object[row][6];
        rSet.beforeFirst();//这里需要将指针移回到第一行之前
        for (; row > 0; row--) {
            rSet.next();
            data[col][0] = rSet.getLong(1);
            data[col][1] = rSet.getString(2);
            data[col][2] = rSet.getString(3);
            data[col][3] = rSet.getString(4);
            data[col][4] = rSet.getString(5);
            data[col][5] = rSet.getInt(6);
            col++;
        }
        return data;
    }

    public static int getDateCur(String start) throws SQLException {
        Api api = new Api();
        String sql = "SELECT DATEDIFF(?,CURDATE())";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, start);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return rSet.getInt(1);
        }
        return -1;
    }

    public static Object[][] getAllRoom() throws SQLException {
        Api api = new Api();
        String sql = "SELECT room.id, room.num, room_type.type, price.prepay, price.money, room.`status` FROM room INNER JOIN room_type ON room.type_id = room_type.id INNER JOIN price ON room.price_id = price.id";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        ResultSet rSet = api.select(pStatement);

        int row = 0;
        int col = 0;
        while (rSet.next()) {
            row++;
        }
        if (row == 0) {
            return null;
        }
        Object[][] data;
        data = new Object[row][6];
        rSet.beforeFirst();//这里需要将指针移回到第一行之前
        for (; row > 0; row--) {
            rSet.next();
            data[col][0] = rSet.getString(1);
            data[col][1] = rSet.getString(2);
            data[col][2] = rSet.getString(3);
            data[col][3] = rSet.getString(4);
            data[col][4] = rSet.getString(5);
            data[col][5] = rSet.getString(6);
            col++;
        }
        return data;
    }

    public static Object[][] getAllUser() throws SQLException {
        Api api = new Api();
        String sql = "SELECT `user`.id, `user`.account,`user`.user_name, `user`.`name`, `user`.tel FROM `user`";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        ResultSet rSet = api.select(pStatement);

        int row = 0;
        int col = 0;
        while (rSet.next()) {
            row++;
        }
        if (row == 0) {
            return null;
        }
        Object[][] data;
        data = new Object[row][6];
        rSet.beforeFirst();//这里需要将指针移回到第一行之前
        for (; row > 0; row--) {
            rSet.next();
            data[col][0] = rSet.getString(1);
            data[col][1] = rSet.getString(2);
            data[col][2] = rSet.getString(3);
            data[col][3] = rSet.getString(4);
            data[col][4] = rSet.getString(5);
            data[col][5] = (select.isAdmin(rSet.getString(1)) ? "是" : "否");
            col++;
        }
        return data;
    }

    public static relation getRelation(int id) throws SQLException {
        Api api = new Api();
        String sql = "select * from `relation` where id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setInt(1, id);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return new relation(rSet.getInt(1), rSet.getLong(2), rSet.getInt(3), rSet.getLong(4), rSet.getInt(5), rSet.getString(6));

        } else {
            return null;
        }
    }


    public static String[] getAllRoomType() throws SQLException {
        Api api = new Api();
        String sql = "SELECT DISTINCT room_type.type  FROM  room_type";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        ResultSet rSet = api.select(pStatement);

        int row = 0;
        int col = 0;
        while (rSet.next()) {
            row++;
        }
        if (row == 0) {
            return null;
        }
        String[] data;
        data = new String[row];
        rSet.beforeFirst();//这里需要将指针移回到第一行之前
        for (; row > 0; row--) {
            rSet.next();
            data[col] = rSet.getString(1);
            col++;
        }
        return data;
    }

    public static String[] getAllRoomNum(String type) throws SQLException {
        Api api = new Api();
        String sql = "SELECT	room.num FROM	room_type	INNER JOIN	room	ON 	room_type.id = room.type_id WHERE	room_type.type = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, type);
        ResultSet rSet = api.select(pStatement);

        int row = 0;
        int col = 0;
        while (rSet.next()) {
            row++;
        }
        if (row == 0) {
            return null;
        }
        String[] data;
        data = new String[row];
        rSet.beforeFirst();//这里需要将指针移回到第一行之前
        for (; row > 0; row--) {
            rSet.next();
            data[col] = rSet.getString(1);
            col++;
        }
        return data;
    }

    public static room getRoom(int id) throws SQLException {
        Api api = new Api();
        String sql = "SELECT room.id, room.num, room_type.type, price.prepay, price.money, room.`status` FROM room INNER JOIN room_type ON room.type_id = room_type.id INNER JOIN price ON room.price_id = price.id WHERE room.id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setInt(1, id);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return new room(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getFloat(4), rSet.getFloat(5), rSet.getString(6));
        } else {
            return null;
        }
    }

    public static float[] getRoomPrice(String id) throws SQLException {
        Api api = new Api();
        String sql = "SELECT\n" + "    price.prepay,\n" + "    price.money\n" + "            FROM\n" + "    price\n" + "    INNER JOIN\n" + "    room\n" + "            ON\n" + "    price.id = room.price_id\n" + "            WHERE\n" + "    room.num = ?\n";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, id);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return new float[]{rSet.getFloat(1), rSet.getFloat(2)};
        } else {
            return null;
        }
    }


    public static boolean isAccountExist(String account) throws SQLException {
        Api api = new Api();
        String sql = "SELECT account FROM `user` WHERE `user`.account = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, account);
        ResultSet rSet = api.select(pStatement);
        return rSet.next();
    }

    public static String getPriceId(float prepay, float money) throws SQLException {
        Api api = new Api();
        String sql = "SELECT price.id FROM price WHERE price.prepay = ? AND price.money = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setFloat(1, prepay);
        pStatement.setFloat(2, money);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return rSet.getString(1);
        }
        return null;
    }

    public static String getRoomId(String num) throws SQLException {
        Api api = new Api();
        String sql = "SELECT room.id FROM room WHERE	room.num = ? ";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, num);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return rSet.getString(1);

        }
        return null;
    }

    public static String getTypeId(String num) throws SQLException {
        Api api = new Api();
        String sql = "SELECT room_type.id FROM room_type WHERE room_type.type = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, num);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return rSet.getString(1);

        }
        return null;
    }

    public static String getOrderNum() throws SQLException {
        Api api = new Api();
        String sql = "SELECT COUNT(`order`.id) FROM `order` INNER JOIN relation ON `order`.id = relation.order_id INNER JOIN `user` ON `user`.id = relation.user_id WHERE `user`.id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setLong(1, curuser.getId());
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return rSet.getString(1);
        }
        return null;
    }

    public static int getDateDiff(String end,String start) throws SQLException {
        Api api = new Api();
        String sql = "SELECT DATEDIFF(?,?)";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, start);
        pStatement.setString(2, end);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return rSet.getInt(1);
        }
        return -1;
    }

    public static curuser getCurUser(long id) throws SQLException {
        Api api = new Api();
        String sql = "select * from `user` where id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setLong(1, id);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return new curuser(rSet.getLong(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), rSet.getString(5), rSet.getString(6), rSet.getString(7), rSet.getString(8), rSet.getString(9), rSet.getString(10));
        } else {
            return null;
        }
    }

    public static user getUser(long id) throws SQLException {
        Api api = new Api();
        String sql = "SELECT `user`.`name`, `user`.tel, `user`.account, `user`.user_name FROM `user` WHERE `user`.id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setLong(1, id);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return new user(id, rSet.getString(1), rSet.getString(2), rSet.getString(3), rSet.getString(4));
        } else {
            return null;
        }
    }

    public static boolean login(String id, String password) throws SQLException {
        Api api = new Api();
        String sql = "SELECT `password` FROM `user` WHERE account = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, id);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            String pwd = rSet.getString(1);
            return password.equals(pwd);
        }
        return false;
    }

    public static boolean isAdmin() throws SQLException {
        Api api = new Api();
        String sql = "SELECT `user`.admin FROM `user` WHERE `user`.id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setLong(1, curuser.getId());
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            int isad = rSet.getInt(1);
            return isad == 1;
        }
        return false;
    }

    public static boolean isAdmin(String id) throws SQLException {
        Api api = new Api();
        String sql = "SELECT `user`.admin FROM `user` WHERE `user`.id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, id);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            int isad = rSet.getInt(1);
            return isad == 1;
        }
        return false;
    }

    public static String getPassword() throws SQLException {
        Api api = new Api();
        String sql = "SELECT `password` FROM `user` WHERE id = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setLong(1, curuser.getId());
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return rSet.getString(1);
        }
        return null;
    }

    public static long getId(String account) throws SQLException {
        Api api = new Api();
        String sql = "SELECT `id` FROM `user` WHERE account = ?";
        PreparedStatement pStatement = api.getPreparedStatement(sql);
        pStatement.setString(1, account);
        ResultSet rSet = api.select(pStatement);
        if (rSet.next()) {
            return rSet.getLong(1);

        }
        return -1;
    }

    public static InputStream loadPicture() throws SQLException {

        Api api = new Api();
        String sql = "SELECT img from `user` WHERE id= ?";
        Connection conn = api.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, curuser.getId());
        ResultSet resultSet = ps.executeQuery();
        InputStream img;
        if (resultSet.next()) {
            img = resultSet.getBinaryStream(1);
            return img;
        }
        return null;
    }
}