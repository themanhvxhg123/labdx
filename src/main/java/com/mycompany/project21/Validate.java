/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project21;

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
     

    static String checkCourseInput(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty!");
                }
                if (!input.equalsIgnoreCase("Java")
                        && !input.equalsIgnoreCase(".Net")
                        && !input.equalsIgnoreCase("C/C++")) {
                    throw new IllegalArgumentException("Course must be Java, .Net or C/C++!");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

    }
}
