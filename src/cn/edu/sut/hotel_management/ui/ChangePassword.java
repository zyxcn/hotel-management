package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.sql.update;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ChangePassword extends JFrame {
    public ChangePassword() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();
        this.setLayout(layout);

        JPanel change_pwd = new JPanel();
        GridBagLayout change_pwd_layout = new GridBagLayout();
        GridBagConstraints change_pwd_constraint = new GridBagConstraints();
        change_pwd.setLayout(change_pwd_layout);

        JLabel old_pwd_label = new JLabel("旧密码：");
        old_pwd_label.setFont(new Font("宋体", Font.BOLD, 16));
        change_pwd_constraint.insets = new Insets(0, 0, 0, 0);
        change_pwd_constraint.gridx = 0;
        change_pwd_constraint.gridy = 2;
        change_pwd_layout.setConstraints(old_pwd_label, change_pwd_constraint);
        change_pwd.add(old_pwd_label);

        JTextField old_pwd = new JTextField(20);
        change_pwd_constraint.insets = new Insets(0, 0, 0, 0);
        change_pwd_constraint.gridx = 1;
        change_pwd_constraint.gridy = 2;
        change_pwd_layout.setConstraints(old_pwd, change_pwd_constraint);
        change_pwd.add(old_pwd);

        JLabel new_pwd_label = new JLabel("新密码：");
        new_pwd_label.setFont(new Font("宋体", Font.BOLD, 16));
        change_pwd_constraint.insets = new Insets(0, 0, 0, 0);
        change_pwd_constraint.gridx = 0;
        change_pwd_constraint.gridy = 3;
        change_pwd_layout.setConstraints(new_pwd_label, change_pwd_constraint);
        change_pwd.add(new_pwd_label);

        JTextField new_pwd = new JTextField(20);
        change_pwd_constraint.insets = new Insets(0, 0, 0, 0);
        change_pwd_constraint.gridx = 1;
        change_pwd_constraint.gridy = 3;
        change_pwd_layout.setConstraints(new_pwd, change_pwd_constraint);
        change_pwd.add(new_pwd);

        JLabel confirm_pwd_label = new JLabel("确认密码：");
        confirm_pwd_label.setFont(new Font("宋体", Font.BOLD, 16));
        change_pwd_constraint.insets = new Insets(0, 0, 0, 0);
        change_pwd_constraint.gridx = 0;
        change_pwd_constraint.gridy = 4;
        change_pwd_layout.setConstraints(confirm_pwd_label, change_pwd_constraint);
        change_pwd.add(confirm_pwd_label);

        JTextField confirm_pwd = new JTextField(20);
        change_pwd_constraint.insets = new Insets(0, 0, 0, 0);
        change_pwd_constraint.gridx = 1;
        change_pwd_constraint.gridy = 4;
        change_pwd_layout.setConstraints(confirm_pwd, change_pwd_constraint);
        change_pwd.add(confirm_pwd);

        JPanel btn_bar = new JPanel();
        GridBagLayout btn_bar_layout = new GridBagLayout();
        GridBagConstraints btn_bar_constraint = new GridBagConstraints();
        btn_bar.setLayout(btn_bar_layout);

        JButton btnA = new JButton("确认");
        btnA.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 0;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnA, btn_bar_constraint);
        btn_bar.add(btnA);
        JButton btnB = new JButton("取消");
        btnB.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 1;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnB, btn_bar_constraint);
        btn_bar.add(btnB);

        btnA.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String sold = old_pwd.getText();
                String snew = new_pwd.getText();
                String scon = confirm_pwd.getText();
                try {
                    if (sold.equals(select.getPassword()) && snew.equals(scon)) {
                        update.updatePassword(curuser.getId(), confirm_pwd.getText());
                        JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "修改失败！", "提示", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "修改失败！", "提示", JOptionPane.ERROR_MESSAGE);
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

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 0;
        layout.setConstraints(change_pwd, constraint);
        this.add(change_pwd);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 1;
        layout.setConstraints(btn_bar, constraint);
        this.add(btn_bar);
    }

    public static void create() {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setSize(350, 200);
        changePassword.setLocationRelativeTo(null);
        changePassword.setTitle("修改密码");
        changePassword.setVisible(true);
    }
}
