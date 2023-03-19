package cn.edu.sut.hotel_management.model;

import java.util.Objects;

public class relation {
    private final int id;
    private final long user_id;
    private final int room_id;
    private final long order_id;
    private final int admin_id;
    private final String status;

    public relation(int id, long user_id, int room_id, long order_id, int admin_id, String status) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.order_id = order_id;
        this.admin_id = admin_id;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        relation relation = (relation) o;
        return id == relation.id && user_id == relation.user_id && room_id == relation.room_id && order_id == relation.order_id && admin_id == relation.admin_id;
    }

    @Override
    public String toString() {
        return "relation{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", room_id=" + room_id +
                ", order_id=" + order_id +
                ", admin_id=" + admin_id +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, room_id, order_id, admin_id);
    }
}
