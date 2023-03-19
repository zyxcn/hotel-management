package cn.edu.sut.hotel_management.model;

import java.util.Objects;

public class curuser {
    public static long id;
    private static String img_url;
    private static String name;
    private static String id_card;
    private static String sex;
    private static String tel;
    private static String status;
    private static String account;
    private static String user_name;
    private static String password;

    public curuser(long id, String img_url, String name, String id_card, String sex, String tel, String status, String account, String user_name, String password) {
        curuser.id = id;
        curuser.img_url = img_url;
        curuser.name = name;
        curuser.id_card = id_card;
        curuser.sex = sex;
        curuser.tel = tel;
        curuser.status = status;
        curuser.account = account;
        curuser.user_name = user_name;
        curuser.password = password;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        curuser.id = id;
    }

    public static String getImg_url() {
        return img_url;
    }

    public static void setImg_url(String img_url) {
        curuser.img_url = img_url;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        curuser.name = name;
    }

    public static String getId_card() {
        return id_card;
    }

    public static void setId_card(String id_card) {
        curuser.id_card = id_card;
    }

    public static String getSex() {
        return sex;
    }

    public static void setSex(String sex) {
        curuser.sex = sex;
    }

    public static String getTel() {
        return tel;
    }

    public static void setTel(String tel) {
        curuser.tel = tel;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        curuser.status = status;
    }

    public static String getAccount() {
        return account;
    }

    public static void setAccount(String account) {
        curuser.account = account;
    }

    public static String getUser_name() {
        return user_name;
    }

    public static void setUser_name(String user_name) {
        curuser.user_name = user_name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        curuser.password = password;
    }

    public static void logout() {
        curuser.id = 0;
        curuser.img_url = null;
        curuser.name = null;
        curuser.id_card = null;
        curuser.sex = null;
        curuser.tel = null;
        curuser.status = null;
        curuser.account = null;
        curuser.user_name = null;
        curuser.password = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        curuser curuser = (curuser) o;
        return account.equals(account) && password.equals(password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password);
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", img_url='" + img_url + '\'' +
                ", name='" + name + '\'' +
                ", id_card='" + id_card + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", status='" + status + '\'' +
                ", account='" + account + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
