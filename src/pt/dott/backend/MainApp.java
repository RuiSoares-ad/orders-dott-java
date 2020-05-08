package pt.dott.backend;

import pt.dott.backend.calculator.OrdersCalculator;
import pt.dott.backend.repository.OrdersRepository;
import pt.dott.backend.validator.ValidationUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {



    private static LocalDateTime startDate;
    private static LocalDateTime endDate;


    public static void main(String[] args) {

        if(lessParameters(args) || !validateDates(args)){
            ValidationUtils.printInvalidDateParametersMessages();
            return;
        }

        OrdersRepository repository = new OrdersRepository(startDate, endDate);
        calculateOrders(repository, args);

    }

    private static void calculateOrders(OrdersRepository repository, String [] args){
        CustomIntervals customIntervals = new CustomIntervals(args);
        System.out.println("RESULT DEFAULT INTERVALS: \n");
        calculateOrdersDefaultInterval(repository);
        if(customIntervals.getIntervalsList().size()>0){
            System.out.println("\nRESULT CUSTOM INTERVALS: \n");
            calculateOrdersCustomIntervals(repository, customIntervals.getIntervalsList());
        }
    }

    private static void calculateOrdersCustomIntervals(OrdersRepository repository, List<String[]> intervals){
        List<OrdersCalculator> calculatorList = new ArrayList<>();

        for(int i = 0; i != intervals.size(); i++){
            calculatorList.add(new OrdersCalculator(intervals.get(i)[0], intervals.get(i)[1], repository));
        }

        runThreads(calculatorList);
    }

    private static void calculateOrdersDefaultInterval(OrdersRepository repository){
        List<OrdersCalculator> calculatorList = new ArrayList<>();

        calculatorList.add(new OrdersCalculator("1", "3", repository));
        calculatorList.add(new OrdersCalculator("4", "6", repository));
        calculatorList.add(new OrdersCalculator("7", "12", repository));
        calculatorList.add(new OrdersCalculator(">", "12", repository));

        runThreads(calculatorList);

    }

    private static void runThreads(List<OrdersCalculator> calculatorList){
        for(OrdersCalculator calc : calculatorList){
            calc.start();
        }
        for(OrdersCalculator calc : calculatorList){
            try {
                calc.join();
            } catch (InterruptedException e) {
                System.out.println(calc.getName() + " has been interrupted!");
                e.printStackTrace();
            }
        }

        for(OrdersCalculator calc : calculatorList){

            System.out.println(calc.getLowerValue() + (checkIntegerValue(calc.getLowerValue()) ? "-" : "") + calc.getHigherValue()+ " months : " + calc.getResultCount() +  " orders");
        }
    }

    private static boolean checkIntegerValue(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private static boolean lessParameters(String [] args){
        return args.length<2;
    }

    private static boolean validateDates(String [] args){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            startDate = LocalDateTime.parse(args[0], formatter);
            endDate = LocalDateTime.parse(args[1], formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }





}
