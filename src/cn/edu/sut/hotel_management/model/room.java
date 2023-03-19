package cn.edu.sut.hotel_management.model;

import java.util.Objects;

public class room {
    private int id;
    private String num;

    private String type;

    private float money;
    private float prepay;

    private String status;

    public room(int id, String num, String type, float prepay, float money, String status) {
        this.id = id;
        this.num = num;
        this.type = type;
        this.money = money;
        this.prepay = prepay;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getPrepay() {
        return prepay;
    }

    public void setPrepay(float prepay) {
        this.prepay = prepay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "room{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", prepay=" + prepay +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        room room = (room) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
