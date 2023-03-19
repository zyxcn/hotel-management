package cn.edu.sut.hotel_management.model;

import java.util.Objects;

public class admin {
    private int id;
    private String name;
    private String account;
    private String password;
    private String user_name;
    private String img_url;
    private String id_card;
    private String tel;

    public admin(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public admin() {
    }

    public admin(int id, String name, String account, String password, String user_name, String img_url, String id_card, String tel) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.user_name = user_name;
        this.img_url = img_url;
        this.id_card = id_card;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", img_url='" + img_url + '\'' +
                ", id_card='" + id_card + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        admin admin = (admin) o;
        return account.equals(admin.account) && password.equals(admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password);
    }
}
