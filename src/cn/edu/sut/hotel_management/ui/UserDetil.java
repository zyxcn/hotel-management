package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.user;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.sql.update;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserDetil extends JFrame {
    public UserDetil(String idx) {
        this.setSize(350, 280);
        this.setLocationRelativeTo(null);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();
        this.setLayout(layout);

        JPanel user_inf = new JPanel();
        GridBagLayout user_inf_layout = new GridBagLayout();
        GridBagConstraints user_inf_constraint = new GridBagConstraints();
        user_inf.setLayout(user_inf_layout);

        JLabel u_id_label = new JLabel("用户id：");
        u_id_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 0;
        user_inf_layout.setConstraints(u_id_label, user_inf_constraint);
        user_inf.add(u_id_label);

        JLabel u_id = new JLabel();
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 0;
        user_inf_layout.setConstraints(u_id, user_inf_constraint);
        user_inf.add(u_id);

        JLabel account_label = new JLabel("账号：");
        account_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 1;
        user_inf_layout.setConstraints(account_label, user_inf_constraint);
        user_inf.add(account_label);

        JLabel account = new JLabel("");
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 1;
        user_inf_layout.setConstraints(account, user_inf_constraint);
        user_inf.add(account);

        JLabel u_name_label = new JLabel("用户名：");
        u_name_label.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 2;
        user_inf_layout.setConstraints(u_name_label, user_inf_constraint);
        user_inf.add(u_name_label);

        JTextField u_name = new JTextField(20);
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 2;
        user_inf_layout.setConstraints(u_name, user_inf_constraint);
        user_inf.add(u_name);

        JLabel name_label1 = new JLabel("姓名:");
        name_label1.setFont(new Font("宋体", Font.BOLD, 16));
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 0;
        user_inf_constraint.gridy = 3;
        user_inf_layout.setConstraints(name_label1, user_inf_constraint);
        user_inf.add(name_label1);

        JTextField name = new JTextField(20);
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

        JTextField phone = new JTextField(20);
        user_inf_constraint.insets = new Insets(0, 0, 0, 0);
        user_inf_constraint.gridx = 1;
        user_inf_constraint.gridy = 4;
        user_inf_layout.setConstraints(phone, user_inf_constraint);
        user_inf.add(phone);

        JPanel btn_bar = new JPanel();
        GridBagLayout btn_bar_layout = new GridBagLayout();
        GridBagConstraints btn_bar_constraint = new GridBagConstraints();
        btn_bar.setLayout(btn_bar_layout);

        JButton btnA = new JButton("修改");
        btnA.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 0;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnA, btn_bar_constraint);
        btn_bar.add(btnA);
        JButton btnB = new JButton("返回");
        btnB.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 1;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnB, btn_bar_constraint);
        btn_bar.add(btnB);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 1;
        layout.setConstraints(user_inf, constraint);
        this.add(user_inf);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 3;
        layout.setConstraints(btn_bar, constraint);
        this.add(btn_bar);
        user u;
        try {
            u = select.getUser(Long.parseLong(idx));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        u_id.setText(String.valueOf(u.getId()));
        u_name.setText(u.getUser_name());
        name.setText(u.getName());
        phone.setText(String.valueOf(u.getTel()));
        account.setText(String.valueOf(u.getAccount()));

        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sname = name.getText();
                String su_name = u_name.getText();
                String sphone = (phone.getText());
                try {
                    update.updateUser(Long.parseLong(idx), sname, sphone, su_name);
                    JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "修改失败！", "错误", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });

        btnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
