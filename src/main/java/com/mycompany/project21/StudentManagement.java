/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Nguyen Manh
 */
public class StudentManagement {

    private static final List<Student> studentList = new ArrayList<>();

    static void createStudent() {

        while (true) {

            String id = Validate.checkStringInputNull("Enter id: ");
            boolean duplicate = false;
            for (Student s : studentList) {
                if (s.getId().equalsIgnoreCase(id)) {
                    System.err.println("ID already exists! Please try again.");
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                continue;
            }
            String name = Validate.checkStringInputNull("Enter name: ");
            String semester = Validate.checkStringInputNull("Enter semester: ");
            String course = Validate.checkCourseInput("Enter course: ");

            studentList.add(new Student(id, name, semester, course));

            if (studentList.size() > 1) {
                if (!Validate.checkInputYN("Do you want to continue (Y/N)? ")) {
                    break;
                }
            }
        }

    }

    static void findAndSortStudent() {
        System.out.println("Find and Sort Student");
        String keyword = Validate.checkStringInputNull("Enter Name: ");

        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }

        }
        if (result.isEmpty()) {
            System.out.println("Student not found");
            return;
        }
        Collections.sort(studentList);
        System.out.println("\n--- SEARCH RESULTS (sorted by name) ---");
        System.out.println("+----------------------+----------+----------------------+");
        System.out.printf("| %-20s | %-8s | %-20s |%n", "Student Name", "Semester", "Course Name");
        System.out.println("+----------------------+----------+----------------------+");
        for (Student s : result) {
            System.out.printf("| %-20s | %-8s | %-20s |%n",
                    s.getName(), s.getSemester(), s.getCourse());
        }
        System.out.println("+----------------------+----------+----------------------+");
    }

    static void updateAndDeleteStudent() {
        String keyword = Validate.checkStringInputNull("Enter ID: ");

        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getId().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
                Collections.sort(studentList);
                System.out.printf("Here the information: | %-20s | %-8s | %-20s |%n",
                        s.getName(), s.getSemester(), s.getCourse());

                String choice = Validate.checkStringInputNull("Do you want to update or delete?");
                if (choice.equalsIgnoreCase("U")) {
                    String newname = Validate.checkStringInputNull("Enter new Name (current: " + s.getName() + "): ");
                    String newSemester = Validate.checkStringInputNull("Enter new Semester (current: " + s.getSemester() + "): ");
                    String newCourse = Validate.checkStringInputNull("Enter new Course (current: " + s.getCourse() + "): ");

                    s.setName(newname);
                    s.setSemester(newSemester);
                    s.setCourse(newCourse);
                    System.out.println("Student updated successfully!");
                } else if (choice.equalsIgnoreCase("D")) {
                    studentList.remove(result);
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Invalid choice!");
                }

            }
        }

    }

static void report() {
    System.out.println("\n--- REPORT: STUDENT COURSE SUMMARY ---");
     for (int i = 0;i < studentList.size();i++){
         Student current = studentList.get(i);
         
         int total = 0;
         for (int j = 0; j < studentList.size();j++){
             if(studentList.get(j).getName().equalsIgnoreCase(current.getName())){
                 total++;
             }
         }
         boolean alreadyPrinted = false;
         for (int k = 0; k < i; k++){
             if(studentList.get(k).getName().equalsIgnoreCase(current.getName())){
                 alreadyPrinted = true;
                 break;
                 
             }
         }
         if(!alreadyPrinted){
             System.out.println(current.getName() + "|" + current.getCourse() + "|" + total);
         }
     }
    }

}
