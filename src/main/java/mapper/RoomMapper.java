package main.java.mapper;

import main.java.model.entity.Room;
import main.java.model.enums.RoomStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomMapper {
    public static Room map(ResultSet rs) throws SQLException {
        int id = rs.getInt("room_id");
        String room_name = rs.getString("room_name");
        String room_type = rs.getString("room_type");
        int capacity = rs.getInt("capacity");
        RoomStatus room_status = RoomStatus.valueOf(rs.getString("room_status"));
        return new Room(id, room_name, room_type, capacity, room_status);
    }
}
