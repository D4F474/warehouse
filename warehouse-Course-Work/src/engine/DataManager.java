package engine;

import entity.Employee;
import entity.Task;
import entity.WorkCard;

import java.util.List;

public interface DataManager {
    Employee validateUser(String username, String password);
    boolean checkExistUser(String username);
    void addEmployee(Employee employee);
    void addTask(Task task);
    void addWorkCard(WorkCard workCard);
    Task findTask(Task task);
    List<WorkCard> getWorkCards();
    WorkCard findWorkCard(WorkCard workCard);
    Employee getEmployee();
    List<Employee> getEmployees();
    List<Task> getTasks();
    void deleteTask(Task task);
    void saveToDb();
}
