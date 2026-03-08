package main.java.dao;

import main.java.model.entity.Room;
import main.java.model.entity.Theatre;

import java.util.List;

public interface TheatreDAO {
    List<String> getAvailableCity();
    List<Theatre> getTheatresByCity(String city);
    Theatre getTheatresById(int theatre_id);
    List<Room> getRooms(int theatre_id);
}
