package model;

import controller.Constant;
import java.util.Date;

/**
 * Class represents a Task.
 *
 * @author trungnhhe172826
 */
public class Task {

    //Automatically increment variable to create ID
    private static int auto_Increment = 1;

    // Task properties
    private int id;
    private int taskTypeID;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    // Constructor to initialize a task with specific properties
    public Task(int taskTypeID, String requirementName, Date date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = auto_Increment++;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    // Getter and Setter for properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    // Method returns task type as string
    public String getTaskTypeString(int taskTypeID) {
        String result = null;
        switch (taskTypeID) {
            case Constant.TASK_TYPE_CODE:
                result = "Code";
                break;
            case Constant.TASK_TYPE_TEST:
                result = "Test";
                break;
            case Constant.TASK_TYPE_DESIGN:
                result = "Design";
                break;
            case Constant.TASK_TYPE_REVIEW:
                result = "Review";
                break;
        }
        return result;
    }

    // toString method to print task information
    @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s %-20s %-5s %-5s %-5s %-5s\n",
                id, requirementName, getTaskTypeString(taskTypeID), date, planFrom,
                planTo, assignee, reviewer);
    }
}
