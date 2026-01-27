/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0051;

/**
 * Enum representing BMI status categories
 */
public enum BMIStatus {
    UNDER_STANDARD("Under-standard"),
    STANDARD("Standard"),
    OVERWEIGHT("Overweight"),
    FAT("Fat - should lose weight"),
    VERY_FAT("Very fat - should lose weight immediately");
    
    private final String description;
    
    BMIStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    /**
     * Determine BMI status based on BMI value
     * @param bmi BMI value
     * @return BMIStatus enum
     */
    public static BMIStatus fromBMI(double bmi) {
        if (bmi < 19) {
            return UNDER_STANDARD;
        } else if (bmi <= 25) {
            return STANDARD;
        } else if (bmi <= 30) {
            return OVERWEIGHT;
        } else if (bmi <= 40) {
            return FAT;
        } else {
            return VERY_FAT;
        }
    }
}