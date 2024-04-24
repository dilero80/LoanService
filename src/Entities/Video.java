package Entities;

public class Video extends LibMaterial{
    private Float Duration;

    public Video() {
    }

    public Video(String id, boolean isAvaliable, String author, Float duration) {
        super(id, isAvaliable, author);
        Duration = duration;
    }

    public Float getDuration() {
        return Duration;
    }

    public void setDuration(Float duration) {
        Duration = duration;
    }
}


