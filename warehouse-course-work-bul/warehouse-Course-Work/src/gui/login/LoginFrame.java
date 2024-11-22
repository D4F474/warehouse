package gui.login;

import engine.AuthService;
import engine.DataManager;
import gui.InitWindow;
import gui.manager.MenuManager;
import gui.welcome.WelcomeFrame;
import gui.worker.MenuWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private DataManager dm;
    private AuthService authService;
    private TextField usernameArea;
    private JPasswordField passwordArea;


    public LoginFrame(DataManager dm) {
        this.dm = dm;
        authService = new AuthService(this.dm);

        InitWindow init = new InitWindow();
        init.mainInit(this, 350,350,"Логин");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(userNameArea());
        mainPanel.add(passwordArea());
        mainPanel.add(buttonArea());

        this.add(mainPanel);
        this.setVisible(true);
    }

    public JPanel userNameArea() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Потребителско име:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameArea = new TextField(20);
        usernameArea.setMaximumSize(new Dimension(200, 30));

        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(usernameArea);

        return panel;
    }

    public JPanel passwordArea() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel passwordLabel = new JLabel("Парола:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordArea = new JPasswordField(20);
        passwordArea.setMaximumSize(new Dimension(200, 30));


        panel.add(passwordLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(passwordArea);
        return panel;
    }

    public JPanel buttonArea() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnBack = new JButton("Назад");
        JButton btnLogin = new JButton("Логин");

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomeFrame(dm);
                dispose();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameArea.getText();
                String password = new String(passwordArea.getPassword());
                System.out.println("Logging in...");
                if(authService.login(username, password)){
                    checkRole(dm.getEmployee().getRole());
                }else{
                    JOptionPane.showMessageDialog(panel, "Потребителското име или паролата е грешно!", "Грешка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(btnBack);
        panel.add(btnLogin);
        return panel;
    }
    void checkRole(String role){
        switch(role){
            case "Worker":
                    new MenuWorker(dm);
                    dispose();
                break;
            case "Manager":
                    new MenuManager(dm);
                    dispose();
                break;
        }
    }
}
