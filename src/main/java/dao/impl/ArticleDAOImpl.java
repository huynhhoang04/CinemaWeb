package main.java.dao.impl;

import main.java.dao.ArticleDAO;
import main.java.mapper.ArticleMapper;
import main.java.model.entity.Articles;
import main.java.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {
    @Override
    public List<Articles> getTop3Articles() {
        String sql = "select * from get_top_3_is_active_articles()";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Articles> articles = new ArrayList<>();
            while(rs.next()) {
                articles.add(ArticleMapper.map(rs));
            }
            return articles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Articles getArticleDetailById(int id) {
        String  sql = "select * from get_article_detail_by_id(?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return ArticleMapper.map(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
