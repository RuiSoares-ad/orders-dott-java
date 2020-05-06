package pt.dott.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomIntervals {

    private List<String[]> intervalsList;

    public CustomIntervals(String [] args){
        intervalsList = new ArrayList<>();
        validateArgs(args);
    }

    private void validateArgs(String [] args){
        for(int i = 2; i != args.length; i++){
            if(args[i].contains("-")){
                String [] interval = args[i].split("-");
                if(validIntervalLength(null, interval)){
                    if(validateInterval(interval)){
                        intervalsList.add(interval);
                    }
                }

            }
            String comparator;
            if(args[i].contains(">") || args[i].contains("<")){
                comparator = String.valueOf(args[i].charAt(0));
                String [] interval = args[i].split(comparator);
                if(validIntervalLength(comparator,interval)){
                    if(validIntervalComparator(interval)){
                        interval[0] = comparator;
                        intervalsList.add(interval);
                    }
                }
            }
        }
    }

    private boolean validateInterval(String [] interval){
        for(int i = 0; i != interval.length; i++){
            try{
                Integer.parseInt(interval[i]);
            } catch(NumberFormatException e){
                System.out.println("Insert a valid number");
                return false;
            }

        }
        return true;
    }

    private boolean validIntervalComparator(String [] interval){
            try{
                Integer.parseInt(interval[1]);
            } catch(NumberFormatException e){
                System.out.println("Insert a valid number");
                return false;
            }
            return true;

    }

    private boolean validIntervalLength(String comparator,String [] interval ){
           return interval.length==2;


    }

    public List<String[]> getIntervalsList() {
        return intervalsList;
    }

    public void setIntervalsList(List<String[]> intervalsList) {
        this.intervalsList = intervalsList;
    }
}
