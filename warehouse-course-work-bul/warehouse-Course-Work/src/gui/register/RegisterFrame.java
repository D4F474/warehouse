package gui.register;

import engine.AuthService;
import engine.DataManager;
import gui.InitWindow;
import gui.welcome.WelcomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

    DataManager dm;
    private AuthService authService;
    TextField usernameArea;
    TextField firstNameArea;
    TextField lastNameArea;
    TextField textAgeArea;
    JPasswordField passwordArea;
    JComboBox<String> roleComboBox;

    public RegisterFrame(DataManager dm){
        this.dm = dm;
        authService = new AuthService(this.dm);

        InitWindow init = new InitWindow();
        init.mainInit(this, 350,350,"Register");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(userNameArea());
        mainPanel.add(firstnameArea());
        mainPanel.add(lastnameArea());
        mainPanel.add(ageArea());
        mainPanel.add(passwordArea());
        mainPanel.add(roleSelectionArea());
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

    public JPanel firstnameArea() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Първо име:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstNameArea = new TextField(20);
        firstNameArea.setMaximumSize(new Dimension(200, 30));

        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(firstNameArea);
        return panel;
    }

    public JPanel lastnameArea() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Фамилия:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastNameArea = new TextField(20);
        lastNameArea.setMaximumSize(new Dimension(200, 30));

        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(lastNameArea);
        return panel;
    }

    public JPanel ageArea(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel ageLabel = new JLabel("Години:");
        ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textAgeArea = new TextField(20);
        textAgeArea.setMaximumSize(new Dimension(200, 30));

        panel.add(ageLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(textAgeArea);
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
        JButton btnBack = new JButton("Върни се");
        JButton btnLogin = new JButton("Регистрирай се");

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
                //String username, String password, int age, String firstName, String lastName, String role
                if(usernameArea.getText().isEmpty() ||
                        firstNameArea.getText().isEmpty() ||
                        lastNameArea.getText().isEmpty() ||
                        textAgeArea.getText().isEmpty()){
                        JOptionPane.showMessageDialog(panel, "Трябва да запълните всички полета!", "Грешка", JOptionPane.ERROR_MESSAGE);
                }else{
                    System.out.println("Registering in...");
                    String username = usernameArea.getText();
                    String firstName = firstNameArea.getText();
                    String lastName = lastNameArea.getText();
                    int age = Integer.parseInt(textAgeArea.getText());
                    String password = new String(passwordArea.getPassword());
                    String role = roleComboBox.getSelectedItem().toString();
                        if(authService.checkPasswordCorrectionForRegister(password)){
                            authService.register(username, password,age,firstName,lastName, role);
                        }else{
                           JOptionPane.showMessageDialog(panel,"Въведете парола съдържаща число/буква/символ", "Грешка", JOptionPane.ERROR_MESSAGE);
                        }
                }
            }
        });

        panel.add(btnBack);
        panel.add(btnLogin);
        return panel;
    }

    public JPanel roleSelectionArea() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel roleLabel = new JLabel("Избери роля:");
        roleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] roles = {"Worker", "Manager"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setMaximumSize(new Dimension(200, 30));
        roleComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(roleLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(roleComboBox);
        return panel;
    }
}