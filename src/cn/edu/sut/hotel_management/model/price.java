package cn.edu.sut.hotel_management.model;

public class price {
    private final int id;
    private final float money;
    private final float prepay;

    public price(int id, float money, float prepay) {
        this.id = id;
        this.money = money;
        this.prepay = prepay;
    }

}
