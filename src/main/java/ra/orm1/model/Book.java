package ra.orm1.model;

public class Book {
    private long id;
    private String name;
    private String author_name;

    public Book() {
    }

    public Book(long id, String name, String author_name) {
        this.id = id;
        this.name = name;
        this.author_name = author_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
