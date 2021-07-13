package az.mycompany.TechnoMarket.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product extends  BaseModel{
    private String name;
    private String color;
    private String photo;
    private String type;
    private BigDecimal price;
    private int countProduct;
    private Model model;

    public Product() {
    }

    public Product(int id, LocalDateTime dateTime, boolean enabled, String name, String color, String photo, String type, BigDecimal price, int countProduct, Model model) {
        super(id, dateTime, enabled);
        this.name = name;
        this.color = color;
        this.photo = photo;
        this.type = type;
        this.price = price;
        this.countProduct = countProduct;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
