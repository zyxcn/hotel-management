package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.ui.component.ContainerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame {
    public Login() {
        setBounds(200, 200, 400, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        setTitle("登录");
        JLabel j1 = new JLabel("账号");
        j1.setFont(new Font("宋体", Font.BOLD, 16));
        j1.setBounds(50, 50, 100, 20);
        JLabel j2 = new JLabel("密码");
        j2.setFont(new Font("宋体", Font.BOLD, 16));
        j2.setBounds(50, 100, 100, 20);
        JTextField username = new JTextField();
        username.setBounds(150, 50, 200, 20);
        JPasswordField password = new JPasswordField();
        password.setBounds(150, 100, 200, 20);
        JButton login = new JButton("登录");
        login.setFont(new Font("宋体", Font.BOLD, 16));
        login.setBounds(80, 150, 100, 30);
        JButton register = new JButton("注册");
        register.setFont(new Font("宋体", Font.BOLD, 16));
        register.setBounds(220, 150, 100, 30);
        c.add(j1);
        c.add(username);
        c.add(j2);
        c.add(password);
        c.add(login);
        c.add(register);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = username.getText();
                String pwd = new String(password.getPassword());
                try {
                    if (select.login(uname, pwd)) {
                        curuser.setId(select.getId(uname));
                        select.getCurUser(curuser.getId());
                        ContainerComponent container = new ContainerComponent();
                        container.setVisible(true);
                        System.out.println(select.getId(uname));
                        JOptionPane.showMessageDialog(null, "登录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "登录失败！", "提示", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.create();
                dispose();
            }
        });
    }
}