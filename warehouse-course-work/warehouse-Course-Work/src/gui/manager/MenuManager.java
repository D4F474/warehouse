package gui.manager;

import engine.DataManager;
import gui.InitWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManager extends JFrame {

    DataManager dm;

    public MenuManager(DataManager dm){
        this.dm = dm;

        InitWindow init = new InitWindow();
        init.mainInit(this, 150,150,"Menu Worker");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(addTask());
        mainPanel.add(checkWorkCards());
        mainPanel.add(checkEmployeeReference());
        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel addTask(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Add task");
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
        JButton btn = new JButton("Check workcards");
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
        JButton btn = new JButton("Check employee work");
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
}
