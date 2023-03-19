package cn.edu.sut.hotel_management.ui.component;

import cn.edu.sut.hotel_management.sql.select;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class UserTable extends JScrollPane {
    public DefaultTableModel getModel() throws SQLException {
        DefaultTableModel tableM = new DefaultTableModel(select.getAllUser(), new String[]{"用户id", "账号", "用户名", "姓名", "手机号", "是否管理员"});
        return tableM;
    }

    public JTable getTable() throws SQLException {
        return new JTable(getModel());
    }
}
