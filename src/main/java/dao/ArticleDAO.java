package main.java.dao;

import main.java.model.entity.Articles;

import java.util.List;

public interface ArticleDAO {
    List<Articles> getTop3Articles();
    Articles getArticleDetailById(int id);
}
