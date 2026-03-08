package main.java.mapper;

import main.java.model.entity.Theatre;
import main.java.model.enums.TheatreStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TheatreMapper {
    public static Theatre map(ResultSet rs) throws SQLException {
        int theatre_id =  rs.getInt("theatre_id");
        String theatre_name =   rs.getString("theatre_name");
        String location =    rs.getString("location");
        String preview_url =  rs.getString("preview_url");
        String info = rs.getString("info");
        TheatreStatus theatre_status = TheatreStatus.valueOf(rs.getString("theatre_status"));
        String city = rs.getString("city");
        String coodinates = rs.getString("coordinates");
        return new Theatre(theatre_id, theatre_name, location, preview_url, info, theatre_status, city, coodinates);
    }
}
