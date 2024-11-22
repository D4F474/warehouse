package engine;

import db.FileManager;
import db.FileManagerImpl;
import entity.Employee;
import entity.StorageOfTasks;
import entity.Task;
import entity.WorkCard;

import java.util.ArrayList;
import java.util.List;

public class DataManagerImpl implements DataManager {
    private FileManager fm = new FileManagerImpl();
    private List<Employee> employees;
    private Employee employee;
    private StorageOfTasks storage;

    public DataManagerImpl() {
        if(!fm.getEmployeesList().isEmpty()){
            employees = fm.getEmployeesList();
        }else{
            employees = new ArrayList<>();
        }
        if(fm.getStorage() != null){
            storage = fm.getStorage();
        }else{
            storage = new StorageOfTasks();
        }
    }

    @Override
    public Employee validateUser(String username, String password) {
        for(int i =0; i< employees.stream().count() ; i++){
            if(employees.get(i).getUsername().equals(username) && employees.get(i).getPassword().equals(password)){
                employee = employees.get(i);
                return employee;
            }
        }

        return null;
    }

    @Override
    public boolean checkExistUser(String username) {
        for(int i =0; i<(employees.stream().count()); i++){
            if(employees.get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void addTask(Task task) {
        storage.addTaskToList(task);
    }

    @Override
    public Task findTask(Task task) {
        for(int i =0; i<storage.getTasksList().size(); i++){
            if(storage.getTasksList().get(i).getNameOfTask().equals(task.getNameOfTask())){
                return storage.getTasksList().get(i);
            }
        }
        return null;
    }

    @Override
    public List<WorkCard> getWorkCards() {
        return storage.getWorkCards();
    }

    @Override
    public WorkCard findWorkCard(WorkCard workCard) {
        for(WorkCard wc : storage.getWorkCards()){
            if(wc.getSerialCodeOfWorkCard().equals(workCard.getSerialCodeOfWorkCard())){
                return wc;
            }
        }
    return null;
    }

    @Override
    public void addWorkCard(WorkCard workCard) {
        employee.addCard(workCard);
        storage.addWorkCard(workCard);
    }

    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public List<Task> getTasks() {
        return storage.getTasksList();
    }

    public void deleteTask(Task task){
        for(int i =0;i<storage.getTasksList().size(); i++){
            if(storage.getTasksList().get(i).getNameOfTask().equals(task.getNameOfTask())){
                storage.getTasksList().remove(i);
            }
        }
    }

    @Override
    public void saveToDb() {
        fm.clearAll();
        fm.saveWorkersBinary((ArrayList<Employee>)employees);
        fm.saveStorageOfTasks(storage);
    }
}
