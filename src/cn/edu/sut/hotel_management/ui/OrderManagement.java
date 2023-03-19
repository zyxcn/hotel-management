package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.ui.component.OrderTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class OrderManagement extends JPanel {

    JTable myTable;

    public OrderManagement() throws SQLException {
        System.out.println(curuser.getId());
        OrderTable orderTableComponent = new OrderTable();

        setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();

        JLabel jl1 = new JLabel("按住CTRL可多选");
        JButton look = new JButton("查看/管理");
        JButton reload = new JButton("刷新");


        myTable = orderTableComponent.getTable(curuser.getId());
        DefaultTableModel model = (DefaultTableModel) myTable.getModel();
        orderTableComponent.setViewportView(myTable);
        String[] hrader = new String[]{"订单号", "始住时间", "居住天数", "最低预付款", "实付款", "总租金"};
        model.setDataVector(select.getAllMyOrder(curuser.getId()), hrader);


        look.addActionListener(new ActionListener() {//查看事件
            public void actionPerformed(ActionEvent e) {
                int selectedRow = myTable.getSelectedRow();//获得选中行的索引
                int selectedRows = myTable.getSelectedRows().length;

                if (selectedRows > 1) {
                    JOptionPane.showMessageDialog(null, "每次只能查看一个！", "提示",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                long id = (long) myTable.getValueAt(selectedRow, 0);
                OrderDetil orderDetil = new OrderDetil(id);
                orderDetil.setVisible(true);
            }
        });

        reload.addActionListener(new ActionListener() {//刷新事件
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setDataVector(select.getAllMyOrder(curuser.getId()), hrader);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                myTable.updateUI();
            }
        });
        jPanel.add(jl1);
        jPanel.add(look);
        jPanel.add(reload);
        add(jPanel, BorderLayout.NORTH);
        add(orderTableComponent, BorderLayout.CENTER);
    }
}
