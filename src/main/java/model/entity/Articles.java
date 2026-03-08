package main.java.model.entity;


import java.time.LocalDate;

public class Articles {
    private int article_id;
    private String title;
    private String summary;
    private String content;
    private String image_url;
    private LocalDate created_at;
    private boolean is_active;

    public Articles() {
    }

    public Articles(int article_id, String title, String summary, String content,
                      String image_url, LocalDate created_at, boolean is_active) {
        this.article_id = article_id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.image_url = image_url;
        this.created_at = created_at;
        this.is_active = is_active;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
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

    public boolean isIs_active() {
        return is_active;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
