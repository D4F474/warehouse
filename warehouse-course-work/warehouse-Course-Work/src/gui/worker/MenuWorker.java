package gui.worker;

import engine.DataManager;
import gui.InitWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWorker extends JFrame {

    private DataManager dm;

    public MenuWorker(DataManager dm){
        this.dm = dm;

        InitWindow init = new InitWindow();
        init.mainInit(this, 150,150,"Menu Worker");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1));

        JPanel row = new JPanel();
        row.add(addWorkCardBtn());
        mainPanel.add(row);

        row = new JPanel();
        row.add(checkTaskStatus());
        mainPanel.add(row);
        this.add(mainPanel);
        this.setVisible(true);
    }

    JPanel addWorkCardBtn(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Add work card");
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
        JButton btn = new JButton("Check task status");
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
}
