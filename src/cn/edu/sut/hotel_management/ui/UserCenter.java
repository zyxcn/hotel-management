package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.sql.update;
import cn.edu.sut.hotel_management.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class UserCenter extends JPanel {
    public UserCenter() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();
        this.setLayout(layout);

        JPanel img_bar = new JPanel();
        GridBagLayout img_bar_layout = new GridBagLayout();
        GridBagConstraints img_bar_constraint = new GridBagConstraints();
        img_bar.setLayout(img_bar_layout);

        JLabel image = new JLabel(" 暂无照片 ");
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

        JLabel username_label = new JLabel("用户名：");
        username_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 2;
        user_inf_layout.setConstraints(username_label, user_inf_constraint);
        user_inf.add(username_label);

        JTextField username = new JTextField(20);
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 2;
        user_inf_layout.setConstraints(username, user_inf_constraint);
        user_inf.add(username);

        JLabel id_card_label = new JLabel("身份证号：");
        id_card_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 3;
        user_inf_layout.setConstraints(id_card_label, user_inf_constraint);
        user_inf.add(id_card_label);

        JTextField id_card = new JTextField(20);
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 3;
        user_inf_layout.setConstraints(id_card, user_inf_constraint);
        user_inf.add(id_card);

        JLabel name_label = new JLabel("姓名：");
        name_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 4;
        user_inf_layout.setConstraints(name_label, user_inf_constraint);
        user_inf.add(name_label);

        JTextField name = new JTextField(20);
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 4;
        user_inf_layout.setConstraints(name, user_inf_constraint);
        user_inf.add(name);

        JLabel phone_label = new JLabel("手机号：");
        phone_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 5;
        user_inf_layout.setConstraints(phone_label, user_inf_constraint);
        user_inf.add(phone_label);

        JTextField phone = new JTextField(20);
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 5;
        user_inf_layout.setConstraints(phone, user_inf_constraint);
        user_inf.add(phone);


        JPanel btn_bar = new JPanel();
        GridBagLayout btn_bar_layout = new GridBagLayout();
        GridBagConstraints btn_bar_constraint = new GridBagConstraints();
        btn_bar.setLayout(btn_bar_layout);

        JButton upload = new JButton("上传照片");
        upload.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 0;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(upload, btn_bar_constraint);
        btn_bar.add(upload);

        JButton btnA = new JButton("修改密码");
        btnA.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 1;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnA, btn_bar_constraint);
        btn_bar.add(btnA);

        JButton btnB = new JButton("确认修改");
        btnB.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 2;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnB, btn_bar_constraint);
        btn_bar.add(btnB);

        JButton btnC = new JButton("重置输入");
        btnC.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 3;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnC, btn_bar_constraint);
        btn_bar.add(btnC);

        JButton btnD = new JButton("退出登录");
        btnD.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 4;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnD, btn_bar_constraint);
        btn_bar.add(btnD);

        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePassword.create();
            }
        });
        btnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sid_card = id_card.getText();
                String sname = name.getText();
                String stel = phone.getText();
                String suname = username.getText();
                try {
                    update.updateCurUser(curuser.getId(), sname, sid_card, stel, suname);
                    JOptionPane.showConfirmDialog(null, "修改成功", "提示", JOptionPane.DEFAULT_OPTION);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "修改失败！", "错误", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });

        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText(curuser.getUser_name());
                id_card.setText(curuser.getId_card());
                name.setText(curuser.getName());
                phone.setText(curuser.getTel());
            }
        });

        btnD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curuser.logout();
                SwingUtilities.getWindowAncestor((Component) e.getSource()).dispose();
                Login l = new Login();
                l.setVisible(true);
            }
        });

        upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageUtil.addPicture(image, upload);

            }
        });

        user_id.setText(String.valueOf(curuser.getId()));
        username.setText(curuser.getUser_name());
        id_card.setText(curuser.getId_card());
        name.setText(curuser.getName());
        phone.setText(curuser.getTel());
        try {
            order_num.setText(select.getOrderNum());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ImageUtil.loadPicture(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 0;
        layout.setConstraints(user_inf, constraint);
        this.add(img_bar);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 1;
        constraint.gridy = 0;
        layout.setConstraints(user_inf, constraint);
        this.add(user_inf);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridwidth = 2;
        constraint.gridy = 1;
        layout.setConstraints(btn_bar, constraint);
        this.add(btn_bar);
    }

    public static void create() {
        Register register = new Register();
        register.setSize(400, 300);
        register.setTitle("注册");
        register.setLocationRelativeTo(null);
        register.setVisible(true);
    }
}
