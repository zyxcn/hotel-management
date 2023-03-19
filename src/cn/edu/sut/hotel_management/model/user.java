package cn.edu.sut.hotel_management.model;

public class user {
    public long id;
    private String img_url;
    private String name;
    private String id_card;
    private String sex;
    private String tel;
    private String status;
    private String account;
    private String user_name;
    private String password;

    public user(long id, String img_url, String name, String id_card, String sex, String tel, String status, String account, String user_name, String password) {
        this.id = id;
        this.img_url = img_url;
        this.name = name;
        this.id_card = id_card;
        this.sex = sex;
        this.tel = tel;
        this.status = status;
        this.account = account;
        this.user_name = user_name;
        this.password = password;
    }

    public user(long id, String name, String tel, String account, String user_name) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.account = account;
        this.user_name = user_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
