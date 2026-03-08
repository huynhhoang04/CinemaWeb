package main.java.model.entity;

import main.java.model.enums.RoomStatus;

public class Room {
    private int id;
    private String room_name;
    private String room_type;
    private int capacity;
    private int theatre_id;
    private RoomStatus room_status;

    public Room(int id, String room_name, String room_type, int capacity, RoomStatus room_status) {
        this.id = id;
        this.room_name = room_name;
        this.room_type = room_type;
        this.capacity = capacity;
        this.room_status = room_status;
    }

    public int getId() {
        return id;
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

    public int getTheatre_id() {
        return theatre_id;
    }

    public RoomStatus getRoom_status() {
        return room_status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTheatre_id(int theatre_id) {
        this.theatre_id = theatre_id;
    }

    public void setRoom_status(RoomStatus room_status) {
        this.room_status = room_status;
    }
}
