package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.order;
import cn.edu.sut.hotel_management.sql.delete;
import cn.edu.sut.hotel_management.sql.select;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OrderDetil extends JFrame {
    order o;

    public OrderDetil(long idx) {
        this.setSize(350, 280);
        this.setLocationRelativeTo(null);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();
        this.setLayout(layout);

        JPanel order_inf = new JPanel();
        GridBagLayout order_inf_layout = new GridBagLayout();
        GridBagConstraints order_inf_constraint = new GridBagConstraints();
        order_inf.setLayout(order_inf_layout);

        JLabel o_id_label = new JLabel("订单号：");
        o_id_label.setFont(new Font("宋体", Font.BOLD, 16));
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 0;
        order_inf_constraint.gridy = 0;
        order_inf_layout.setConstraints(o_id_label, order_inf_constraint);
        order_inf.add(o_id_label);

        JLabel o_id = new JLabel();
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 1;
        order_inf_constraint.gridy = 0;
        order_inf_layout.setConstraints(o_id, order_inf_constraint);
        order_inf.add(o_id);

        JLabel id_label = new JLabel("身份证号：");
        id_label.setFont(new Font("宋体", Font.BOLD, 16));
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 0;
        order_inf_constraint.gridy = 1;
        order_inf_layout.setConstraints(id_label, order_inf_constraint);
        order_inf.add(id_label);

        JLabel id = new JLabel();
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 1;
        order_inf_constraint.gridy = 1;
        order_inf_layout.setConstraints(id, order_inf_constraint);
        order_inf.add(id);

        JLabel name_label = new JLabel("姓名：");
        name_label.setFont(new Font("宋体", Font.BOLD, 16));
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 0;
        order_inf_constraint.gridy = 2;
        order_inf_layout.setConstraints(name_label, order_inf_constraint);
        order_inf.add(name_label);

        JLabel name = new JLabel();
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 1;
        order_inf_constraint.gridy = 2;
        order_inf_layout.setConstraints(name, order_inf_constraint);
        order_inf.add(name);

        JLabel phone_label = new JLabel("手机号：");
        phone_label.setFont(new Font("宋体", Font.BOLD, 16));
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 0;
        order_inf_constraint.gridy = 3;
        order_inf_layout.setConstraints(phone_label, order_inf_constraint);
        order_inf.add(phone_label);

        JLabel phone = new JLabel();
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 1;
        order_inf_constraint.gridy = 3;
        order_inf_layout.setConstraints(phone, order_inf_constraint);
        order_inf.add(phone);

        JLabel start_label = new JLabel("起租时间：");
        start_label.setFont(new Font("宋体", Font.BOLD, 16));
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 0;
        order_inf_constraint.gridy = 5;
        order_inf_layout.setConstraints(start_label, order_inf_constraint);
        order_inf.add(start_label);

        JLabel start = new JLabel();
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 1;
        order_inf_constraint.gridy = 5;
        order_inf_layout.setConstraints(start, order_inf_constraint);
        order_inf.add(start);

        JLabel stay_label = new JLabel("居住天数：");
        stay_label.setFont(new Font("宋体", Font.BOLD, 16));
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 0;
        order_inf_constraint.gridy = 6;
        order_inf_layout.setConstraints(stay_label, order_inf_constraint);
        order_inf.add(stay_label);


        JLabel stay = new JLabel();
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 1;
        order_inf_constraint.gridy = 6;
        order_inf_layout.setConstraints(stay, order_inf_constraint);
        order_inf.add(stay);

        JLabel pay_label = new JLabel("实付款：");
        pay_label.setFont(new Font("宋体", Font.BOLD, 16));
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 0;
        order_inf_constraint.gridy = 7;
        order_inf_layout.setConstraints(pay_label, order_inf_constraint);
        order_inf.add(pay_label);

        JLabel pay = new JLabel();
        order_inf_constraint.insets = new Insets(0, 0, 0, 0);
        order_inf_constraint.gridx = 1;
        order_inf_constraint.gridy = 7;
        order_inf_layout.setConstraints(pay, order_inf_constraint);
        order_inf.add(pay);


        JPanel btn_bar = new JPanel();
        GridBagLayout btn_bar_layout = new GridBagLayout();
        GridBagConstraints btn_bar_constraint = new GridBagConstraints();
        btn_bar.setLayout(btn_bar_layout);

        JButton btnA = new JButton("取消订单");
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
        layout.setConstraints(order_inf, constraint);
        this.add(order_inf);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 3;
        layout.setConstraints(btn_bar, constraint);
        this.add(btn_bar);
//        order o = new order(idx);
        try {
            o = select.getOrder(idx);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        o_id.setText(String.valueOf(o.getId()));
        id.setText(o.getId_card());
        name.setText(o.getName());
        phone.setText(o.getPhone());
        start.setText(o.getBegin());
        stay.setText(String.valueOf(o.getStay()));
        pay.setText(String.valueOf(o.getPay()));

        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int datesur = select.getDateCur(o.getBegin());
                    if (o.getStay() + datesur < 0) {
                        int opt = JOptionPane.showConfirmDialog(null, "该订单已结束,您要将其删除吗？", "询问", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (opt == JOptionPane.YES_OPTION) {
                            delete.deleteOrder(idx);
                            dispose();
                            JOptionPane.showConfirmDialog(null, "删除成功", "提示", JOptionPane.DEFAULT_OPTION);
                        }
                        return;
                    }
                    if (datesur >= 0) {
                        int opt = JOptionPane.showConfirmDialog(null, "将给您退款" + String.format("%.2f", o.getPay()) + "元", "退款", JOptionPane.OK_CANCEL_OPTION);
                        if (opt == JOptionPane.YES_OPTION) {
                            delete.deleteOrder(idx);
                            JOptionPane.showConfirmDialog(null, "退款成功", "提示", JOptionPane.DEFAULT_OPTION);

                        }
                        return;
                    }
                    float money = o.getPay() *(o.getStay()+datesur)/(float)o.getStay();
                    if (money <= 0) {
                        JOptionPane.showMessageDialog(null, "当前订单生效，但无款可退！", "提示", JOptionPane.ERROR_MESSAGE);
                        dispose();
                        return;
                    }
                    int opt = JOptionPane.showConfirmDialog(null, "将给您退款" + String.format("%.2f", money) + "元", "退款", JOptionPane.OK_CANCEL_OPTION);
                    if (opt == JOptionPane.YES_OPTION) {
                        delete.deleteOrder(idx);
                        JOptionPane.showConfirmDialog(null, "退款成功", "提示", JOptionPane.DEFAULT_OPTION);

                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "订单出错！", "提示", JOptionPane.ERROR_MESSAGE);
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
