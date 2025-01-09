package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StorageOfTasks implements Serializable {
    private static final long serialVersionUID = 7L;

    private List<Task> tasksList;
    private List<WorkCard> workCards;

    public StorageOfTasks() {
        tasksList = new ArrayList<>();
        workCards = new ArrayList<>();
    }

    public List<Task> getTasksList() {
        return tasksList;
    }

    public List<WorkCard> getWorkCards() {
        return workCards;
    }

    public void addTaskToList(Task task){
        this.tasksList.add(task);
    }

    public void addWorkCard(WorkCard workCard){
        this.workCards.add(workCard);
    }
}
