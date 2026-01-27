/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0051;

import java.util.Scanner;

/**
 * Utility class for input validation
 */
public class Validation {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * Check if input string is a valid number
     * @param inputVal input string to check
     * @return Double value if valid, null otherwise
     */
    public static Double checkIn(String inputVal) {
        try {
            return Double.parseDouble(inputVal.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    /**
     * Check if operator is valid and return corresponding Operator enum
     * @param operator operator symbol as string
     * @return Operator enum if valid, null otherwise
     */
    public static Operator checkOperator(String operator) {
        if (operator == null || operator.trim().isEmpty()) {
            return null;
        }
        return Operator.fromSymbol(operator.trim());
    }
    
    /**
     * Input a valid double number
     * @param message prompt message
     * @return valid double number
     */
    public static double inputDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            Double number = checkIn(input);
            
            if (number == null) {
                System.err.println("Invalid input. Please enter a valid number.");
            } else {
                return number;
            }
        }
    }
    
    /**
     * Input a valid positive double number
     * @param message prompt message
     * @return valid positive double number
     */
    public static double inputPositiveDouble(String message) {
        while (true) {
            double number = inputDouble(message);
            if (number <= 0) {
                System.err.println("Number must be positive. Please try again.");
            } else {
                return number;
            }
        }
    }
    
    /**
     * Input a valid operator
     * @param message prompt message
     * @return valid Operator enum
     */
    public static Operator inputOperator(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            Operator operator = checkOperator(input);
            
            if (operator == null) {
                System.err.println("Invalid operator. Please enter one of: +, -, *, /, ^, =");
            } else {
                return operator;
            }
        }
    }
    
    /**
     * Input an integer within a range
     * @param message prompt message
     * @param min minimum value
     * @param max maximum value
     * @return valid integer within range
     */
    public static int inputInteger(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number < min || number > max) {
                    System.err.println("Please enter a number between " + min + " and " + max + ".");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}