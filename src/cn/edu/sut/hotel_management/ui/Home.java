package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class Home extends JPanel {
    JLabel image;

    public Home() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();
        this.setLayout(layout);

        JPanel img_bar = new JPanel();
        GridBagLayout img_bar_layout = new GridBagLayout();
        GridBagConstraints img_bar_constraint = new GridBagConstraints();
        img_bar.setLayout(img_bar_layout);

        image = new JLabel(" 暂无照片 ");
        image.setMinimumSize(new Dimension(150, 200));
        image.setMaximumSize(new Dimension(150, 200));
        image.setPreferredSize(new Dimension(150, 200));
        img_bar_constraint.gridheight = 5;
        img_bar_constraint.gridwidth = 3;
        img_bar_constraint.gridx = 0;
        img_bar_constraint.gridy = 1;
        img_bar_layout.setConstraints(image, img_bar_constraint);
        img_bar.add(image);

        JPanel user_inf = new JPanel();
        GridBagLayout user_inf_layout = new GridBagLayout();
        GridBagConstraints user_inf_constraint = new GridBagConstraints();
        user_inf.setLayout(user_inf_layout);

        JLabel user_id_label = new JLabel("用户唯一id：");
        user_id_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 0;
        user_inf_layout.setConstraints(user_id_label, user_inf_constraint);
        user_inf.add(user_id_label);

        JLabel user_id = new JLabel();
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 0;
        user_inf_layout.setConstraints(user_id, user_inf_constraint);
        user_inf.add(user_id);

        JLabel order_num_label = new JLabel("订单数量:");
        order_num_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 1;
        user_inf_layout.setConstraints(order_num_label, user_inf_constraint);
        user_inf.add(order_num_label);

        JLabel order_num = new JLabel();
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 1;
        user_inf_layout.setConstraints(order_num, user_inf_constraint);
        user_inf.add(order_num);

        JLabel id_card_label = new JLabel("身份证号：");
        id_card_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 2;
        user_inf_layout.setConstraints(id_card_label, user_inf_constraint);
        user_inf.add(id_card_label);

        JLabel id_card = new JLabel();
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 2;
        user_inf_layout.setConstraints(id_card, user_inf_constraint);
        user_inf.add(id_card);

        JLabel name_label = new JLabel("姓名：");
        name_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 3;
        user_inf_layout.setConstraints(name_label, user_inf_constraint);
        user_inf.add(name_label);

        JLabel name = new JLabel();
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 3;
        user_inf_layout.setConstraints(name, user_inf_constraint);
        user_inf.add(name);

        JLabel phone_label = new JLabel("手机号：");
        phone_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 4;
        user_inf_layout.setConstraints(phone_label, user_inf_constraint);
        user_inf.add(phone_label);

        JLabel phone = new JLabel();
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 4;
        user_inf_layout.setConstraints(phone, user_inf_constraint);
        user_inf.add(phone);

        JLabel welcome = new JLabel("欢迎使用  SUT酒店管理系统");
        welcome.setFont(new Font("宋体", Font.BOLD, 30));
        constraint.insets = new Insets(0, 0, 100, 0);
        constraint.gridwidth = 2;
        constraint.gridx = 0;
        constraint.gridy = 0;
        layout.setConstraints(welcome, constraint);
        this.add(welcome);

        constraint.gridwidth = 1;
        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 2;
        layout.setConstraints(img_bar, constraint);
        this.add(img_bar);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 1;
        constraint.gridy = 2;
        layout.setConstraints(user_inf, constraint);
        this.add(user_inf);
        try {
            order_num.setText(select.getOrderNum());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        user_id.setText(String.valueOf(curuser.getId()));
//        username.setText(user.getUser_name());
        id_card.setText(curuser.getId_card());
        name.setText(curuser.getName());
        phone.setText(curuser.getTel());
        try {
            ImageUtil.loadPicture(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadImage() {
        try {
            ImageUtil.loadPicture(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
