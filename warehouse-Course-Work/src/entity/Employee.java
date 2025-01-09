package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee implements Serializable {

    private static final long serialVersionUID = 7L;

    private String username;
    private String password;
    private int age;
    private String firstName;
    private String lastName;
    private String role;
    private List<WorkCard> logList;
    private Map<String, Integer> spentHoursOnTask;
    public Employee() {

    }

    public Employee(String username, String password, int age, String firstName, String lastName, String role, List<WorkCard> logList) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.logList = logList;
        spentHoursOnTask = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<WorkCard> getLogList() {
        return logList;
    }

    public void setLogList(List<WorkCard> logList) {
        this.logList = logList;
    }

    public void addCard(WorkCard workCard){
        if(logList == null){
            logList = new ArrayList<>();
        }
        logList.add(workCard);
    }

    public String InfoForWork(){
        StringBuffer sb = new StringBuffer();
        Task task;
        if(logList.isEmpty()){
            return "This worker has not worked!";
        }else if(logList.size() < 2){
            task = logList.getFirst().getWorkingTask();
            sb.append("Name of task: ");
            sb.append(task.getNameOfTask());
            sb.append("\n");
            sb.append("hours worked on: ");
            sb.append(spentHoursOnTask.get(task.getNameOfTask()));
            sb.append("\n");
        }else{
            for (WorkCard workCard : logList) {
                task = workCard.getWorkingTask();
                sb.append("Name of task: ");
                sb.append(task.getNameOfTask());
                sb.append("\n");
                sb.append("hours spend on: ");
                sb.append(spentHoursOnTask.get(task.getNameOfTask()));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return  username;
    }

    public void addHoursToTask(String taskName, int hours){
        if(!spentHoursOnTask.containsKey(taskName)){
            spentHoursOnTask.put(taskName, hours);
        }else{
            spentHoursOnTask.put(taskName, spentHoursOnTask.get(taskName) + hours);
        }
    }
}
