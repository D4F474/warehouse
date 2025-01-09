package db;

import entity.Employee;
import entity.StorageOfTasks;
import entity.Task;
import entity.WorkCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerImpl implements FileManager {
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
    private File fileObjects;
    private File fileVisual;
    List<Employee> employees;
    StorageOfTasks storageOfTasks;

    public FileManagerImpl() {
        employees = new ArrayList<>();
        storageOfTasks = new StorageOfTasks();
        readWorkers();
        readStorage();
    }

    @Override
    public void saveWorkersBinary(ArrayList<Employee> employees) {
        System.out.println("writing to file managers....");
        try{
            fileObjects = new File("employeesBinnary.txt");
            this.employees.addAll(employees);
            oos = new ObjectOutputStream(new FileOutputStream(fileObjects));
            oos.writeObject(employees);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveWorkersTxt(ArrayList<Employee> employees) {
        fileVisual = new File("employeesVisual.txt");
        if(fileVisual.exists()){
            System.out.println("File" + fileVisual.getName() + "exists");
            try{
                FileWriter fw = new FileWriter(fileVisual);
                for(Employee employee : employees){
                    fw.write(employee + "\n");
                    fw.write("------------\n");
                }
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveStorageOfTasks(StorageOfTasks storage) {
        System.out.println("writing to file storage...");
        try{
            fileObjects = new File("storageBinnary.txt");
            storageOfTasks = storage;
            oos = new ObjectOutputStream(new FileOutputStream(fileObjects));
            oos.writeObject(storageOfTasks);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void  saveStorageOfTasksTxt(StorageOfTasks storage) {
        fileVisual = new File("workcard.txt");
        if (fileVisual.exists()) {
            System.out.println("File" + fileVisual.getName() + "exists");
            try {
                FileWriter fw = new FileWriter(fileVisual);
                for (WorkCard workcard : storage.getWorkCards()) {
                    fw.write(workcard + "\n");
                    fw.write("------------\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileVisual = new File("tasks.txt");
        if (fileVisual.exists()) {
            System.out.println("File " + fileVisual.getName() + " exists");
            try {
                FileWriter fw = new FileWriter(fileVisual);
                for (Task task : storage.getTasksList()) {
                    fw.write(task + "\n");
                    fw.write("------------\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void clearAll() {
        System.out.println("clearing all....");
        employees = new ArrayList<>();
        storageOfTasks = new StorageOfTasks();
        try{
            fileObjects = new File("employeesBinnary.txt");
            oos = new ObjectOutputStream(new FileOutputStream(fileObjects));
            oos.writeObject(employees);
            oos.close();

            fileObjects = new File("storageBinnary.txt");
            oos = new ObjectOutputStream(new FileOutputStream(fileObjects));
            oos.writeObject(storageOfTasks);
            oos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public void readWorkers(){
        fileObjects = new File("employeesBinnary.txt");
        if(fileObjects.exists() && fileObjects.length() >0){
            try{
                System.out.println("reading employees...");
                ois = new ObjectInputStream(new FileInputStream(fileObjects));
                employees = (ArrayList<Employee>) ois.readObject();
            }catch (InvalidClassException ice){
                ice.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }catch (ClassNotFoundException cnfe){
                cnfe.printStackTrace();
            }catch (ClassCastException cce){
                cce.printStackTrace();
            }
        }
    }
    private void readStorage() {
        fileObjects = new File("storageBinnary.txt");
        if (fileObjects.exists() && fileObjects.length() > 0) {
            try {
                System.out.println("reading storage...");
                ois = new ObjectInputStream(new FileInputStream(fileObjects));
                storageOfTasks = (StorageOfTasks) ois.readObject();
            } catch (InvalidClassException ice) {
                ice.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> getEmployeesList() {
        return employees;
    }

    @Override
    public StorageOfTasks getStorage() {
        return storageOfTasks;
    }
}
