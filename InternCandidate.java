/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.l.p0022;

/**
 *
 * @author Nguyen Manh
 */
public class InternCandidate extends Candidate {

    private String majors;
    private int semester;
    private String universityName;

    public InternCandidate(String candidateId, String firstName, String lastName,
            int birthDate, String address, String phone, String email,
            String majors, int semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors()         { return majors; }
    public int getSemester()          { return semester; }
    public String getUniversityName() { return universityName; }

    public void setMajors(String majors)                 { this.majors = majors; }
    public void setSemester(int semester)                { this.semester = semester; }
    public void setUniversityName(String universityName) { this.universityName = universityName; }
}
