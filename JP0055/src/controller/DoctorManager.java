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

    // tao doi tuong
    ArrayList<Doctor> listDoctor;

    // khoi tao contructor
    public DoctorManager() {
        listDoctor = new ArrayList<>();
    }
    // method add doctor

    public void addDoctor(String code, String name,
            String Specialization, int Availability) {
        Doctor doc = new Doctor(code, name, Specialization, Availability);
        listDoctor.add(doc);

    }

    public Doctor findDoctorByCode(String code) {
        for (Doctor doc : listDoctor) {
            if (doc.getCode().equalsIgnoreCase(code)) {
                return doc;
            }
        }
        return null;
    }

    public ArrayList<Doctor> findDoctorByName(String searchName) {
        for (Doctor doc : listDoctor) {
            if (doc.getName().contains(searchName)) {
                 listDoctor.add(doc);
                 
            }
            return listDoctor; 
        } 
          return null;
                 
    }

    public void removeDoctor(Doctor doc) {
        listDoctor.remove(doc);
    }

    public ArrayList<Doctor> getListDoctor() {
        return listDoctor;
    }

}
