package cn.edu.sut.hotel_management.ui.component;

import cn.edu.sut.hotel_management.sql.select;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class RoomTable extends JScrollPane {
    public DefaultTableModel getModel() throws SQLException {
        DefaultTableModel tableM = new DefaultTableModel(select.getAllRoom(), new String[]{"房间id", "房间号", "房间类型", "预付款金额", "租金金额", "状态"});
        return tableM;
    }

    public JTable getTable() throws SQLException {
        JTable jTable = new JTable(getModel());
        return jTable;
    }
}
