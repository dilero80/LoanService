package Entities;

import java.util.Objects;

public class Text extends LibMaterial{
    private Integer numPages;


    public Text() {
    }

    public Text(String id, boolean isAvaliable, String author, Integer numPages) {
        super(id, isAvaliable, author);
        this.numPages = numPages;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "=======================================================================================\n" +
                "Text --> |"+
                "id => '" + getId() + "'" +
                ", | isAvaliable => " + isAvaliable() +
                ", | author => '" + getAuthor() + "'" +
                ", | Pages => " + numPages + "\n" +
                "=======================================================================================";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text text)) return false;
        return Objects.equals(numPages, text.numPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numPages);
    }
}
