package Entities;

import java.util.Objects;

public abstract class LibMaterial {

    private String id;
    private boolean isAvaliable;
    private String author;

    public LibMaterial() {
    }

    public LibMaterial(String id, boolean isAvaliable, String author) {
        this.id = id;
        this.isAvaliable = isAvaliable;
        this.author = author;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "LibMaterial{" +
                "id='" + id + '\'' +
                ", isAvaliable=" + isAvaliable +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibMaterial that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAvaliable, author);
    }
}
