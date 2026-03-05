/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.l.p0022;

/**
 *
 * @author Nguyen Manh
 */
/*
 * Candidate Management System
 * J1.L.P0022
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @author Student
 */
public class CandidateManagement {

    private static final List<Candidate> candidateList = new ArrayList<>();

    // ================================================================== //
    //  1. CREATE EXPERIENCE CANDIDATE
    // ================================================================== //
    static void createExperienceCandidate() {
        while (true) {
            System.out.println("\n--- Create Experience Candidate ---");

            String id = Validate.checkStringInputNull("Enter Candidate ID    : ");
            if (isDuplicateId(id)) {
                System.err.println("ID already exists! Please try again.");
                continue;
            }

            String firstName = Validate.checkStringInputNull("Enter First Name      : ");
            String lastName  = Validate.checkStringInputNull("Enter Last Name       : ");
            int birthDate    = Validate.checkBirthDate(      "Enter Birth Year      : ");
            String address   = Validate.checkStringInputNull("Enter Address         : ");
            String phone     = Validate.checkPhone(          "Enter Phone           : ");
            String email     = Validate.checkEmail(          "Enter Email           : ");
            int expInYear    = Validate.checkExpInYear(      "Enter Year of Exp     : ");
            String proSkill  = Validate.checkStringInputNull("Enter Professional Skill: ");

            candidateList.add(new ExperienceCandidate(
                    id, firstName, lastName, birthDate, address, phone, email,
                    expInYear, proSkill));

            System.out.println("Experience candidate created successfully!");

            if (!Validate.checkInputYN("Do you want to continue? (Y/N): ")) {
                break;
            }
        }
    }

    // ================================================================== //
    //  2. CREATE FRESHER CANDIDATE
    // ================================================================== //
    static void createFresherCandidate() {
        while (true) {
            System.out.println("\n--- Create Fresher Candidate ---");

            String id = Validate.checkStringInputNull("Enter Candidate ID    : ");
            if (isDuplicateId(id)) {
                System.err.println("ID already exists! Please try again.");
                continue;
            }

            String firstName      = Validate.checkStringInputNull("Enter First Name      : ");
            String lastName       = Validate.checkStringInputNull("Enter Last Name       : ");
            int birthDate         = Validate.checkBirthDate(      "Enter Birth Year      : ");
            String address        = Validate.checkStringInputNull("Enter Address         : ");
            String phone          = Validate.checkPhone(          "Enter Phone           : ");
            String email          = Validate.checkEmail(          "Enter Email           : ");
            String graduationDate = Validate.checkStringInputNull("Enter Graduation Date : ");
            String graduationRank = Validate.checkGraduationRank( "Enter Graduation Rank (Excellence/Good/Fair/Poor): ");
            String education      = Validate.checkStringInputNull("Enter University      : ");

            candidateList.add(new FresherCandidate(
                    id, firstName, lastName, birthDate, address, phone, email,
                    graduationDate, graduationRank, education));

            System.out.println("Fresher candidate created successfully!");

            if (!Validate.checkInputYN("Do you want to continue? (Y/N): ")) {
                break;
            }
        }
    }

    // ================================================================== //
    //  3. CREATE INTERN CANDIDATE
    // ================================================================== //
    static void createInternCandidate() {
        while (true) {
            System.out.println("\n--- Create Intern Candidate ---");

            String id = Validate.checkStringInputNull("Enter Candidate ID    : ");
            if (isDuplicateId(id)) {
                System.err.println("ID already exists! Please try again.");
                continue;
            }

            String firstName      = Validate.checkStringInputNull("Enter First Name      : ");
            String lastName       = Validate.checkStringInputNull("Enter Last Name       : ");
            int birthDate         = Validate.checkBirthDate(      "Enter Birth Year      : ");
            String address        = Validate.checkStringInputNull("Enter Address         : ");
            String phone          = Validate.checkPhone(          "Enter Phone           : ");
            String email          = Validate.checkEmail(          "Enter Email           : ");
            String majors         = Validate.checkStringInputNull("Enter Majors          : ");
            int semester          = Validate.checkPositiveInt(    "Enter Semester        : ");
            String universityName = Validate.checkStringInputNull("Enter University Name : ");

            candidateList.add(new InternCandidate(
                    id, firstName, lastName, birthDate, address, phone, email,
                    majors, semester, universityName));

            System.out.println("Intern candidate created successfully!");

            if (!Validate.checkInputYN("Do you want to continue? (Y/N): ")) {
                break;
            }
        }
    }

    // ================================================================== //
    //  4. SEARCH CANDIDATE
    // ================================================================== //
    static void searchCandidate() {
        if (candidateList.isEmpty()) {
            System.out.println("No candidates available.");
            return;
        }

        displayAllCandidates();

        String nameQuery = Validate.checkStringInputNull(
                "\nInput Candidate name (First name or Last name): ");
        int typeQuery = Validate.checkCandidateType(
                "Input type of candidate (0-Experience, 1-Fresher, 2-Intern): ");

        List<Candidate> result = new ArrayList<>();
        for (Candidate c : candidateList) {
            boolean nameMatch = c.getFirstName().toLowerCase().contains(nameQuery.toLowerCase())
                    || c.getLastName().toLowerCase().contains(nameQuery.toLowerCase());
            boolean typeMatch = c.getCandidateType() == typeQuery;
            if (nameMatch && typeMatch) {
                result.add(c);
            }
        }

        System.out.println("\nThe candidates found:");
        if (result.isEmpty()) {
            System.out.println("No candidates matched your search.");
            return;
        }

        System.out.println("+----------------------------------------------+------+---------------------+------------+---------------------------+------+");
        System.out.printf("| %-44s | %-4s | %-19s | %-10s | %-25s | %-4s |%n",
                "Full Name", "Year", "Address", "Phone", "Email", "Type");
        System.out.println("+----------------------------------------------+------+---------------------+------------+---------------------------+------+");
        for (Candidate c : result) {
            System.out.printf("| %-44s | %-4d | %-19s | %-10s | %-25s | %-4d |%n",
                    c.getFullName(), c.getBirthDate(), c.getAddress(),
                    c.getPhone(), c.getEmail(), c.getCandidateType());
        }
        System.out.println("+----------------------------------------------+------+---------------------+------------+---------------------------+------+");
    }

    // ================================================================== //
    //  DISPLAY ALL CANDIDATES (grouped by type)
    // ================================================================== //
    static void displayAllCandidates() {
        System.out.println("\nList of candidates:");

        System.out.println("===========EXPERIENCE CANDIDATE============");
        boolean found = false;
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 0) {
                System.out.println(c.getFullName());
                found = true;
            }
        }
        if (!found) System.out.println("(none)");

        System.out.println("==========FRESHER CANDIDATE================");
        found = false;
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 1) {
                System.out.println(c.getFullName());
                found = true;
            }
        }
        if (!found) System.out.println("(none)");

        System.out.println("===========INTERN CANDIDATE================");
        found = false;
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 2) {
                System.out.println(c.getFullName());
                found = true;
            }
        }
        if (!found) System.out.println("(none)");

        System.out.println("===========================================");
    }

    // ================================================================== //
    //  HELPER
    // ================================================================== //
    private static boolean isDuplicateId(String id) {
        for (Candidate c : candidateList) {
            if (c.getCandidateId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
}
