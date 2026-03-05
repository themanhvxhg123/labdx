/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.l.p0022;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Nguyen Manh
 */
public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    static String checkStringInputNull(String msg) {
        while (true) {
            System.out.println(msg);
            try {
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("please enter again ");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.err.println(msg);
            }
        }
    }

    static int checkNumberFormat(String msg) {
        while (true) {
            System.err.print(msg);
            try {
                String number = sc.nextLine().trim();
                if (number.isEmpty()) {
                    throw new IllegalArgumentException("please enter again");
                }
                return Integer.parseInt(number);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid input: " + e.getMessage());
            }

        }
    }

    public static boolean checkInputYN(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            }
            if (input.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y or N.");
        }
    }

    public static int checkBirthDate(String msg) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            System.out.println(msg);
            try {
                String input = sc.nextLine().trim();
                if (input.length() != 4) {
                    throw new IllegalArgumentException("Birth year must be exactly 4 digits");
                }
                int year = Integer.parseInt(input);
                if (year < 1900 || year > currentYear) {
                    throw new IllegalArgumentException("Birth year must be between 1900" + currentYear);
                }
                return year;
            } catch (NumberFormatException e) {
                System.err.println("Error: birth year must be a number");
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    public static String checkPhone(String msg){
        while(true){
            System.out.println(msg);
            try{
                String input = sc.nextLine().trim();
                if(input.isEmpty()){
                    throw new IllegalArgumentException("Phone cannot be empty");
                }
                if(!input.matches("\\d+")){
                    throw new IllegalArgumentException("Phone must be contain digits only");
                }
                if(input.length() < 10){
                    throw new IllegalArgumentException("Phone must have at least 10 digits");
                }
                return input;
            }catch(IllegalArgumentException e){
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    public static String checkEmail(String msg){
        while(true){
            System.out.println(msg);
            try{
                String input = sc.nextLine().trim();
                if(input.isEmpty()){
                    throw new IllegalArgumentException("Email cannot be empty");
                }
                if(!input.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")){
                    throw new IllegalArgumentException("Invalid email format. Example: user@domain.com");
                }    
                return input;
                        
                }catch(IllegalArgumentException e){
                        System.err.println("Error: " + e.getMessage());
                        }
            }
        }
    public static int checkExpInYear(String msg){
        while(true){
            System.out.println(msg);
            try{
                String input = sc.nextLine().trim();
                int value = Integer.parseInt(input);
                if(value < 0 || value > 100){
                    throw new IllegalArgumentException("Year of experience must be between 0 and 100");
                }
                return value;
            }catch(NumberFormatException e){
                System.err.println("Error: please enter a valid integer");
            }catch(IllegalArgumentException e){
                System.err.println("Error:" + e.getMessage());
            }
        }
    }
    public static String checkGraduationRank(String msg){
        while(true){
            System.out.println(msg);
            try{
                String input = sc.nextLine().trim();
                if(input.equalsIgnoreCase("Excellence")
                    || input.equalsIgnoreCase("Good")
                    || input.equalsIgnoreCase("Fair")
                    || input.equalsIgnoreCase("Poor")){
                    return input;
                }
                throw new IllegalArgumentException("Rank must be one of: Excellence, Good, Fair, Poor ");
            }catch(IllegalArgumentException e){
                System.err.println("Error: " + e.getMessage());
            }
           
        }
    }
    public static int checkCandidateType(String msg){
        while(true){
            int type = checkNumberFormat(msg);
            if(type >= 0 && type <=2){
                return type;
            }
            System.err.println("Error: type must be 0 (Excellence), 1 (Fresher) or 2 (Intern)");
        }
    }
    static int checkPositiveInt(String msg) {
        while (true) {
            int v = checkNumberFormat(msg);
            if (v > 0) {
                return v;
            }
            System.err.println("Error: Value must be greater than 0.");
        }
    }
}
    
   

