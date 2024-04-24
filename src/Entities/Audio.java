package Entities;

public class Audio extends LibMaterial{
    private Float duration;

    public Audio() {
    }

    public Audio(String id, boolean isAvailable, String author, Float duration) {
        super(id, isAvailable, author);
        this.duration = duration;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }
}
