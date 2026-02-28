/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.project21;

/**
 *
 * @author Nguyen Manh
 */
public class Project21 {

    public static void main(String[] args) {
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int menu = Validate.checkNumberFormat("Enter a number: ");
            switch (menu) {
                case 1:
                    StudentManagement.createStudent();
                    break;
                case 2:
                    StudentManagement.findAndSortStudent();
                    break;
                case 3:
                    StudentManagement.updateAndDeleteStudent();
                    break;
                case 4:
                    StudentManagement.report();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Enter number from 1 to 5: ");
                  
            }
        }

    }
}
