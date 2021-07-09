package az.mycompany.TechnoMarket.model;

import java.time.LocalDateTime;

public  class BaseModel {
    private int id;
    private LocalDateTime dateTime;
    private boolean enabled;


    public BaseModel() {
    }

    public BaseModel(int id, LocalDateTime dateTime, boolean enabled) {
        this.id = id;
        this.dateTime = dateTime;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isStatus() {
        return enabled;
    }

    public void setStatus(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", enabled=" + enabled +
                '}';
    }
}
