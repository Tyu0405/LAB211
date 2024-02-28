/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Constant;
import controller.Valid;
import controller.WorkerManager;
import java.util.ArrayList;
import model.HistorySalary;
import model.Worker;

/**
 *
 * @author slhoa
 */
public class Input {

    WorkerManager wmanage = new WorkerManager();
    void addWorker() {
        String id = getId();
        boolean check_exits = wmanage.checkIdExits(id);
        if (id.isEmpty() || check_exits == true) {
            System.err.println("ID cannot be null or duplicated ");
            return;
        }
        String name = getName();
        int age = getAge();
        double salary = getSalary();
        String location = getLocation();
        wmanage.addWorker(id, name, age, salary, location);
        System.err.println("Add Sucesss");
    }

    

    // input code -> input salary
    private String getId() {

        String id = Valid.getString("Input id : ", "Re-input id like Wxxx : ", Constant.REGEX_CODE);

        return id;

    }

    private String getId(String title, String errMess) {

        String id = Valid.getString(title + " : ", errMess, Constant.REGEX_CODE);

        return id;

    }

    private String getName() {
        String name = Valid.getString("Input name: ", "Re-input", Constant.REGEX_NAME);

        return name;
    }

    private int getAge() {
        int age = Valid.getInteger("Input age: ", "Re-input 18-50", 18, 50);
        return age;
    }

    private double getSalary() {
        double salary = Valid.getDouble("Input salary: ", "Salary must > 0", 0.0001, Double.MAX_VALUE);
        return salary;
    }

    private String getLocation() {
        String location = Valid.getString("Input location: ", "Re-input: ", Constant.REGEX_NAME);
        return location;
    }

    void upSalary() {
        String id = getId("Input Code", "Khong ton tai");
        boolean check_exits = wmanage.checkIdExits(id);
        if (check_exits) {
            Worker worker = wmanage.getWorkerByCode(id);
            double newSalary = getSalary();
            wmanage.upSalary(newSalary, worker);
        } else {
            System.out.println("Worker does not exist !");
        }

    }
    
    void downSalary() {
        String id = getId("Input Code", "Khong ton tai");
        boolean check_exits = wmanage.checkIdExits(id);
        if (check_exits) {
            Worker worker = wmanage.getWorkerByCode(id);
            double newSalary = getSalary();
            wmanage.downSalary(newSalary, worker);
        } else {
            System.out.println("Worker does not exist !");
        }

    }

    public void displayWorker(){
        wmanage.displayWorker();
    }

    void menu() {
        System.out.println("========= Worker program =========\n");
        System.out.println("1. Add Worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display Worker");
        System.out.println("5. Exit");
    }
}
