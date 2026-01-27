/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0051;

/**
 * Calculator class handling mathematical operations and BMI calculation
 */
public class Calculator {
    
    /**
     * Perform calculation based on operator
     * @param a first operand
     * @param operator mathematical operator
     * @param b second operand
     * @return calculation result
     * @throws ArithmeticException if division by zero
     */
    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            case EXPONENTIATION:
                return Math.pow(a, b);
            default:
                return a;
        }
    }
    
    /**
     * Calculate BMI and return status
     * @param weight weight in kg
     * @param height height in cm
     * @return BMIStatus enum
     */
    public BMIStatus calculateBMI(double weight, double height) {
        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        return BMIStatus.fromBMI(bmi);
    }
    
    /**
     * Calculate BMI value
     * @param weight weight in kg
     * @param height height in cm
     * @return BMI value
     */
    public double calculateBMIValue(double weight, double height) {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }
}