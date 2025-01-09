package gui.worker;

import engine.DataManager;
import entity.Task;
import gui.InitWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusOfTask extends JFrame {

    private DataManager dm;
    private JComboBox<Task> comboTasks;
    private DefaultListModel<String> listTasks;
    private Task task;
    JTextArea taskInfo;

    public StatusOfTask(DataManager dm){
        this.dm = dm;
        InitWindow init = new InitWindow();
        init.mainInit(this,400,500, "Статус на задача");
        JPanel mainPanel = new JPanel();
        //TODO fix this panel

        mainPanel.setLayout(new GridLayout(3,2));

        mainPanel.add(takeTask());
        mainPanel.add(btnBack());

        this.add(mainPanel);
        this.setVisible(true);
    }

    JPanel takeTask(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));

        taskInfo = new JTextArea(10,20);

        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel name = new JLabel("Име на задача: ");
        row.add(name);

        comboTasks = new JComboBox<>();
        for(int i =0; i<dm.getTasks().stream().count(); i++){
            comboTasks.addItem(dm.getTasks().get(i));
        }

        task = (Task) comboTasks.getSelectedItem();
        taskInfo.setText(task.getInfoForTask());

        comboTasks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task = dm.findTask((Task) comboTasks.getSelectedItem());
                taskInfo.setText(task.getInfoForTask());
            }
        });

        row.add(comboTasks);
        panel.add(row);

        row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.CENTER));
        name = new JLabel("Задача:");
        row.add(name);
        row.add(taskInfo);
        panel.add(row);

    return panel;
    }

    JPanel btnBack(){
        JPanel panel = new JPanel();
        JButton btnBack = new JButton("Назад");
        panel.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuWorker(dm);
                dispose();
            }
        });
        return panel;
    }
}
