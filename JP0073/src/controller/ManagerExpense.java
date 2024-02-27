/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Expense;

/**
 *
 * @author slhoa
 */
public class ManagerExpense {
    ArrayList<Expense> listExpense;

    // Constructor initializes the work list
    public ManagerExpense() {
        listExpense = new ArrayList<>();
    }
    
    public void addExpense(String date, double number, String content) {
        Expense e = new Expense(date, number, content);
        listExpense.add(e);
    }

    public Expense findExpenseById(int idInput) {
        for (Expense e : listExpense) {
            if (e.getId() == idInput) {
                return e;
            }
        }
        return null;
    }
    public boolean checkLoop(String date, double num, String content){
        for(Expense e :listExpense){
            if(e.getDate().equalsIgnoreCase(date)&& e.getNumber() == num
                    && e.getContent().equalsIgnoreCase(content))
            return true;
        }
        return false;
    }
    
    public double getMoney(){
        double money = 0;
        for(Expense e : listExpense){
          money +=  e.getNumber();
        }
        return money;
    }

    // Method to delete a task
    public void removeExpense(Expense task) {
        listExpense.remove(task);
    }

    // Method returns a list of tasks
    public ArrayList<Expense> getListExpense() {
        return listExpense;
    }
    
}
