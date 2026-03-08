package main.java.dto;

public class TheatreThumnailDTO {
    private int theatre_id;
    private String theatre_name;
    private String location;
    private String preview_url;

    public TheatreThumnailDTO(int theatre_id, String theatre_name, String location, String preview_url) {
        this.theatre_id = theatre_id;
        this.theatre_name = theatre_name;
        this.location = location;
        this.preview_url = preview_url;
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
}
