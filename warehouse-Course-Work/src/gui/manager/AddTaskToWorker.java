package gui.manager;

import engine.DataManager;
import entity.Task;
import gui.InitWindow;
import gui.Calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddTaskToWorker extends JFrame {

    private Task task;
    private DataManager dm;
    private JTextField nameOfTaskArea;
    private JTextField hoursToEndArea;
    private JCalendar calendar;
    private String nameOfTask;
    private LocalDate startDate;
    private String responsible;
    private int hoursNeededToEndTask;

    public AddTaskToWorker(DataManager dm) {
        this.dm = dm;

        InitWindow init = new InitWindow();
        init.mainInit(this, 600, 400, "Добавяне на задача:");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(taskDetailsPanel(), BorderLayout.CENTER);
        mainPanel.add(buttonPanel(), BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel taskDetailsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Детайли за задача:"));

        panel.add(nameOfTask());
        panel.add(hoursToFinish());
        panel.add(startDate());

        return panel;
    }

    private JPanel nameOfTask() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JLabel nameLabel = new JLabel("Име на задача:");
        nameOfTaskArea = new JTextField(20);

        panel.add(nameLabel, BorderLayout.NORTH);
        panel.add(nameOfTaskArea, BorderLayout.CENTER);

        return panel;
    }

    private JPanel hoursToFinish() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JLabel hoursLabel = new JLabel("Часове в които да се изпълни задачата:");
        hoursToEndArea = new JTextField(20);

        panel.add(hoursLabel, BorderLayout.NORTH);
        panel.add(hoursToEndArea, BorderLayout.CENTER);

        return panel;
    }

    private JPanel startDate() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JLabel startDateLabel = new JLabel("Дата на започване:");
        calendar = new JCalendar();

        panel.add(startDateLabel, BorderLayout.NORTH);
        panel.add(calendar, BorderLayout.CENTER);

        return panel;
    }

    private JPanel buttonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JButton backBtn = new JButton("Назад");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuManager(dm);
                dispose();
            }
        });

        JButton submitBtn = new JButton("Запиши");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                responsible = dm.getEmployee().getUsername();
                startDate = calendar.getDate();
                nameOfTask = nameOfTaskArea.getText();
                try {
                    hoursNeededToEndTask = Integer.parseInt(hoursToEndArea.getText());
                    task = new Task(nameOfTask, startDate, responsible, hoursNeededToEndTask, "In progress");
                    dm.addTask(task);
                    dm.saveToDb();
                    JOptionPane.showMessageDialog(AddTaskToWorker.this, "Задачата е добавена успешно!", "Информация", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new MenuManager(dm);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddTaskToWorker.this, "Вкарайте точни числа!", "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(backBtn);
        panel.add(submitBtn);

        return panel;
    }
}
