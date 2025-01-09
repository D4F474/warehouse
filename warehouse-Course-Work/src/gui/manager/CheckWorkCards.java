package gui.manager;

import engine.DataManager;
import entity.WorkCard;
import gui.InitWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckWorkCards extends JFrame {

    private DataManager dm;
    private JComboBox<WorkCard> comboWorkCard;
    private JTextArea infoForWorkCard;

    public CheckWorkCards(DataManager dm) {
        this.dm = dm;

        InitWindow init = new InitWindow();
        init.mainInit(this, 600, 400, "Проверете работната карта");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(takeWorkCard(), BorderLayout.CENTER);
        mainPanel.add(backBtn(), BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel takeWorkCard() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Работна карта детайли:"));

        comboWorkCard = new JComboBox<>();
        for (WorkCard wc : dm.getWorkCards()) {
            comboWorkCard.addItem(wc);
        }

        comboWorkCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkCard selectedWorkCard = (WorkCard) comboWorkCard.getSelectedItem();
                if (selectedWorkCard != null) {
                    infoForWorkCard.setText(selectedWorkCard.getInfoForWorkCard());
                }
            }
        });

        infoForWorkCard = new JTextArea(10, 20);
        infoForWorkCard.setLineWrap(true);
        infoForWorkCard.setWrapStyleWord(true);
        infoForWorkCard.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(infoForWorkCard,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(comboWorkCard, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel backBtn() {
        JPanel panel = new JPanel();
        JButton btn = new JButton("Назад");
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
