package gui.welcome;

import engine.DataManager;
import gui.InitWindow;
import gui.login.LoginFrame;
import gui.register.RegisterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {
    DataManager dm;
    public WelcomeFrame(DataManager dm){
        this.dm = dm;

        InitWindow init = new InitWindow();
        init.mainInit(this, 150,250,"Добре дошли");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(loginBtn());

        mainPanel.add(registerBtn());

        this.add(mainPanel);
        setVisible(true);
    }

    public JPanel loginBtn(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Логин");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entering login page...");
                new LoginFrame(dm);
                dispose();
            }
        });
        panel.add(btn);
        return panel;
    }

    public JPanel registerBtn(){
        JPanel panel = new JPanel();
        JButton btn = new JButton("Регистрация");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame(dm);
            }
        });
        panel.add(btn);
        return panel;
    }
}
