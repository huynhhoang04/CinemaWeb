package main.java.dto;


import java.time.LocalDate;

public class ArticleDetailDTO {
    private int article_id;
    private String title;
    private String content;
    private String image_url;
    private LocalDate created_at;

    public ArticleDetailDTO(int article_id, String title, String content, String image_url, LocalDate created_at) {
        this.article_id = article_id;
        this.title = title;
        this.content = content;
        this.image_url = image_url;
        this.created_at = created_at;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage_url() {
        return image_url;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }
}
