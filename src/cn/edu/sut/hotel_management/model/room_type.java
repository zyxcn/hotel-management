package cn.edu.sut.hotel_management.model;

public class room_type {
    private final int id;
    private final String type;

    public room_type(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "room_type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
