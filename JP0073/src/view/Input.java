/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Constant;
import controller.ManagerExpense;
import controller.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Expense;

/**
 *
 * @author slhoa
 */
public class Input {

    ManagerExpense manager = new ManagerExpense();

    void inputExpense() {
        System.out.println("-------Add Expense---------");
        String date = getDate();
        double money = getMoney();
        String content = getContent();
        manager.addExpense(date, money, content);
        System.out.println("Add Success");
    }

    private String getDate() {
        Date date = Valid.inputDateWithFormat("Enter date: ", "Invalid Date", Constant.REGEX_DATE);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String dateFomart = sdf.format(date);
        return dateFomart;
    }

    private double getMoney() {
        double money = Valid.getDouble("Enter money: ", "Wrong formart", 0, Double.MAX_VALUE);
        return money;
    }

    private String getContent() {
        String content = Valid.getString("Enter content: ", "Re-input", Constant.REGEX_STRING);
        return content;
    }

    void displayExpense() {
        ArrayList<Expense> list = manager.getListExpense();
        double money = manager.getMoney();
        if (list.isEmpty()) {
            System.out.println("List empty");
        } else {
            for (Expense e : list) {
                System.out.println(e.display());
                System.out.println("Total: " + money);
            }
        }
    }

    void deleteExpense() {
        int idInput = Valid.getInteger("Enter id: ", "Wrong formart", 0, Integer.MAX_VALUE);
        Expense task = manager.findExpenseById(idInput);
        if (task == null) {
            System.out.println("Delete an expense fail !!");
        } else {
            manager.removeExpense(task);
            System.out.println("Delete an expense successful !!");
        }

    }

    void menu() {
        System.out.println("========= Expense program =========\n");
        System.out.println("1. Add Expense");
        System.out.println("2. Display Expense");
        System.out.println("3. Remove Expense");
        System.out.println("4. Exit");
    }
}
