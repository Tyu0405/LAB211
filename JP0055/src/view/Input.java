/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import static controller.Constant.STRING_CODE;
import static controller.Constant.STRING_NAME;
import controller.DoctorManager;
import controller.Valid;
import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

/**
 *
 * @author slhoa
 */
public class Input {

    public static Scanner sc = new Scanner(System.in);
    DoctorManager manage = new DoctorManager();

    void inputDoctor() {

        String code = Valid.getString("enter code", "DOCxx", STRING_CODE);
        //check code exist or not
        Doctor doc = manage.findDoctorByCode(code);
        if (doc == null) {
            String name = Valid.getString("enter name", "re-input", STRING_NAME);

            String Specialization = Valid.getString("enter specialization", "re-input", STRING_NAME);

            int Availability = Valid.getInteger("enter availability: ", "re-input", 0, Integer.MAX_VALUE);
            //check worker duplicate
            System.err.println("Add Success");
            manage.addDoctor(code, name, Specialization, Availability);
        } else {
            System.out.println("code exits");
        }

    }

    void updateDoctor() {

        String code = Valid.getString("enter code", "DOCxx", STRING_CODE);
        Doctor doctor = manage.findDoctorByCode(code);

        if (doctor == null) {
            System.err.println("Not found doctor");
            return;
        }
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new specialization: ");
        String specialization = sc.nextLine();
        System.out.print("Enter new availability: ");
        String availabilityStr = sc.nextLine();
        boolean flag = true;

        if (!name.isEmpty()) {
            doctor.setName(name);
            flag = false;
        }

        if (!specialization.isEmpty()) {
            doctor.setSpecialization(specialization);
            flag = false;
        }

        if (!availabilityStr.isEmpty()) {
            int availability = Integer.parseInt(availabilityStr);
            doctor.setAvailability(availability);
            flag = false;
        }
        if (flag == false) {
            System.err.println("Doctor updated successfully");
        }

        if (flag == true) {
            System.err.println("No change");
        }

    }

    void deleteDoctor() {

        String code = Valid.getString("enter code", "DOCxx", STRING_CODE);
        Doctor doc = manage.findDoctorByCode(code);
        if (doc == null) {
            System.err.println("Not found doctor.");
            return;

        } else{
            manage.removeDoctor(doc);
            System.err.println("Delete successful.");
        }

    }

    //allow user search doctor
    void searchDoctor() {
        String nameSearch = Valid.getString("enter name", "re-input", STRING_NAME);
        ArrayList<Doctor> listDoctor = manage.findDoctorByName(nameSearch);
        
        if (listDoctor == null) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listDoctor) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());

            }
        }
    }

}
