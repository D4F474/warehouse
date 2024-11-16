import engine.DataManager;
import engine.DataManagerImpl;
import gui.manager.AddTaskToWorker;
import gui.manager.CheckWorkCards;
import gui.manager.EmployeeReference;
import gui.manager.MenuManager;
import gui.welcome.WelcomeFrame;
import gui.worker.EnterWorkCard;
import gui.worker.StatusOfTask;

public class Main {
    public static void main(String[] args) {

        DataManager dm = new DataManagerImpl();
        WelcomeFrame wc = new WelcomeFrame(dm);
        //EnterWorkCard ent = new EnterWorkCard(dm);
        //MenuManager mm = new MenuManager(dm);
        //AddTaskToWorker atw = new AddTaskToWorker(dm);
        //StatusOfTask st = new StatusOfTask(dm);
        //CheckWorkCards cwk = new CheckWorkCards(dm);
        //EmployeeReference er = new EmployeeReference(dm);

        for(int i =0; i<dm.getEmployees().size(); i++){
            System.out.println(dm.getEmployees().get(i));
        }

        //for(int i =0; i<dm.getTasks().size(); i++){
        //    System.out.println(dm.getTasks().get(i));
        //}
        /**
        FileManager fm = new FileManagerImpl();
        //String username, String password, int age, String firstName, String lastName, String role, List<WorkCard> logList

        ArrayList<Employee> emp = new ArrayList<>();
        Employee em = new Employee("Pesheca", "Pesho123", 21, "Peshko", "Peshkov", "Manager", null);
        Employee em1 = new Employee("Grisha", "Grishov123", 21, "Grishkovski", "Mihaylov", "Cleaner", null);
        Employee em2 = new Employee("Grisha", "Grishov123", 21, "Grishkovski", "Mihaylov", "Cleaner", null);
        emp.add(em);
        emp.add(em1);
        emp.add(em2);
        fm.clearAll();
        fm.saveWorkersBinary(emp);

        for(int i = 0; i< fm.getEmployeesList().size(); i++){
            System.out.println(fm.getEmployeesList().get(i));
        }
        */

    }

}