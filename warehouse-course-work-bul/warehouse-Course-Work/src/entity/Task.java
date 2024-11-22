package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Task implements Serializable {
    private static final long serialVersionUID = 7L;

    private String nameOfTask;
    private LocalDate startedTask;
    private LocalDate endedTask;
    private String responsible;
    private int hoursNeededToEnd;
    //new, started, ended, canceled
    private String status;

    public Task(String nameOfTask, LocalDate startedTask,
                String responsible, int hoursNeededToEnd, String status) {
        this.nameOfTask = nameOfTask;
        this.startedTask = startedTask;
        this.responsible = responsible;
        this.hoursNeededToEnd = hoursNeededToEnd;
        this.status = status;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public LocalDate getStartedTask() {
        return startedTask;
    }

    public void setStartedTask(LocalDate startedTask) {
        this.startedTask = startedTask;
    }

    public LocalDate getEndedTask() {
        return endedTask;
    }

    public void setEndedTask(LocalDate endedTask) {
        this.endedTask = endedTask;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public int getHoursNeededToEnd() {
        return hoursNeededToEnd;
    }

    public void setHoursNeededToEnd(int hoursNeededToEnd) {
        this.hoursNeededToEnd = hoursNeededToEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean addHours(int hours){
        hoursNeededToEnd-=hours;
        if(hoursNeededToEnd <= 0){
            return true;
        }
        return false;
    }

    public String getInfoForTask(){
        String data;
        //String nameOfTask, LocalDate startedTask,
        // String responsible, int hoursNeededToEnd, int spentHours, String status
        if(status.equals("In progress")){
            data = "Started date: " + startedTask.toString() + "\n"
                    + "hours need to end: " + hoursNeededToEnd + "\n"
                    + "Responsible person: " + responsible + "\n"
                    + "Status: " + status;
        }else{
            data = "Started date: " + startedTask.toString() + "\n"
                    + "Ended date: " + endedTask.toString() + "\n"
                    + "Responsible person: " + responsible + "\n"
                    + "Status: " + status;
        }
        return data;
    }

    @Override
    public String toString() {
        return nameOfTask ;
    }
}