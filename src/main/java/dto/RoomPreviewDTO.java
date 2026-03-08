package main.java.dto;

import main.java.model.enums.RoomStatus;

public class RoomPreviewDTO {
    private int room_id;
    private String room_name;
    private String room_type;
    private int capacity;

    public RoomPreviewDTO(int room_id, String room_name, String room_type, int capacity) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_type = room_type;
        this.capacity = capacity;
    }

    public int getRoom_id() {
        return room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public String getRoom_type() {
        return room_type;
    }

    public int getCapacity() {
        return capacity;
    }
}
