package Entities;

import java.util.Objects;

public class Video extends LibMaterial{
    private Integer duration;

    public Video() {
    }

    public Video(String id, boolean isAvaliable, String author, Integer duration) {
        super(id, isAvaliable, author);
        duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Video video)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(duration, video.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration);
    }

    @Override
    public String toString() {
        return "=======================================================================================\n" +
                "Video --> "+
                " | id => '" + getId() + "'" +
                " | isAvaliable => " + isAvaliable() +
                " | author => '" + getAuthor() + "'" +
                " | duration => " + duration + " Minutes |\n" +
                "======================================================================================";
    }

}


