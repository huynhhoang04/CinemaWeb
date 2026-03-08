package main.java.service.impl;

import main.java.dao.TheatreDAO;
import main.java.dto.RoomPreviewDTO;
import main.java.dto.TheatreDetailDTO;
import main.java.dto.TheatreThumnailDTO;
import main.java.model.entity.Room;
import main.java.model.entity.Theatre;
import main.java.service.TheatreServices;

import java.util.ArrayList;
import java.util.List;

public class TheatreServicesImpl implements TheatreServices {
    private TheatreDAO theatreDAO;

    public TheatreServicesImpl(TheatreDAO theatreDAO) {this.theatreDAO = theatreDAO;}

    @Override
    public List<String> getAvailableCity() {
        return theatreDAO.getAvailableCity();
    }

    @Override
    public List<TheatreThumnailDTO> getTheatresByCity(String city) {
        List<Theatre> theatres = theatreDAO.getTheatresByCity(city);
        List<TheatreThumnailDTO> theatreThumnailDTOList = new ArrayList<>();
        theatres.forEach(theatre -> {
            theatreThumnailDTOList.add(new TheatreThumnailDTO(theatre.getTheatre_id(), theatre.getTheatre_name(), theatre.getLocation(), theatre.getPreview_url()));
        });
        return theatreThumnailDTOList;
    }

    @Override
    public TheatreDetailDTO getTheatresByID(int theatre_id) {
        Theatre theatre = theatreDAO.getTheatresById(theatre_id);
        return new TheatreDetailDTO(theatre.getTheatre_id(), theatre.getTheatre_name(), theatre.getLocation(), theatre.getPreview_url(), theatre.getInfo(), theatre.getTheatre_status().toString(), theatre.getCoodinates());
    }

    @Override
    public List<RoomPreviewDTO> getRooms(int theatre_id) {
        List<Room> rooms = theatreDAO.getRooms(theatre_id);
        List<RoomPreviewDTO> roomPreviewDTOList = new ArrayList<>();
        rooms.forEach(room -> {
            roomPreviewDTOList.add(new RoomPreviewDTO(room.getId(), room.getRoom_name(), room.getRoom_type(), room.getCapacity()));
        });
        return roomPreviewDTOList;
    }
}
