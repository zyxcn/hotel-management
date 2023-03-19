package cn.edu.sut.hotel_management.ui.component;

import cn.edu.sut.hotel_management.sql.select;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;


public class OrderTable extends JScrollPane {
    public DefaultTableModel getModel(long id) throws SQLException {
        DefaultTableModel tableM = new DefaultTableModel(select.getAllMyOrder(id), new String[]{"订单号", "始住时间", "居住天数", "最低预付款", "实付款", "总租金"});
        return tableM;
    }

    public JTable getTable(long id) throws SQLException {
        JTable jTable = new JTable(getModel(id));
        return jTable;
    }
}