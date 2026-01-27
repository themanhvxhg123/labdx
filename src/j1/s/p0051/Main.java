/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.s.p0051;

/**
 *
 * @author Nguyen Manh
 */
/**
 * Main class handling user interface and program flow
 */
public class Main {
    
    private static final Calculator calculator = new Calculator();
    
    /**
     * Display main menu
     */
    private static void displayMenu() {
        System.out.println("\n========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.println("======================================");
    }
    
    /**
     * Handle normal calculator function
     */
    private static void normalCalculator() {
        System.out.println("\n----- Normal Calculator -----");
        
        double memory = Validation.inputDouble("Enter number: ");
        
        while (true) {
            Operator operator = Validation.inputOperator("Enter operator (+, -, *, /, ^, =): ");
            
            if (operator == Operator.EQUALS) {
                System.out.println("Result: " + memory);
                break;
            }
            
            double number = Validation.inputDouble("Enter number: ");
            
            try {
                memory = calculator.calculate(memory, operator, number);
                System.out.println("Memory: " + memory);
            } catch (ArithmeticException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println("Calculation aborted. Memory reset to last valid value.");
                break;
            }
        }
    }
    
    /**
     * Handle BMI calculator function
     */
    private static void bmiCalculator() {
        System.out.println("\n----- BMI Calculator -----");
        
        double weight = Validation.inputPositiveDouble("Enter weight (kg): ");
        double height = Validation.inputPositiveDouble("Enter height (cm): ");
        
        double bmiValue = calculator.calculateBMIValue(weight, height);
        BMIStatus status = calculator.calculateBMI(weight, height);
        
        System.out.printf("\nYour BMI: %.2f\n", bmiValue);
        System.out.println("Status: " + status.getDescription());
    }
    
    /**
     * Main program execution
     * @param args command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = Validation.inputInteger("Enter your choice: ", 1, 3);
            
            switch (choice) {
                case 1:
                    normalCalculator();
                    break;
                case 2:
                    bmiCalculator();
                    break;
                case 3:
                    System.out.println("\nThank you for using the calculator. Goodbye!");
                    return;
                default:
                    System.err.println("Invalid choice. Please try again.");
            }
        }
    }
}
