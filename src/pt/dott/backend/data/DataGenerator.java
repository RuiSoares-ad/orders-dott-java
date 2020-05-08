package pt.dott.backend.data;

import pt.dott.backend.entity.Customer;
import pt.dott.backend.entity.Item;
import pt.dott.backend.entity.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    public List<Order> generateOrders(){
        List <Order> allOrders = new ArrayList<>();

        for(Customer customer : customerNames()){
            List<Item> itemsList = Items.generateRandomList();
            allOrders.add(new Order(customer.getCustomerName(), customer.getCustomerName() + "@dott.pt", getRandomAddress(), calculateOrderTotal(itemsList), getRandomDate(), Items.generateRandomList()));

        }

        return allOrders;
    }

    private BigDecimal calculateOrderTotal(List<Item> itemList){
        BigDecimal total = new BigDecimal("0.0");

        for(Item item : itemList){
            total.add(item.getCost());
            total.add(item.getShippingFee());
            total.add(item.getTaxAmount());
        }
        return total;
    }
    private String getRandomAddress(){
        return Address.districts.get(new Random().nextInt(Address.districts.size()-1));
    }

    private List<Customer> customerNames(){
        return CustomerName.getRandomNamesList();
    }

    private LocalDateTime getRandomDate(){
        LocalDate start = LocalDate.of(2018, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
        return LocalDateTime.of(randomDate, LocalTime.now());
    }
}
