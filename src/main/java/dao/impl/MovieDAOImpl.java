package main.java.dao.impl;

import main.java.dao.MovieDAO;
import main.java.mapper.MovieMapper;
import main.java.model.entity.Movie;
import main.java.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {
    @Override
    public List<Movie> getTop7NewestMovies() {
        String sql = "select * from get_top_7_movies()";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();) {
            List<Movie> movies = new ArrayList<>();
            while (rs.next()) {
                movies.add(MovieMapper.map(rs));
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Movie getMovieById(int id) {
        String sql = "select * from get_movie_detail_by_id(?)";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return MovieMapper.map(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Movie> getMovieByStatusAndPage(String status, int page, int size, String keyword, String tag) {
        String sql = "select * from get_movie_by_status_and_paging(?, ?, ?, ?, ?)";
        try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, status);
            ps.setInt(2, size);
            ps.setInt(3, page);
            ps.setString(4, keyword);
            ps.setString(5, tag);
            ResultSet rs = ps.executeQuery();
            List<Movie> movies = new ArrayList<>();
            while (rs.next()) {
                movies.add(MovieMapper.map(rs));
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countMovieByStatus(String status, String keyword, String tag) {
        String sql = "select * from count_movie_by_status(?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, status);
            ps.setString(2, keyword);
            ps.setString(3, tag);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
