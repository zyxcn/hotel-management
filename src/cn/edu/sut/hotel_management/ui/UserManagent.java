package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.sql.delete;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.sql.update;
import cn.edu.sut.hotel_management.ui.component.UserTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserManagent extends JPanel {
    public UserManagent() throws SQLException {
        System.out.println(curuser.getId());
        UserTable userTable = new UserTable();

        setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();

        JLabel jl1 = new JLabel("按住CTRL可多选");
        JButton look = new JButton("管理");
        JButton reload = new JButton("刷新");
        JButton setadmin = new JButton("设为/取消管理员");
        JButton deleteU = new JButton("删除");

        JTable myTable = userTable.getTable();
        DefaultTableModel model = (DefaultTableModel) myTable.getModel();
        userTable.setViewportView(myTable);
        String[] hrader = new String[]{"用户id", "账号", "用户名", "姓名", "手机号", "是否管理员"};
        model.setDataVector(select.getAllUser(), hrader);

        look.addActionListener(new ActionListener() {//查看事件
            public void actionPerformed(ActionEvent e) {

                int selectedRow = myTable.getSelectedRow();//获得选中行的索引
                int selectedRows = myTable.getSelectedRows().length;

                if (selectedRows > 1) {
                    JOptionPane.showMessageDialog(null, "每次只能管理一个！", "提示",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String id = ((String) myTable.getValueAt(selectedRow, 0));
                UserDetil r = new UserDetil(id);
                r.setVisible(true);
            }
        });

        reload.addActionListener(new ActionListener() {//刷新事件
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setDataVector(select.getAllUser(), hrader);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                myTable.updateUI();
            }
        });

        setadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = myTable.getSelectedRows();
                for (int i : selectedRows) {
                    if (i != -1)  //存在选中行
                    {
                        String id = (String) myTable.getValueAt(i, 0);
                        try {
                            boolean status = select.isAdmin(id);
                            if (status) {
                                update.unsetAdmin(id);
                            } else {
                                update.setAdmin(id);
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                try {
                    model.setDataVector(select.getAllUser(), hrader);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                myTable.updateUI();

            }
        });
        deleteU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = myTable.getSelectedRows();
                for (int i : selectedRows) {
                    if (i != -1)  //存在选中行
                    {
                        String id = (String) myTable.getValueAt(i, 0);
                        try {
                            delete.deleteUser(id);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                try {
                    model.setDataVector(select.getAllUser(), hrader);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                myTable.updateUI();
            }
        });

        jPanel.add(jl1);
        jPanel.add(look);
        jPanel.add(reload);
        jPanel.add(setadmin);
        jPanel.add(deleteU);
        add(jPanel, BorderLayout.NORTH);
        add(userTable, BorderLayout.CENTER);
    }
}
