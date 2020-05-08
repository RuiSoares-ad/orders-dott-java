package pt.dott.backend.repository;


import pt.dott.backend.data.DataGenerator;
import pt.dott.backend.entity.Order;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersRepository {

    List <Order> orders;
    List <Order> ordersBetween;
    DataGenerator dataGenerator;

    public OrdersRepository(LocalDateTime startDate, LocalDateTime endDate){
        dataGenerator = new DataGenerator();
        this.orders = dataGenerator.generateOrders();
        System.out.println("Total Orders : " + orders.size());
        this.ordersBetween = getAllOrdersBetween(orders, startDate, endDate);
        System.out.println("Orders from " + startDate.toString() + " to " + endDate.toString() + " : " + ordersBetween.size());
    }

    private List<Order> getAllOrdersBetween(List <Order> allOrders, LocalDateTime startDate, LocalDateTime endDate){
        return allOrders.stream().filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate)).collect(Collectors.toList());
    }

    public synchronized List <Order> getProductsByAgeInterval(List <Order> filteredOrders, Integer intervalStart, Integer intervalEnd){
        LocalDateTime intervalStartDate = LocalDateTime.now().minusMonths(intervalStart);
        LocalDateTime intervalEndDate = LocalDateTime.now().minusMonths(intervalEnd);

        filteredOrders = filteredOrders.stream().filter(order -> order.getItemList().stream().anyMatch(item ->
                item.getProduct().getCreationDate().isBefore(intervalStartDate) && item.getProduct().getCreationDate().isAfter(intervalEndDate))).collect(Collectors.toList());

        return filteredOrders;
    }

    public synchronized List <Order> getProductsOlderNewerThan(List <Order> filteredOrders, String operator, Integer startingPoint){
        LocalDateTime refDate = LocalDateTime.now().minusMonths(startingPoint);

        if(operator.equals(">")){
            filteredOrders = filteredOrders.stream().filter(order -> order.getItemList().stream().anyMatch(item ->
                    item.getProduct().getCreationDate().isBefore(refDate))).collect(Collectors.toList());
        }
        else if(operator.equals("<")){
            filteredOrders = filteredOrders.stream().filter(order -> order.getItemList().stream().anyMatch(item ->
                    item.getProduct().getCreationDate().isAfter(refDate))).collect(Collectors.toList());
        }

        return filteredOrders;
    }

    public synchronized List<Order> getOrdersBetween() {
        return ordersBetween;
    }

}
