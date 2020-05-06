package pt.dott.backend.entity;

import java.math.BigDecimal;

public class Item {

    private BigDecimal cost;
    private BigDecimal shippingFee;
    private BigDecimal taxAmount;
    private Product product;

    public Item(BigDecimal cost, BigDecimal shippingFee, BigDecimal taxAmount, Product product) {
        this.cost = cost;
        this.shippingFee = shippingFee;
        this.taxAmount = taxAmount;
        this.product = product;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
