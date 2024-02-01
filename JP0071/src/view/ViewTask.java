package view;

import controller.Constant;
import controller.ManageTask;
import java.util.Date;
import model.Task;
import controller.Valid;

/**
 * The management layer interacts with users, performing work management
 * functions.
 *
 * @author 
 */
public class ViewTask {

    // Task management object
    ManageTask manage = new ManageTask();

    // Method to enter information and add a task job
    void inputTask() {
        //input information + check valid data
        //input properties
        System.out.println("------------Add Task---------------");
        String requirement = getRequirementName();
        int taskType = getTaskType();
        Date date = getDate();
        double from = getFrom();
        double to = getTo(from);
        String assignee = getAssignee();
        String reviewer = getReviewer();

//         Check if the new job is duplicated
        boolean isOverlap = manage.isOverlaps(date, assignee, from, to);
        if (isOverlap) {
            System.err.println("Overlap task");
        } else {
            System.out.println("Add successfull !");
        }

        // Add new job to management list
        manage.addTask(requirement, taskType, date, from, to, assignee, reviewer);

    }

    // Methods to receive information from the user for job properties
    private String getRequirementName() {
        String requirement = Valid.getString("Requirement Name: ", "Requirement "
                + "Name must be letters or digits", Constant.REGEX_STRING_NAME);
        return requirement;
    }

    // Get job type from user.
    private int getTaskType() {
        int result = Valid.getInteger("Enter task type: ", "It must be digits",
                1, 4);
        return result;
    }

    // Get job execution date from user.
    private Date getDate() {
        Date date = Valid.inputDateWithFormat("Input first date:",
                "Input must be in format dd-MM-yyyy", Constant.REGEX_DATE);
        return date;
    }

    // Get start time from user.
    private double getFrom() {
        double from = Valid.getDouble("Enter from: ", "Wrong formart", 8.0, 17.5);
        return from;
    }

    // Get end time from user.
    private double getTo(double from) {
        double to = Valid.getDouble("Enter to: ", "Wrong formart", from + 0.5, 17.5);
        return to;
    }

    // Get takers from users.
    private String getAssignee() {
        String assignee = Valid.getString("Enter assignee: ",
                "Re-input", Constant.REGEX_STRING_NAME);
        return assignee;
    }
    
    // Get reviewers from users.
    private String getReviewer() {
        String reviewer = Valid.getString("Enter reviewer: ", "Wrong formart", Constant.REGEX_STRING_NAME);
        return reviewer;
    }

    // Method to delete a job based on ID
    void deleteTask() {
        int idInput = Valid.getInteger("Enter id: ", "Wrong formart", 0, Integer.MAX_VALUE);
        Task task = manage.findTaskById(idInput);
        if (task == null) {
            System.out.println("NOT FOUND TASK !!");
        } else {
            manage.removeTask(task);
            System.out.println("Remove successful !!");
        }

    }

    // Method to display task list
    void displayTask() {
        
        for (Task task : manage.getListTask()) {
            
            System.out.println(task.display());
        }
    }
    
    // Display the menu to the user
    public static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }

}
