package main.java.dao.impl;

import main.java.dao.TheatreDAO;
import main.java.mapper.RoomMapper;
import main.java.mapper.TheatreMapper;
import main.java.model.entity.Room;
import main.java.model.entity.Theatre;
import main.java.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThreatreDAOImpl implements TheatreDAO {
    @Override
    public List<String> getAvailableCity() {
        String sql = "select * from get_active_cities();";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            List<String> citys = new ArrayList<>();
            while (rs.next()) {
                citys.add(rs.getString("city_name"));
            }
            return citys;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Theatre> getTheatresByCity(String city) {
        String sql = "select * from get_theatres_by_city(?);";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, city);
            ResultSet rs = ps.executeQuery();
            List<Theatre> theatres = new ArrayList<>();
            while (rs.next()) {
                theatres.add(TheatreMapper.map(rs));
            }
            return theatres;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Theatre getTheatresById(int theatre_id) {
        String sql = "select * from get_theatre_detail_by_id(?);";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            ps.setInt(1, theatre_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return TheatreMapper.map(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Room> getRooms(int theatre_id) {
        String sql = "select * from get_theatre_room(?);";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            ps.setInt(1, theatre_id);
            ResultSet rs = ps.executeQuery();
            List<Room> rooms = new ArrayList<>();
            while (rs.next()) {
                rooms.add(RoomMapper.map(rs));
            }
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
