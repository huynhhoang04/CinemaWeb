package main.java.dto;

public class TheatreDetailDTO {
    private int theatre_id;
    private String theatre_name;
    private String location;
    private String preview_url;
    private String info;
    private String theatre_status;
    private String coordinates;

    public TheatreDetailDTO(int theatre_id, String theatre_name, String location, String preview_url, String info, String theatre_status, String coordinates) {
        this.theatre_id = theatre_id;
        this.theatre_name = theatre_name;
        this.location = location;
        this.preview_url = preview_url;
        this.info = info;
        this.theatre_status = theatre_status;
        this.coordinates = coordinates;
    }

    public int getTheatre_id() {
        return theatre_id;
    }

    public String getTheatre_name() {
        return theatre_name;
    }

    public String getLocation() {
        return location;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public String getInfo() {
        return info;
    }

    public String getTheatre_status() {
        return theatre_status;
    }

    public String getCoordinates() {
        return coordinates;
    }
}
