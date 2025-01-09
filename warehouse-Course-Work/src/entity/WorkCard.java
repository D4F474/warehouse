package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class WorkCard implements Serializable {
    private static final long serialVersionUID = 7L;

    private String serialCodeOfWorkCard;
    private LocalDate startOfAction;
    private LocalDate endOfAction;
    private Task workingTask;
    private String typeActivityPerformed;
    private int hoursWorkedOnTask;

    public WorkCard( LocalDate endOfAction, Task workingTask, String typeActivityPerformed) {
        this.endOfAction = endOfAction;
        this.workingTask = workingTask;
        this.typeActivityPerformed = typeActivityPerformed;
        this.serialCodeOfWorkCard = generatedSerialCodeOfWC();
    }

    public LocalDate getStartOfAction() {
        return startOfAction;
    }

    public void setStartOfAction(LocalDate startOfAction) {
        this.startOfAction = startOfAction;
    }

    public LocalDate getEndOfAction() {
        return endOfAction;
    }

    public void setEndOfAction(LocalDate endOfAction) {
        this.endOfAction = endOfAction;
    }

    public Task getWorkingTask() {
        return workingTask;
    }

    public void setWorkingTask(Task workingTask) {
        this.workingTask = workingTask;
    }

    public String getTypeActivityPerformed() {
        return typeActivityPerformed;
    }

    public void setTypeActivityPerformed(String typeActivityPerformed) {
        this.typeActivityPerformed = typeActivityPerformed;
    }

    public String getSerialCodeOfWorkCard() {
        return serialCodeOfWorkCard;
    }

    public void setSerialCodeOfWorkCard(String serialCodeOfWorkCard) {
        this.serialCodeOfWorkCard = serialCodeOfWorkCard;
    }

    private String generatedSerialCodeOfWC(){
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<6; i++){
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }


    public int getHoursWorkedOnTask() {
        return hoursWorkedOnTask;
    }

    public void addHours(int a){
        hoursWorkedOnTask += a;
    }

    public String getInfoForWorkCard(){
        return  "Name of task: " + workingTask.getNameOfTask() + "\n"
                +"Started date: " + workingTask.getStartedTask() + "\n"
                + "Responsible person: " + getWorkingTask().getResponsible() + "\n"
                + "Hours worked on it: " + hoursWorkedOnTask + "\n"
                + "What has the employee done: " + typeActivityPerformed;
    }

    @Override
    public String toString() {
        return serialCodeOfWorkCard;
    }
}
