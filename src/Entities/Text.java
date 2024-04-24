package Entities;

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
}
