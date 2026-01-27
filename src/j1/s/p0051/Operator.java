/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0051;

/**
 *
 * @author Nguyen Manh
 */

/**
 * Enum representing mathematical operators
 */
public enum Operator {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    EXPONENTIATION("^"),
    EQUALS("=");
    
    private final String symbol;
    
    Operator(String symbol) {
        this.symbol = symbol;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    /**
     * Get Operator enum from string symbol
     * @param symbol operator symbol
     * @return Operator enum or null if invalid
     */
    public static Operator fromSymbol(String symbol) {
        for (Operator op : Operator.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        return null;
    }
}