package main.java.service;

import main.java.dto.RoomPreviewDTO;
import main.java.dto.TheatreDetailDTO;
import main.java.dto.TheatreThumnailDTO;

import java.util.List;

public interface TheatreServices {
    List<String> getAvailableCity();
    List<TheatreThumnailDTO> getTheatresByCity(String city);
    TheatreDetailDTO getTheatresByID(int theatre_id);
    List<RoomPreviewDTO> getRooms(int theatre_id);
}
