package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.ui.component.RoomTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RoomManagent extends JPanel {
    public RoomManagent() throws SQLException {
        System.out.println(curuser.getId());
        RoomTable roomTable = new RoomTable();

        setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();

        JLabel jl1 = new JLabel("按住CTRL可多选");
        JButton add = new JButton("添加");
        JButton look = new JButton("管理");
        JButton reload = new JButton("刷新");
        JButton btnAddType = new JButton("新增房型");

        JTable myTable = roomTable.getTable();
        DefaultTableModel model = (DefaultTableModel) myTable.getModel();
        roomTable.setViewportView(myTable);
        String[] hrader = new String[]{"房间id", "房间号", "房间类型", "预付款金额", "租金金额", "状态"};
        model.setDataVector(select.getAllRoom(), hrader);

        look.addActionListener(new ActionListener() {//查看事件
            public void actionPerformed(ActionEvent e) {
                int selectedRow = myTable.getSelectedRow();//获得选中行的索引
                int selectedRows = myTable.getSelectedRows().length;

                if (selectedRows > 1) {
                    JOptionPane.showMessageDialog(null, "每次只能查看一个！", "提示",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int id = Integer.parseInt((String) myTable.getValueAt(selectedRow, 0));
                RoomDetil r = new RoomDetil(id);
                r.setVisible(true);
            }
        });

        reload.addActionListener(new ActionListener() {//刷新事件
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setDataVector(select.getAllRoom(), hrader);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                myTable.updateUI();
            }
        });

        add.addActionListener(new ActionListener() {//刷新事件
            public void actionPerformed(ActionEvent e) {
                AddRoom.create();
            }
        });

        jPanel.add(jl1);
        jPanel.add(add);
        jPanel.add(look);
        jPanel.add(reload);
        add(jPanel, BorderLayout.NORTH);
        add(roomTable, BorderLayout.CENTER);
    }
}
