package db;

import entity.Employee;
import entity.StorageOfTasks;

import java.util.ArrayList;
import java.util.List;

public interface FileManager {
    void saveWorkersBinary(ArrayList<Employee> employees);
    void saveWorkersTxt(ArrayList<Employee> employees);
    void saveStorageOfTasks(StorageOfTasks storage);
    void saveStorageOfTasksTxt(StorageOfTasks storage);
    void clearAll();
    List<Employee> getEmployeesList();
    StorageOfTasks getStorage();


}
