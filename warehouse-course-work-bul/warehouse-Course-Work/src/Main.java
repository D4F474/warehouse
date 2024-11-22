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

        for(int i =0; i<dm.getEmployees().size(); i++){
            System.out.println(dm.getEmployees().get(i));
        }




    }

}