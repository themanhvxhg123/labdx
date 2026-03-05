/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.l.p0022;

/**
 *
 * @author Nguyen Manh
 */
public class ExperienceCandidate extends Candidate {

    private int expInYear;
    private String proSkill;

    public ExperienceCandidate(String candidateId, String firstName, String lastName,
            int birthDate, String address, String phone, String email,
            int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear()   { return expInYear; }
    public String getProSkill() { return proSkill; }

    public void setExpInYear(int expInYear)    { this.expInYear = expInYear; }
    public void setProSkill(String proSkill)   { this.proSkill = proSkill; }
}
