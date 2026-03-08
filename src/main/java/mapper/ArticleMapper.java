package main.java.mapper;

import main.java.model.entity.Articles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ArticleMapper {
    public static Articles map(ResultSet rs) throws SQLException {
        int article_id =  rs.getInt("article_id");
        String title  = rs.getString("title");
        String summary  = rs.getString("summary");
        String content  = rs.getString("content");
        String image_url= rs.getString("image_url");
        LocalDate created_at  = rs.getDate("created_at").toLocalDate();
        boolean is_active =  rs.getBoolean("is_active");
        return new Articles(article_id,title,summary,content,image_url,created_at,is_active);
    }
}
