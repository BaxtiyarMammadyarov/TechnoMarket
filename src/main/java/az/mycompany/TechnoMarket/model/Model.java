package az.mycompany.TechnoMarket.model;

import java.time.LocalDateTime;

public class Model extends  BaseModel{
    private  String name;
    private Brand brand;


    public Model(String name,Brand brand) {
        this.name = name;
        this.brand = brand;
    }

    public Model(int id, LocalDateTime dateTime, boolean status, String name, Brand brand) {
        super(id, dateTime, status);
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }


}
