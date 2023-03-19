package cn.edu.sut.hotel_management.ui.component;

import javax.swing.*;

public class ContainerComponent extends JFrame {
    public ContainerComponent() {
        super("酒店管理系统");
        this.getContentPane().add(new Tab());
        this.pack();
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
