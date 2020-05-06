package pt.dott.backend.entity;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String customerName;
    private String customerContact;
    private String shippingAddress;
    private BigDecimal total;
    private LocalDateTime orderDate;
    private List<Item> itemList;

    public Order(String customerName, String customerContact, String shippingAddress, BigDecimal total, LocalDateTime orderDate, List<Item> itemList) {
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.shippingAddress = shippingAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
