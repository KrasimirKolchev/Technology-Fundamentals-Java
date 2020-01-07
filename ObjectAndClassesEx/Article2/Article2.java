package Q_ObjectAndClassesEx.Article2;

public class Article2 {
    private String title2;
    private String content2;
    private String author2;

    public Article2(String title2, String content2, String author2) {
        this.title2 = title2;
        this.content2 = content2;
        this.author2 = author2;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", this.getTitle2(), this.getContent2(), this.getAuthor2());
    }
}
