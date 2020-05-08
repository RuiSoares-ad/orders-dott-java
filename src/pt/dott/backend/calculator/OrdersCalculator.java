package pt.dott.backend.calculator;


import pt.dott.backend.entity.Order;
import pt.dott.backend.repository.OrdersRepository;
import java.util.List;


public class OrdersCalculator extends Thread {

    private Integer startMonthAge;
    private Integer endMonthAge;
    private String lowerValue;
    private String higherValue;
    private OrdersRepository repository;
    private Integer resultCount;

    public OrdersCalculator( String lowerValue, String higherValue, OrdersRepository repository){
        this.lowerValue = lowerValue;
        this.higherValue = higherValue;
        this.repository = repository;

    }

    @Override
    public void run() {
        List<Order> periodOrders = repository.getOrdersBetween();
        resultCount = calculateOrdersByInterval(periodOrders, lowerValue, higherValue);
    }

    private Integer calculateOrdersByInterval(List <Order> periodOrders, String lowerValue, String higherValue){

        if(validateMonths(lowerValue, higherValue)){
            return getCountProductAgeGroupByOrders(periodOrders, startMonthAge, endMonthAge);
        } else if(validateMonthComparator(lowerValue, higherValue)) {
            return getCountProductAgeComparatorByOrders(periodOrders, lowerValue, endMonthAge);
        }

        return resultCount;
    }

    private Integer getCountProductAgeComparatorByOrders(List <Order> periodOrders, String comparator, Integer endMonthAge){
        return repository.getProductsOlderNewerThan(periodOrders, comparator, endMonthAge).size();
    }
    private Integer getCountProductAgeGroupByOrders(List <Order> periodOrders, Integer startMonthAge, Integer endMonthAge){
        return repository.getProductsByAgeInterval(periodOrders, startMonthAge, endMonthAge).size();
    }

    private boolean validateMonthComparator(String comparator, String referenceMonth){
        if(comparator.equals("<") || comparator.equals(">")){
            try{
                endMonthAge = Integer.parseInt(referenceMonth);
                return true;
            }catch(NumberFormatException ex){
                return false;
            }
        }
        return false;
    }

    private boolean validateMonths(String startMonth, String endMonth){
        try{
            startMonthAge = Integer.parseInt(startMonth);
            endMonthAge = Integer.parseInt(endMonth);
        } catch(NumberFormatException p){
            return false;
        }
        return true;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public String getLowerValue() {
        return lowerValue;
    }

    public String getHigherValue() {
        return higherValue;
    }


}
