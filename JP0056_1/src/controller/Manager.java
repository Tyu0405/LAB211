/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.Consant.STRING_CODE;
import static controller.Consant.STRING_NAME;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;
import model.History;
import model.Worker;

/**
 *
 * @author NhatHoang
 */
public class Manager {
    
    //allow user add worker
    public static void addWorker(ArrayList<Worker> lw) {
       
        String id = Validate.getString("Enter code: ", "re-Enter code: ", STRING_CODE);
        if (Validate.checkIdExist(lw, id)) {
            System.err.println("Code(id) must be existed in DB.");
            return;
        }
        
        String name = Validate.getString("Enter name: ", "re-name : ", STRING_NAME);
        
        int age = Validate.getInteger("Enter age: ", "re-input name", 18, 50);
        
  
        double salary = Validate.getDouble("Enter salary: ", "re-input salary: > 0", 0, Double.MAX_VALUE);
      
        String workLocation = Validate.getString("Enter worklocation: ", "re-input: ", STRING_NAME);
                lw.add(new Worker(id, name, age, salary, workLocation));
            System.err.println("Add success.");
        }
    

    //allow user increase salary for user
    public static void changeSalary(ArrayList<Worker> lw, ArrayList<History> lh, double status) {
        if (lw.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        
        String id = Validate.getString("Enter code: ", "re-Enter code: ", STRING_CODE);
        Worker worker = getWorkerByCode(lw, id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            double salaryCurrent = worker.getSalary();
            double salaryUpdate;
            //check user want to update salary
            if (status == 1) {
                
                //loop until user input salary update > salary current
                while (true) {     
                    salaryUpdate = Validate.getDouble("Enter salary: ", "re-input salary: ", 0, Double.MAX_VALUE);
                    //check user input salary update > salary current
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            } else {
               
                //loop until user input salary update < salary current
                while (true) {
                    salaryUpdate = Validate.getDouble("Enter salary: ", "re-input salary: ", 0, Double.MAX_VALUE);
                    //check user input salary update < salary current
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("DOWN", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success");
        }
    }

    //allow user print history
    public static void printListHistory(ArrayList<History> lh) {
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-15s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        //print history from first to last list
        for (History history : lh) {
            printHistory(history);
        }
    }

   
    

    //get current date 
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    //print history
    public static void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10f%-15s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }

     //get worker by code
    private static Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }


}
