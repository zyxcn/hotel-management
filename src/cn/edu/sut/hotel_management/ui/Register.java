package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.sql.insert;
import cn.edu.sut.hotel_management.sql.select;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Register extends JFrame {

    public Register() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();
        this.setLayout(layout);

        JPanel register = new JPanel();
        GridBagLayout register_layout = new GridBagLayout();
        GridBagConstraints register_constraint = new GridBagConstraints();
        register.setLayout(register_layout);

        JLabel account_label = new JLabel("账号");
        account_label.setFont(new Font("宋体", Font.BOLD, 16));
        register_constraint.insets = new Insets(0, 0, 0, 0);
        register_constraint.gridx = 0;
        register_constraint.gridy = 0;
        register_layout.setConstraints(account_label, register_constraint);
        register.add(account_label);

        JTextField account = new JTextField(20);
        register_constraint.insets = new Insets(0, 20, 0, 0);
        register_constraint.gridx = 1;
        register_constraint.gridy = 0;
        register_layout.setConstraints(account, register_constraint);
        register.add(account);

        JLabel password_label = new JLabel("密码");
        password_label.setFont(new Font("宋体", Font.BOLD, 16));
        register_constraint.insets = new Insets(0, 0, 0, 0);
        register_constraint.gridx = 0;
        register_constraint.gridy = 1;
        register_layout.setConstraints(password_label, register_constraint);
        register.add(password_label);

        JTextField password = new JTextField(20);
        register_constraint.insets = new Insets(0, 20, 0, 0);
        register_constraint.gridx = 1;
        register_constraint.gridy = 1;
        register_layout.setConstraints(password, register_constraint);
        register.add(password);

        JLabel confirm_label = new JLabel("确认密码");
        confirm_label.setFont(new Font("宋体", Font.BOLD, 16));
        register_constraint.insets = new Insets(0, 0, 0, 0);
        register_constraint.gridx = 0;
        register_constraint.gridy = 2;
        register_layout.setConstraints(confirm_label, register_constraint);
        register.add(confirm_label);

        JTextField confirm = new JTextField(20);
        register_constraint.insets = new Insets(0, 20, 0, 0);
        register_constraint.gridx = 1;
        register_constraint.gridy = 2;
        register_layout.setConstraints(confirm, register_constraint);
        register.add(confirm);

        JPanel btn_bar = new JPanel();
        GridBagLayout btn_bar_layout = new GridBagLayout();
        GridBagConstraints btn_bar_constraint = new GridBagConstraints();
        btn_bar.setLayout(btn_bar_layout);

        JButton btnA = new JButton("注册");
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

        constraint.insets = new Insets(50, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 0;
        layout.setConstraints(register, constraint);
        this.add(register);

        constraint.insets = new Insets(50, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 1;
        layout.setConstraints(btn_bar, constraint);
        this.add(btn_bar);

        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String saccount = account.getText();
                String spwd = password.getText();
                String scon = confirm.getText();
                try {
                    if (!select.isAccountExist(saccount)) {
                        insert.register(saccount, spwd);
                        JOptionPane.showMessageDialog(null, "注册成功，请完善信息", "提示", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "注册失败,账号已存在", "提示", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "注册失败，出现sql错误", "提示", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });
        btnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login l = new Login();
                l.setVisible(true);
            }
        });
    }


    public static void create() {
        Register register = new Register();
        register.setSize(400, 300);
        register.setTitle("注册");
        register.setLocationRelativeTo(null);
        register.setVisible(true);
    }

}