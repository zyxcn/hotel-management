package cn.edu.sut.hotel_management.ui.component;

import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.ui.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.sql.SQLException;

public class Tab extends JTabbedPane {

    public Tab() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        try {
            this.setSize(400, 500);
            Home home = new Home();
            this.add("主页", home);
            this.addTab("酒店预订", new Reservation());
            this.addTab("订单管理", new OrderManagement());
            this.addTab("用户中心", new UserCenter());
            if (select.isAdmin()) {
                this.addTab("房间管理", new RoomManagent());
                this.addTab("用户管理", new UserManagent());
            }

            this.setFont(new Font("宋体", Font.BOLD, 20));
            this.setSelectedIndex(0);

            this.getSelectedIndex();
            this.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (Tab.this.getSelectedIndex() == 0) {
                        home.reloadImage();
                    }
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}