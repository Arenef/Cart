package cart.dto;

import java.io.Serializable;

public class Product implements Serializable {
    private int productCode;
    private String description;
    private double price;

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public Product() {
    }

    public Product(int productCode, String description, double price) {
        this.productCode = productCode;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

