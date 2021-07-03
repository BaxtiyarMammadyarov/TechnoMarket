package az.mycompany.TechnoMarket.model;

import java.time.LocalDateTime;

public class Brand extends BaseModel{
    private String name;


    public Brand() {

    }

    public Brand(int id, LocalDateTime dateTime, boolean status, String name) {
        super(id, dateTime, status);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
