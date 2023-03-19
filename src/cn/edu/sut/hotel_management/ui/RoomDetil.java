package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.room;
import cn.edu.sut.hotel_management.sql.insert;
import cn.edu.sut.hotel_management.sql.select;
import cn.edu.sut.hotel_management.sql.update;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RoomDetil extends JFrame {
    public RoomDetil(int idx) {
        this.setSize(350, 280);
        this.setLocationRelativeTo(null);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();
        this.setLayout(layout);

        JPanel room_inf = new JPanel();
        GridBagLayout room_inf_layout = new GridBagLayout();
        GridBagConstraints room_inf_constraint = new GridBagConstraints();
        room_inf.setLayout(room_inf_layout);

        JLabel r_id_label = new JLabel("房间id：");
        r_id_label.setFont(new Font("宋体", Font.BOLD, 16));
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 0;
        room_inf_constraint.gridy = 0;
        room_inf_layout.setConstraints(r_id_label, room_inf_constraint);
        room_inf.add(r_id_label);

        JLabel r_id = new JLabel();
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 1;
        room_inf_constraint.gridy = 0;
        room_inf_layout.setConstraints(r_id, room_inf_constraint);
        room_inf.add(r_id);

        JLabel num_label = new JLabel("房间号：");
        num_label.setFont(new Font("宋体", Font.BOLD, 16));
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 0;
        room_inf_constraint.gridy = 1;
        room_inf_layout.setConstraints(num_label, room_inf_constraint);
        room_inf.add(num_label);

        JTextField num = new JTextField(20);
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 1;
        room_inf_constraint.gridy = 1;
        room_inf_layout.setConstraints(num, room_inf_constraint);
        room_inf.add(num);

//        JLabel type_label = new JLabel("房间类型");
//        type_label.setFont(new Font("宋体", Font.BOLD, 16));
//        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
//        room_inf_constraint.gridx = 0;
//        room_inf_constraint.gridy = 2;
//        room_inf_layout.setConstraints(type_label, room_inf_constraint);
//        room_inf.add(type_label);
//
//        JTextField type = new JTextField(20);
//        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
//        room_inf_constraint.gridx = 1;
//        room_inf_constraint.gridy = 2;
//        room_inf_layout.setConstraints(room_bar, room_inf_constraint);
//        room_inf.add(room_bar);
        JPanel room_bar = new JPanel();
        GridBagLayout room_bar_layout = new GridBagLayout();
        GridBagConstraints room_bar_constraint = new GridBagConstraints();
        room_bar.setLayout(room_bar_layout);

        JLabel room_type_label1 = new JLabel("房型:");
        room_type_label1.setFont(new Font("宋体", Font.BOLD, 16));
        room_bar_constraint.insets = new Insets(0, 0, 0, 0);
        room_bar_constraint.gridheight = 1;
        room_bar_constraint.gridwidth = 1;
        room_bar_constraint.gridx = 0;
        room_bar_constraint.gridy = 0;
        room_bar_layout.setConstraints(room_type_label1, room_bar_constraint);
        room_bar.add(room_type_label1);

        JComboBox<String> room_type = new JComboBox<>();
        room_type.addItem("-请选择-");
        try {
            String[] datas = select.getAllRoomType();
            assert datas != null;
            for (String data : datas) {
                room_type.addItem(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        room_bar_constraint.insets = new Insets(0, 30, 0, 0);
        room_bar_constraint.gridx = 1;
        room_bar_constraint.gridy = 0;
        room_bar_layout.setConstraints(room_type, room_bar_constraint);
        room_bar.add(room_type);

//        JTextField type = new JTextField(20);
        room_inf_constraint.insets = new Insets(0, -175, 0, 0);
        room_inf_constraint.gridx = 1;
        room_inf_constraint.gridy = 2;
        room_inf_layout.setConstraints(room_bar, room_inf_constraint);
        room_inf.add(room_bar);

        JLabel prepay_label = new JLabel("预付款：");
        prepay_label.setFont(new Font("宋体", Font.BOLD, 16));
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 0;
        room_inf_constraint.gridy = 3;
        room_inf_layout.setConstraints(prepay_label, room_inf_constraint);
        room_inf.add(prepay_label);

        JTextField prepay = new JTextField(20);
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 1;
        room_inf_constraint.gridy = 3;
        room_inf_layout.setConstraints(prepay, room_inf_constraint);
        room_inf.add(prepay);

        JLabel money_label = new JLabel("租金：");
        money_label.setFont(new Font("宋体", Font.BOLD, 16));
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 0;
        room_inf_constraint.gridy = 5;
        room_inf_layout.setConstraints(money_label, room_inf_constraint);
        room_inf.add(money_label);

        JTextField money = new JTextField(20);
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 1;
        room_inf_constraint.gridy = 5;
        room_inf_layout.setConstraints(money, room_inf_constraint);
        room_inf.add(money);

        JLabel status_label = new JLabel("状态：");
        status_label.setFont(new Font("宋体", Font.BOLD, 16));
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 0;
        room_inf_constraint.gridy = 6;
        room_inf_layout.setConstraints(status_label, room_inf_constraint);
        room_inf.add(status_label);


        JTextField status = new JTextField(20);
        room_inf_constraint.insets = new Insets(0, 0, 0, 0);
        room_inf_constraint.gridx = 1;
        room_inf_constraint.gridy = 6;
        room_inf_layout.setConstraints(status, room_inf_constraint);
        room_inf.add(status);

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
        layout.setConstraints(room_inf, constraint);
        this.add(room_inf);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 3;
        layout.setConstraints(btn_bar, constraint);
        this.add(btn_bar);
        room ro;
        try {
            ro = select.getRoom(idx);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        r_id.setText(String.valueOf(ro.getId()));
        num.setText(ro.getNum());
        room_type.setSelectedItem(ro.getType());
        prepay.setText(String.valueOf(ro.getPrepay()));
        money.setText(String.valueOf(ro.getMoney()));
        status.setText(ro.getStatus());


        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String snum = num.getText();
                float sprepay = Float.parseFloat(prepay.getText());
                float smoney = Float.parseFloat(money.getText());
                String sroomtype = (String) room_type.getSelectedItem();
                String spriceid = null;
                try {
                    sroomtype = select.getTypeId((String) room_type.getSelectedItem());
                    spriceid = select.getPriceId(sprepay, smoney);
                    if (spriceid == null) {
                        int priceid = insert.addPrice(sprepay, smoney);
                        spriceid = String.valueOf(priceid);
                    }
                    update.updateRoom(String.valueOf(ro.getId()), snum, sroomtype, spriceid);
                    JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
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

    }

}
