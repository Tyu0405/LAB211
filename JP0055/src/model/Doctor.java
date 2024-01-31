/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NhatHoang
 */
public class Doctor {
    private String code;
    private String name; 
    private String Specialization;
    private int Availability;

    public Doctor() {
    }

    public Doctor(String code, String name, String Specialization, int Availability) {
        this.code = code;
        this.name = name;
        this.Specialization = Specialization;
        this.Availability = Availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    @Override
    public String toString() {
         String format = String.format("%-10s%-15s%-25s%-20d\n", code, name, 
                                             Specialization, Availability);
         return format;
    }
    
   
}
