/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.Constant.STRING;
import static controller.Constant.STRING_CODE;
import static controller.Constant.STRING_NAME;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author NhatHoang
 */
public class DoctorManager {
    // add doctor
    public static void addDoctor(ArrayList<Doctor> ld) {
        
        String code = Valid.getString("enter code", "DOCxx", STRING_CODE);
        //check code exist or not
        if (Valid.checkCodeExist(ld, code)) {
            System.err.println("Code exist.");
            return;
        }
        
        String name = Valid.getString("enter name", "re-input", STRING_NAME);
        
        String specialization = Valid.getString("enter specialization", "re-input", STRING_NAME);
        
        int availability = Valid.getInteger("enter availability: ", "re-input", 0, Integer.MAX_VALUE);
        //check worker duplicate
        if (!Valid.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");
    }
    public static void updateDoctor(ArrayList<Doctor> ld) {
       
        String code = Valid.getString("enter code", "DOCxx", STRING_CODE);
        //check code exist or not
        if (!Valid.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        
        Doctor doctor = getDoctorByCode(ld, code); 
        String name = Valid.getString("enter name", "", STRING_NAME);        
        String specialization = Valid.getString("enter specialization", "re-input", STRING_NAME);        
        int availability = Valid.getInteger("enter availability: ", "re-input", 0, Integer.MAX_VALUE);
        //check user change infomation or not
        if (!Valid.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }      
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }
    
    public static void deleteDoctor(ArrayList<Doctor> ld) {
       
        String code = Valid.getString("enter code", "DOCxx", STRING_CODE);
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println("Delete successful.");
    }

    //allow user search doctor
    public static void searchDoctor(ArrayList<Doctor> ld) {
        
        String nameSearch = Valid.getString("enter name", "re-input", STRING_NAME); 
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }
    
    
    //get docter by code
    private static Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    //get list found by name
    private static ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }

}
