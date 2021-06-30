package az.mycompany.TecnhoMarket.model;

import java.time.LocalDateTime;

public  class BaseModel {
    private Long id;
    private LocalDateTime dateTime;
    private boolean status;

    public BaseModel() {
    }

    public BaseModel(Long id, LocalDateTime dateTime, boolean status) {
        this.id = id;
        this.dateTime = dateTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", status=" + status +
                '}';
    }
}
