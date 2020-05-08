package pt.dott.backend.validator;

import java.util.List;

public class ValidationUtils {

    public static void printInvalidDateParametersMessages(){
        System.out.println("You must provide at least 2 parameters setting an interval between two dates.");
        System.out.println("Dates should be provided on the following date format: YYYY-MM-DD HH:MM:SS");
    }

    public static void printInvalidIntervalParameters(List<String> invalidArgs){
        if(invalidArgs.size()>0){
            System.out.println("\nInterval parameter(s) incorrect: "); invalidArgs.forEach(arg -> System.out.println(arg +" "));
            System.out.println("\nYou must provide a valid interval which includes: ");
            System.out.println("- x-y for interval between months, being x the smaller integer");
            System.out.println("- >x for interval older than x");
            System.out.println("- <x for interval newer than x\n");
        }

    }
}
