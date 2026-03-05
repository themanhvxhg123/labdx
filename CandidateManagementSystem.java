/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package j1.l.p0022;

/**
 *
 * @author Nguyen Manh
 */
public class CandidateManagementSystem {

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n====== CANDIDATE MANAGEMENT SYSTEM ======");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.println("==========================================");

            int menu = Validate.checkNumberFormat("Enter a number: ");
            switch (menu) {
                case 1:
                    CandidateManagement.createExperienceCandidate();
                    CandidateManagement.displayAllCandidates();
                    break;
                case 2:
                    CandidateManagement.createFresherCandidate();
                    CandidateManagement.displayAllCandidates();
                    break;
                case 3:
                    CandidateManagement.createInternCandidate();
                    CandidateManagement.displayAllCandidates();
                    break;
                case 4:
                    CandidateManagement.searchCandidate();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Please enter a number from 1 to 5.");
            }
        }
    }
}
