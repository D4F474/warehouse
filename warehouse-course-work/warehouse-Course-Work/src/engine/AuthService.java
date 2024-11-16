package engine;

import entity.Employee;
import gui.worker.MenuWorker;

public class AuthService {
    private DataManager dm;

    public AuthService(DataManager dm) {
        this.dm = dm;
    }

    public boolean login(String username, String password){
        Employee employee = dm.validateUser(username, password);
        if(employee != null){
            System.out.println("Success login!");
            return true;
        }
        System.out.println("wrong username or password");
        return false;
    }

    public boolean register(String username, String password, int age, String firstName, String lastName, String role){
        if(dm.checkExistUser(username)){
            System.out.println("User with this username exist!");
            return false;
        }
        //String username, String password, int age, String firstName, String lastName, String role, List<WorkCard> logList
        dm.addEmployee(new Employee(username, password, age, firstName, lastName, role, null));
        dm.saveToDb();
        return true;
    }
}
