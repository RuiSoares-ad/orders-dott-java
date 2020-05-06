package pt.dott.backend.repository;


import pt.dott.backend.data.DataGenerator;
import pt.dott.backend.entity.Item;
import pt.dott.backend.entity.Order;
import pt.dott.backend.entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersRepository {

    List <Order> orders;
    List <Item> items;
    List <Product> products;
    List <Order> ordersBetween;
    DataGenerator dataGenerator;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public OrdersRepository(LocalDateTime startDate, LocalDateTime endDate){
        dataGenerator = new DataGenerator();
        this.orders = dataGenerator.generateOrders();
        this.ordersBetween = getAllOrdersBetween(orders, startDate, endDate);
    }

    private List<Order> getAllOrdersBetween(List <Order> allOrders, LocalDateTime startDate, LocalDateTime endDate){
        List <Order> filteredOrders = new ArrayList<>();

        for(Order order : allOrders){
            if(order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate)){
                filteredOrders.add(order);
            }
        }

        return filteredOrders;
    }

    public synchronized List <Product> getProductsByAgeInterval(List <Order> filteredOrders, Integer intervalStart, Integer intervalEnd){
        List <Product> filteredProducts = new ArrayList<>();
        LocalDateTime intervalStartDate = LocalDateTime.now().minusMonths(intervalStart);
        LocalDateTime intervalEndDate = LocalDateTime.now().minusMonths(intervalEnd);

        for(Order order : filteredOrders ){
            for(Item item : order.getItemList()){
                if(item.getProduct().getCreationDate().isBefore(intervalStartDate) && item.getProduct().getCreationDate().isAfter(intervalEndDate)){
                    filteredProducts.add(item.getProduct());
                }
            }

        }
        return filteredProducts;
    }

    public synchronized List <Product> getProductsOlderNewerThan(List <Order> filteredOrders, String operator, Integer startingPoint){
        List <Product> filteredProducts = new ArrayList<>();
        LocalDateTime refDate = LocalDateTime.now().minusMonths(startingPoint);

        for(Order order : filteredOrders ){
            for(Item item : order.getItemList()){
                if(operator.equals(">")){
                    if(item.getProduct().getCreationDate().isBefore(refDate)){
                        filteredProducts.add(item.getProduct());
                    }
                } else if(operator.equals("<")){
                    if(item.getProduct().getCreationDate().isAfter(refDate)){
                        filteredProducts.add(item.getProduct());
                    }
                }

            }

        }
        return filteredProducts;
    }

    public synchronized List<Order> getOrdersBetween() {
        return ordersBetween;
    }

    public void setOrdersBetween(List<Order> ordersBetween) {
        this.ordersBetween = ordersBetween;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
