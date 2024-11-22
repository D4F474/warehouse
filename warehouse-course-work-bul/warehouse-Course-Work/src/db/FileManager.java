package db;

import entity.Employee;
import entity.StorageOfTasks;

import java.util.ArrayList;
import java.util.List;

public interface FileManager {
    void saveWorkersBinary(ArrayList<Employee> employees);
    void saveStorageOfTasks(StorageOfTasks storage);
    void clearAll();
    public List<Employee> getEmployeesList();
    public StorageOfTasks getStorage();

}
