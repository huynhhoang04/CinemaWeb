package main.java.service;

import main.java.dto.ArticleDetailDTO;
import main.java.dto.ArticleThumnailDTO;

import java.util.List;

public interface ArticleSevrvices {
    List<ArticleThumnailDTO> getTop3Articles();
    ArticleDetailDTO getArticleById(int id);
}
