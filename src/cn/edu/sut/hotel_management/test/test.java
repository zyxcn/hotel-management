package cn.edu.sut.hotel_management.test;

import cn.edu.sut.hotel_management.sql.insert;
import cn.edu.sut.hotel_management.sql.select;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        select.getRelation(1);
        insert.addUser("", "", "", "", 1, 1, "");
    }
}
