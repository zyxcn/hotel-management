package cn.edu.sut.hotel_management.model;

import java.util.Objects;

public class order {
    private long id;
    private String begin;
    private int stay;
    private float prepay;
    private float pay;
    private float rental;
    private String id_card;
    private String name;
    private String phone;

    public order(long id) {
        this.id = id;
    }

    public order(long id, String begin, int stay, float prepay, float pay, float rental) {
        this.id = id;
        this.begin = begin;
        this.stay = stay;
        this.prepay = prepay;
        this.pay = pay;
        this.rental = rental;
    }

    public order(long id, String begin, int stay, float prepay, float pay, float rental, String id_card, String name, String phone) {
        this.id = id;
        this.begin = begin;
        this.stay = stay;
        this.prepay = prepay;
        this.pay = pay;
        this.rental = rental;
        this.id_card = id_card;
        this.name = name;
        this.phone = phone;
    }

    public order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public int getStay() {
        return stay;
    }

    public void setStay(int stay) {
        this.stay = stay;
    }

    public float getPrepay() {
        return prepay;
    }

    public void setPrepay(float prepay) {
        this.prepay = prepay;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    public float getRental() {
        return rental;
    }

    public void setRental(float rental) {
        this.rental = rental;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        order order = (order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", begin='" + begin + '\'' +
                ", stay='" + stay + '\'' +
                ", prepay='" + prepay + '\'' +
                ", pay='" + pay + '\'' +
                ", rental='" + rental + '\'' +
                '}';
    }


}
