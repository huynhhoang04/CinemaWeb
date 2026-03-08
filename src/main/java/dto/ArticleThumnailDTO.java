package main.java.dto;

public class ArticleThumnailDTO {
    private int article_id;
    private String title;
    private String summary;
    private String image_url;

    public ArticleThumnailDTO(int article_id, String title, String summary, String image_url) {
        this.article_id = article_id;
        this.title = title;
        this.summary = summary;
        this.image_url = image_url;
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

    public String getImage_url() {
        return image_url;
    }
}
