package gui.manager;

import engine.DataManager;
import entity.Employee;
import entity.WorkCard;
import gui.InitWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeReference extends JFrame {

    DataManager dm;
    JComboBox<Employee> comboEmployees;
    JTextArea infoForEmployee;

    public EmployeeReference(DataManager dm) {
        this.dm = dm;

        InitWindow init = new InitWindow();
        init.mainInit(this, 400,600,"Employee");

        JPanel mainPanel = new JPanel();
        mainPanel.add(takeWorkCard());
        mainPanel.add(backBtn());

        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel takeWorkCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Employee Details"));

        comboEmployees = new JComboBox<>();
        for (Employee em : dm.getEmployees()) {
            if(em.getRole().equals("Worker")){
            comboEmployees.addItem(em);
            }
        }


        comboEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee selectedEmployee = (Employee) comboEmployees.getSelectedItem();
                if (selectedEmployee != null) {
                    infoForEmployee.setText(selectedEmployee.InfoForWork());
                }
            }
        });

        infoForEmployee = new JTextArea(10, 20);
        infoForEmployee.setLineWrap(true);
        infoForEmployee.setWrapStyleWord(true);
        infoForEmployee.setEditable(false);
        comboEmployees.setSelectedIndex(0);

        JScrollPane scrollPane = new JScrollPane(infoForEmployee,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(comboEmployees, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public JPanel backBtn(){
        JPanel panel = new JPanel();

        JButton btn = new JButton("Back");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuManager(dm);
                dispose();
            }
        });
        panel.add(btn);

        return panel;
    }

}
