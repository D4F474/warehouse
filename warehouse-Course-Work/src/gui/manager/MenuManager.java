package gui.manager;

import engine.DataManager;
import gui.InitWindow;
import gui.welcome.WelcomeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManager extends JFrame {

    DataManager dm;

    public MenuManager(DataManager dm){
        this.dm = dm;

        InitWindow init = new InitWindow();
        init.mainInit(this, 350,350,"Menu Worker");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(addTask());
        mainPanel.add(checkWorkCards());
        mainPanel.add(checkEmployeeReference());
        mainPanel.add(logOut());
        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel addTask(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Добавете задача");
        panel.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTaskToWorker(dm);
                dispose();
            }

        });
        return panel;
    }

    private JPanel checkWorkCards(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Провери работна карта");
        panel.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckWorkCards(dm);
                dispose();
            }

        });
        return panel;
    }

    private JPanel checkEmployeeReference(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Проверете задачите на работниците");
        panel.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeReference(dm);
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
