import engine.DataManager;
import engine.DataManagerImpl;
import gui.welcome.WelcomeFrame;


public class Main {
    public static void main(String[] args) {
        DataManager dm = new DataManagerImpl();
        WelcomeFrame wc = new WelcomeFrame(dm);
    }

}