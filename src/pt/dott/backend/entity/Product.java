package pt.dott.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Product {

    private String name;
    private String category;
    private Double weight;
    private BigDecimal price;
    private LocalDateTime creationDate;

    public Product(String name, String category, Double weight, BigDecimal price, LocalDateTime creationDate) {
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
