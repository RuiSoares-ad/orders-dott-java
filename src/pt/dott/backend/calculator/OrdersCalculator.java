package pt.dott.backend.calculator;


import pt.dott.backend.entity.Order;
import pt.dott.backend.repository.OrdersRepository;

import java.time.LocalDateTime;
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
        calculateOrdersByInterval(periodOrders, lowerValue, higherValue);
        /*System.out.println(Thread.currentThread() + " " + );*/
    }

    private Integer calculateOrdersByInterval(List <Order> periodOrders, String lowerValue, String higherValue){


        if(validateMonths(lowerValue, higherValue)){
            resultCount = getCountProductAgeGroupByOrders(periodOrders, startMonthAge, endMonthAge);
        } else if(validateMonthComparator(lowerValue, higherValue)) {
            resultCount = getCountProductAgeComparatorByOrders(periodOrders, lowerValue, endMonthAge);
        }

        return resultCount;
    }

    private Integer getCountProductAgeComparatorByOrders(List <Order> periodOrders, String comparator, Integer endMonthAge){
        return repository.getProductsOlderNewerThan(periodOrders, comparator, endMonthAge).size();
    }
    private Integer getCountProductAgeGroupByOrders(List <Order> periodOrders, Integer startMonthAge, Integer endMonthAge){
        return repository.getProductsByAgeInterval(periodOrders, startMonthAge, endMonthAge).size();
    }

    private void calculateOrdersByOperator(String operatorInterval){
        String [] months = operatorInterval.split(String.valueOf(operatorInterval.charAt(0)));

    }

    private boolean validateMonthComparator(String comparator, String referenceMonth){
        if(comparator.equals("<") || comparator.equals(">")){
            try{
                endMonthAge = Integer.parseInt(referenceMonth);
            }catch(NumberFormatException ex){
                System.out.println("Insert a valid number");
                return false;
            }
            return true;
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

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public String getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue(String lowerValue) {
        this.lowerValue = lowerValue;
    }

    public String getHigherValue() {
        return higherValue;
    }

    public void setHigherValue(String higherValue) {
        this.higherValue = higherValue;
    }

    public Integer getStartMonthAge() {
        return startMonthAge;
    }

    public void setStartMonthAge(Integer startMonthAge) {
        this.startMonthAge = startMonthAge;
    }

    public Integer getEndMonthAge() {
        return endMonthAge;
    }

    public void setEndMonthAge(Integer endMonthAge) {
        this.endMonthAge = endMonthAge;
    }

    public OrdersRepository getRepository() {
        return repository;
    }

    public void setRepository(OrdersRepository repository) {
        this.repository = repository;
    }
}
