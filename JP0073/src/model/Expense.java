/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author slhoa
 */
public class Expense {

    private int id;
    private String date;
    private double number;
    private String content;

    private static int auto_Increment = 1;

    public Expense() {
    }

    public Expense(String date, double number, String content) {
        this.id = auto_Increment;
        this.date = date;
        this.number = number;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String display() {
        System.out.printf("%-5s %-20s %-20s %-20s\n ",
                "ID", "Date", "Amount of money", "Content");

        return String.format("%-4s %-20s %-20s %-20s",
                id, date, number, content);
    }

}
