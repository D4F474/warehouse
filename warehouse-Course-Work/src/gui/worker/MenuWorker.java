package gui.worker;

import engine.DataManager;
import gui.InitWindow;
import gui.welcome.WelcomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWorker extends JFrame {

    private DataManager dm;

    public MenuWorker(DataManager dm){
        this.dm = dm;

        InitWindow init = new InitWindow();
        init.mainInit(this, 350,350,"Меню за работник");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(addWorkCardBtn());
        mainPanel.add(checkTaskStatus());
        mainPanel.add(logOut());
        this.add(mainPanel);
        this.setVisible(true);
    }

    JPanel addWorkCardBtn(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Добавате работна карта");
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnterWorkCard(dm);
                dispose();
            }
        });
        return panel;
    }

    JPanel checkTaskStatus(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Провери състоянието на задача");
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatusOfTask(dm);
                dispose();
            }
        });
        return panel;
    }


    JPanel logOut(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Излез от акаунта");
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomeFrame(dm);
                dm.saveToDb();
                dispose();
            }
        });
        return panel;
    }
}
