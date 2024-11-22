package gui.worker;
import engine.DataManager;
import entity.Task;
import entity.WorkCard;
import gui.InitWindow;
import gui.Calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class EnterWorkCard extends JFrame {

    private DataManager dm;
    private JCalendar calendar;
    private JComboBox<Task> tasksComboBox;
    private JTextArea descriptionOfTaskArea;
    private JTextField hoursSpendArea;

    private LocalDate dateChoice;
    private Task taskChoice;
    private String descriptionOfTask;
    private int hoursSpend;

    public EnterWorkCard(DataManager dm){
        this.dm = dm;
        InitWindow init = new InitWindow();
        init.mainInit(this, 800, 500, "Информация за работна карта");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,2, 0,0));

        JPanel Row = new JPanel();
        Row.setLayout(new GridLayout(1,2));
        Row.add(endAction());
        Row.add(addHoursToWork());
        mainPanel.add(Row);

        Row = new JPanel();
        Row.setLayout(new GridLayout(1,2));
        Row.add(taskChoice());
        Row.add(descriptionForTask());
        mainPanel.add(Row);

        Row = new JPanel();
        Row.setLayout(new GridLayout(1,2));
        Row.add(backButton());
        Row.add(submitButton());
        mainPanel.add(Row);


        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel addHoursToWork(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        JPanel row = new JPanel();
        JLabel name = new JLabel("Часове които сте работили:");
        row.add(name);
        panel.add(row);

        row = new JPanel();
        hoursSpendArea = new JTextField(10);
        row.add(hoursSpendArea);
        panel.add(row);

        return panel;
    }

    private JPanel endAction(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        JPanel row = new JPanel();
        JLabel name = new JLabel("Край на задачата:");
        row.add(name);
        panel.add(row);

        row = new JPanel();
        calendar = new JCalendar();
        row.add(calendar);
        panel.add(row);

        return panel;
    }

    private JPanel taskChoice(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));

        JPanel row = new JPanel();
        JLabel name = new JLabel("Задача:");
        row.add(name);
        panel.add(row);

        row = new JPanel();
        tasksComboBox = new JComboBox<>();
        for(int i =0; i<dm.getTasks().size(); i++){
            tasksComboBox.addItem(dm.getTasks().get(i));
        }
        row.add(tasksComboBox);
        panel.add(row);

        return panel;
    }

    private JPanel descriptionForTask(){
        JPanel panel = new JPanel();

        JPanel row = new JPanel();
        JLabel name = new JLabel("Описание на извършената задача:");
        row.add(name);
        panel.add(row);

        row = new JPanel();
        descriptionOfTaskArea = new JTextArea(5,30);
        row.add(descriptionOfTaskArea);
        panel.add(row);

        return panel;
    }

    private JPanel submitButton(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Запази");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateChoice = calendar.getDate();
                taskChoice= (Task) tasksComboBox.getSelectedItem();
                descriptionOfTask = descriptionOfTaskArea.getText();
                hoursSpend = Integer.parseInt(hoursSpendArea.getText());
                if(taskChoice.addHours(hoursSpend)) {
                dm.deleteTask(taskChoice);
                }
                WorkCard wc = new WorkCard(dateChoice,taskChoice,descriptionOfTask);
                wc.addHours(hoursSpend);
                dm.getEmployee().addHoursToTask(taskChoice.getNameOfTask(),hoursSpend);
                dm.addWorkCard(wc);
                dm.saveToDb();
                new MenuWorker(dm);
                dispose();
            }
        });
        panel.add(btn);
        return panel;
    }

    private JPanel backButton(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Назад");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuWorker(dm);
                dispose();
            }
        });
        panel.add(btn);
        return panel;
    }

}
