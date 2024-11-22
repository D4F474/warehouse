package gui.Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class JCalendar extends JPanel {

    private static int maxYear = 2024;
    private static int maxMonths =12;

    private JComboBox<Integer> dayChoice;
    private JComboBox<Month> monthChoice;
    private JComboBox<Integer> yearChoice;

    private int day = 31;
    private int months =12;
    private int year =0;
    private int minYear = 1920;

    public JCalendar(){

        dayChoice = new JComboBox<>();
        monthChoice = new JComboBox<>();
        yearChoice = new JComboBox<>();

        this.setLayout(new GridLayout(1,3));

        loadDays();
        loadMonths();
        loadYears();

        monthChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkMonth();
                loadDays();
            }
        });

        yearChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkMonth();
                loadDays();
            }
        });

        this.add(dayChoice);
        this.add(monthChoice);
        this.add(yearChoice);
    }

    void checkMonth(){
        Month selectedMonth = (Month) monthChoice.getSelectedItem();

        switch (selectedMonth){

            case January:
                day = 31;
                break;

            case February:
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                    day = 29;
                }else{
                    day = 28;
                }
                break;

            case March:
                day = 31;
                break;

            case April:
                day = 30;
                break;

            case May:
                day = 31;
                break;

            case June:
                day = 30;
                break;

            case July:
                day = 31;
                break;

            case August:
                day = 31;
                break;

            case September:
                day = 30;
                break;

            case October:
                day = 31;
                break;

            case November:
                day = 30;
                break;

            case December:
                day = 31;
                break;
        }
    }
    private void loadDays(){
        dayChoice.removeAllItems();
        for(int i =0; i<day; i++){
            dayChoice.addItem(i + 1);
        }
    }

    private void loadMonths(){
        for(Month m : Month.values()){
            monthChoice.addItem(m);
        }
    }

    private void loadYears(){
        for (int i =maxYear; i>=minYear; i--){
            yearChoice.addItem(i);
        }
    }

    public LocalDate getDate(){
        LocalDate date = LocalDate.of(
                (Integer) yearChoice.getSelectedItem(),
                ((Month) monthChoice.getSelectedItem()).getValue(),
                (Integer) dayChoice.getSelectedItem());

        return date;
    }
}
