package pt.dott.backend;

import pt.dott.backend.validator.ValidationUtils;

import java.util.ArrayList;
import java.util.List;


public class CustomIntervals {

    private List<String[]> intervalsList;

    public CustomIntervals(String [] args){
        intervalsList = new ArrayList<>();
        validateArgs(args);
    }

    private void validateArgs(String [] args){
        List <String> invalid = new ArrayList<>();
        for(int i = 2; i != args.length; i++){
            if(args[i].contains("-")){
                String [] interval = args[i].split("-");
                if (validate(interval)) intervalsList.add(interval);
                else invalid.add(args[i]);
            }
            else if(args[i].contains(">") || args[i].contains("<")){
                String comparator = String.valueOf(args[i].charAt(0));
                String [] interval = args[i].split(comparator);
                if (validate(interval)){ interval[0] = comparator; intervalsList.add(interval);}
                else{ invalid.add(args[i]);}
            } else {
                invalid.add(args[i]);
            }
        }
        ValidationUtils.printInvalidIntervalParameters(invalid);
    }

    private boolean validate(String []interval){
        return validIntervalLength(interval) && (validateInterval(interval) || validIntervalComparator(interval));
    }

    private boolean validateInterval(String [] interval){
        for(int i = 0; i != interval.length; i++){
            try{
                Integer.parseInt(interval[i]);
            } catch(NumberFormatException e){
                return false;
            }
        }
        return true;
    }

    private boolean validIntervalComparator(String [] interval){
            try{
                Integer.parseInt(interval[1]);
                return true;
            } catch(NumberFormatException e){
                return false;
            }

    }

    private boolean validIntervalLength(String [] interval ){
           return interval.length==2;
    }

    public List<String[]> getIntervalsList() {
        return intervalsList;
    }

}
