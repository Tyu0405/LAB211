/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.HistorySalary;
import model.Worker;

/**
 *
 * @author slhoa
 */
public class WorkerManager {

    ArrayList<Worker> listWorker;
    ArrayList<HistorySalary> ListHistorySalary = new ArrayList<>();

    // Constructor initializes the work list
    public WorkerManager() {
        listWorker = new ArrayList<>();
    }

    public void addWorker(String id, String name, int age, double number, String location) {
        Worker w = new Worker(id, name, age, number, location);
        listWorker.add(w);
    }

    public ArrayList<Worker> getListExpense() {
        return listWorker;
    }

    public boolean checkIdExits(String id) {
        for (Worker w : listWorker) {
            if (w.getId().equals(id));
            return true;
        }
        return false;
    }

    public List<Worker> getAllWorker() {
        return listWorker;
    }

    public Worker getWorkerByCode(String code) {
        for (Worker w : listWorker) {
            if (w.getId().equals(code)) {
                return w;
            }
        }
        return null;
    }

    public void upSalary(double salary, Worker worker) {
        listWorker.remove(worker);
        HistorySalary hs = new HistorySalary();
        hs.setCode(worker.getId());
        hs.setName(worker.getName());
        hs.setAge(worker.getAge());
        hs.setDate(java.time.LocalDate.now());
        hs.setStatus("UP");
        hs.setUpdatesalary(worker.getSalary() + salary);
        worker.setSalary(worker.getSalary() + salary);
        listWorker.add(worker);
        ListHistorySalary.add(hs);

    }

    public void downSalary(double salary, Worker worker) {
        listWorker.remove(worker);
        HistorySalary hs = new HistorySalary();
        hs.setCode(worker.getId());
        hs.setName(worker.getName());
        hs.setAge(worker.getAge());
        hs.setDate(java.time.LocalDate.now());
        hs.setStatus("DOWN");

        if (worker.getSalary() < salary) {
            worker.setSalary(0);
            hs.setUpdatesalary(0);
        } else {
            hs.setUpdatesalary(worker.getSalary() - salary);
            worker.setSalary(worker.getSalary() - salary);
        }
        listWorker.add(worker);
        ListHistorySalary.add(hs);
    }

    public void displayWorker() {
//        System.out.printf("%-5s %-15s %-5s %-10s %-10s %-20s\n ",
//                "ID", "Name", "Age", "Salary", "Status", "Date");
        for (HistorySalary h : ListHistorySalary) {
            System.out.println(h.toString());
        }
    }

}
