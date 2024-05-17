package Entities;

import java.util.Objects;

public class Audio extends LibMaterial{
    private Integer duration;

    public Audio() {
    }

    public Audio(String id, boolean isAvailable, String author, Integer duration) {
        super(id, isAvailable, author);
        this.duration = duration;
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
        if (!(o instanceof Audio audio)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(duration, audio.duration);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration);
    }

    @Override
    public String toString() {
        return "=======================================================================================\n" +
                "Audio --> "+
                " | id => '" + getId() + "'" +
                " | author => '" + getAuthor() + "'" +
                " | duration => " + duration + "Minutes |\n" +
                "=======================================================================================";
    }
}
