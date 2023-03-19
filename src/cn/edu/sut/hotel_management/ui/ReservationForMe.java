package cn.edu.sut.hotel_management.ui;

import cn.edu.sut.hotel_management.model.curuser;
import cn.edu.sut.hotel_management.sql.insert;
import cn.edu.sut.hotel_management.sql.select;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class ReservationForMe extends JFrame {
    public ReservationForMe() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();
        this.setLayout(layout);

//        constraint.insets = new Insets(0, 0, 0, 0);
//        JLabel picture_label = new JLabel("照片");
//        picture_label.setFont(new Font("宋体", Font.BOLD, 16));
//        constraint.gridx = 0;
//        constraint.gridy = 0;
//        layout.setConstraints(picture_label, constraint);
//        this.add(picture_label);


        JPanel date_select = new JPanel();
        GridBagLayout date_select_layout = new GridBagLayout();
        GridBagConstraints date_select_constraint = new GridBagConstraints();
        date_select.setLayout(date_select_layout);

        JLabel date_label1 = new JLabel("入住日期:");
        date_label1.setFont(new Font("宋体", Font.BOLD, 16));
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridheight = 1;
        date_select_constraint.gridwidth = 1;
        date_select_constraint.gridx = 0;
        date_select_constraint.gridy = 0;
        date_select_layout.setConstraints(date_label1, date_select_constraint);
        date_select.add(date_label1);


        JComboBox<String> year = new JComboBox<>();
        year.addItem("-请选择-");
        for (int i = 2024; i >= 2023; i--) {
            year.addItem(String.valueOf(i));
        }
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 1;
        date_select_constraint.gridy = 0;
        date_select_layout.setConstraints(year, date_select_constraint);
        date_select.add(year);

        JLabel date_label2 = new JLabel("年");
        date_label2.setFont(new Font("宋体", Font.BOLD, 16));
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 2;
        date_select_constraint.gridy = 0;
        date_select_layout.setConstraints(date_label2, date_select_constraint);
        date_select.add(date_label2);

        JComboBox<String> mon = new JComboBox<>();
        mon.addItem("-请选择-");
        for (int i = 12; i >= 1; i--) {
            mon.addItem(String.valueOf(i));
        }
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 3;
        date_select_constraint.gridy = 0;
        date_select_layout.setConstraints(mon, date_select_constraint);
        date_select.add(mon);

        JLabel date_label3 = new JLabel("月");
        date_label3.setFont(new Font("宋体", Font.BOLD, 16));
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 4;
        date_select_constraint.gridy = 0;
        date_select_layout.setConstraints(date_label3, date_select_constraint);
        date_select.add(date_label3);

        JComboBox<String> day = new JComboBox<>();
        day.addItem("-请选择-");
        for (int i = 31; i >= 1; i--) {
            day.addItem(String.valueOf(i));
        }
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 5;
        date_select_constraint.gridy = 0;
        date_select_layout.setConstraints(day, date_select_constraint);
        date_select.add(day);

        JLabel date_label4 = new JLabel("日");
        date_label4.setFont(new Font("宋体", Font.BOLD, 16));
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 6;
        date_select_constraint.gridy = 0;
        date_select_layout.setConstraints(date_label4, date_select_constraint);
        date_select.add(date_label4);


        JLabel date1_label1 = new JLabel("离开日期:");
        date1_label1.setFont(new Font("宋体", Font.BOLD, 16));
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridheight = 1;
        date_select_constraint.gridwidth = 1;
        date_select_constraint.gridx = 0;
        date_select_constraint.gridy = 1;
        date_select_layout.setConstraints(date1_label1, date_select_constraint);
        date_select.add(date1_label1);

        JComboBox<String> year1 = new JComboBox<>();
        year1.addItem("-请选择-");
        for (int i = 2024; i >= 2023; i--) {
            year1.addItem(String.valueOf(i));
        }
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 1;
        date_select_constraint.gridy = 1;
        date_select_layout.setConstraints(year1, date_select_constraint);
        date_select.add(year1);

        JLabel date1_label2 = new JLabel("年");
        date1_label2.setFont(new Font("宋体", Font.BOLD, 16));
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 2;
        date_select_constraint.gridy = 1;
        date_select_layout.setConstraints(date1_label2, date_select_constraint);
        date_select.add(date1_label2);

        JComboBox<String> mon1 = new JComboBox<>();
        mon1.addItem("-请选择-");
        for (int i = 12; i >= 1; i--) {
            mon1.addItem(String.valueOf(i));
        }
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 3;
        date_select_constraint.gridy = 1;
        date_select_layout.setConstraints(mon1, date_select_constraint);
        date_select.add(mon1);

        JLabel date1_label3 = new JLabel("月");
        date1_label3.setFont(new Font("宋体", Font.BOLD, 16));
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 4;
        date_select_constraint.gridy = 1;
        date_select_layout.setConstraints(date1_label3, date_select_constraint);
        date_select.add(date1_label3);

        JComboBox<String> day1 = new JComboBox<>();
        day1.addItem("-请选择-");
        for (int i = 31; i >= 1; i--) {
            day1.addItem(String.valueOf(i));
        }
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 5;
        date_select_constraint.gridy = 1;
        date_select_layout.setConstraints(day1, date_select_constraint);
        date_select.add(day1);

        JLabel date1_label4 = new JLabel("日");
        date1_label4.setFont(new Font("宋体", Font.BOLD, 16));
        date_select_constraint.insets = new Insets(0, 0, 0, 0);
        date_select_constraint.gridx = 6;
        date_select_constraint.gridy = 1;
        date_select_layout.setConstraints(date1_label4, date_select_constraint);
        date_select.add(date1_label4);


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
        room_bar_constraint.insets = new Insets(0, 0, 0, 0);
        room_bar_constraint.gridx = 1;
        room_bar_constraint.gridy = 0;
        room_bar_layout.setConstraints(room_type, room_bar_constraint);
        room_bar.add(room_type);


        JLabel room_id_label1 = new JLabel("房号:");
        room_id_label1.setFont(new Font("宋体", Font.BOLD, 16));
        room_bar_constraint.insets = new Insets(0, 0, 0, 0);
        room_bar_constraint.gridheight = 1;
        room_bar_constraint.gridwidth = 1;
        room_bar_constraint.gridx = 0;
        room_bar_constraint.gridy = 1;
        room_bar_layout.setConstraints(room_id_label1, room_bar_constraint);
        room_bar.add(room_id_label1);

        JComboBox<String> room_id = new JComboBox<>();
        room_id.addItem("-请选择-");

        room_type.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    if (room_type.getSelectedItem() == null) {
                        itemStateChanged(e);
                    }
                    String[] datas1 = select.getAllRoomNum((String) room_type.getSelectedItem());
                    room_id.removeAllItems();
                    for (String data : datas1) {
                        room_id.addItem(data);
                    }
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });
        room_bar_constraint.insets = new Insets(0, 0, 0, 0);
        room_bar_constraint.gridx = 1;
        room_bar_constraint.gridy = 1;
        room_bar_layout.setConstraints(room_id, room_bar_constraint);
        room_bar.add(room_id);

        JPanel btn_bar = new JPanel();
        GridBagLayout btn_bar_layout = new GridBagLayout();
        GridBagConstraints btn_bar_constraint = new GridBagConstraints();
        btn_bar.setLayout(btn_bar_layout);

        JButton btnY = new JButton("确认");
        btnY.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 0;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnY, btn_bar_constraint);
        btn_bar.add(btnY);
        JButton btnN = new JButton("取消");
        btnN.setFont(new Font("宋体", Font.BOLD, 16));
        btn_bar_constraint.gridx = 1;
        btn_bar_constraint.gridy = 0;
        btn_bar_layout.setConstraints(btnN, btn_bar_constraint);
        btn_bar.add(btnN);

        btnY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int stay = -1;
                String syear = null;
                String smon = null;
                String sday = null;
                String syear1 = null;
                String smon1 = null;
                String sday1 = null;
                try {
                    syear = (String) year.getSelectedItem();
                    smon = (String) mon.getSelectedItem();
                    sday = (String) day.getSelectedItem();
                    syear1 = (String) year1.getSelectedItem();
                    smon1 = (String) mon1.getSelectedItem();
                    sday1 = (String) day1.getSelectedItem();
                    stay = select.getDateDiff(syear + "-" + smon + "-" + sday, syear1 + "-" + smon1 + "-" + sday1);
                    if (stay <= 0) {
                        JOptionPane.showMessageDialog(null, "时间填写有误！", "提示", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "时间填写有误！", "提示", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }
                String sid = (String) room_id.getSelectedItem();
                float[] fprice;
                try {
                    fprice = select.getRoomPrice(sid);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (fprice[0] <= 0 || fprice[1] <= 0) {
                    JOptionPane.showMessageDialog(null, "房间价格有误！", "提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int opt = JOptionPane.showConfirmDialog(null, "您需要支付" + String.format("%.2f", fprice[0] * stay) + "元", "支付确认", JOptionPane.OK_CANCEL_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    try {
                        int order_id = insert.addOrder(syear + "-" + smon + "-" + sday, stay, fprice[0] * stay, fprice[0] * stay, fprice[1] * stay, curuser.getId_card(), curuser.getName(), curuser.getTel());
                        String room_id = select.getRoomId(sid);
                        insert.addRealtion(String.valueOf(curuser.getId()), room_id, String.valueOf(order_id), "有效");
                        JOptionPane.showConfirmDialog(null, "支付成功", "提示", JOptionPane.DEFAULT_OPTION);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "信息填写有误！", "提示", JOptionPane.ERROR_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }


            }
        });

        btnN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 0;
        layout.setConstraints(date_select, constraint);
        this.add(date_select);

        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 3;
        layout.setConstraints(btn_bar, constraint);
        this.add(btn_bar);


        constraint.insets = new Insets(0, 0, 0, 0);
        constraint.gridx = 0;
        constraint.gridy = 2;
        layout.setConstraints(room_bar, constraint);
        this.add(room_bar);

    }

    public static void create() {
        ReservationForMe reservationForMe = new ReservationForMe();
        reservationForMe.setSize(600, 350);
        reservationForMe.setTitle("预定办理");
        reservationForMe.setLocationRelativeTo(null);
        reservationForMe.setVisible(true);
    }
}
