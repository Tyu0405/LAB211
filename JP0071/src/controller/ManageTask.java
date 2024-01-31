package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Task;

/**
 * Task management class.
 *
 * @author 
 */
public class ManageTask {

    // List of jobs
    ArrayList<Task> listTask;

    // Constructor initializes the work list
    public ManageTask() {
        listTask = new ArrayList<>();
    }


    // Method to add a new task to the list
    public void addTask(String requirement, int taskType, Date date, double from,
            double to, String assignee, String reviewer) {
        Task task = new Task(taskType, requirement, date, from, to, assignee, reviewer);
        listTask.add(task);
    }

    public Task findTaskById(int idInput) {
        for (Task task : listTask) {
            if (task.getId() == idInput) {
                return task;
            }
        }
        return null;
    }

    // Method to delete a task
    public void removeTask(Task task) {
        listTask.remove(task);
    }

    // Method returns a list of tasks
    public ArrayList<Task> getListTask() {
        return listTask;
    }

    
//    public boolean isOverlaps(Date date, String assignee, double from, double to) {
//
//        // Loop through each job in the list
//        for (Task task : listTask) {
//            //if date and assignee of task equal to parameter then compare to plan To
//            if (task.getDate().equals(date)
//                    && task.getAssignee().compareTo(assignee) == 0) {
//
//                //if from2 < from1 && to2 > from1
//                if (from < task.getPlanFrom() && to > task.getPlanFrom()) {
//                    return true;
//                }
//                //if from2 = from1 => return true
//                if (from == task.getPlanFrom()) {
//                    return true;
//                }
//                // if from2 > from1 and from2 < to1=> return true
//                if (from > task.getPlanFrom()
//                        && from < task.getPlanTo()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
