package gui;

import iate.java.model.User;
import iate.java.storage.CarStorage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame implements ActionListener {

    private JLabel nameLabel, lastNameLabel, passwordLabel;
    private JTextField nameTextField, lastNameTextField;
    private JPasswordField passwordField;
    private JButton registerButton;

    private CarStorage carStorage = new CarStorage();

    RegistrationForm() {
        nameLabel = new JLabel("Имя:");
        lastNameLabel = new JLabel("Фамилия:");
        passwordLabel = new JLabel("Пароль:");

        nameTextField = new JTextField();
        lastNameTextField = new JTextField();

        passwordField = new JPasswordField();

        registerButton = new JButton("Регистрация");
        registerButton.addActionListener(this);

        setLayout(null);
        setSize(350, 250);

        nameLabel.setBounds(50, 20, 100, 30);
        nameTextField.setBounds(150, 20, 150, 30);

        lastNameLabel.setBounds(50, 60, 100, 30);
        lastNameTextField.setBounds(150, 60, 150, 30);

        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(150, 100, 150, 30);

        registerButton.setBounds(150, 140, 100, 30);

        add(nameLabel);
        add(nameTextField);

        add(lastNameLabel);
        add(lastNameTextField);

        add(passwordLabel);
        add(passwordField);

        add(registerButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(0,nameTextField.getText(),lastNameTextField.getText(),passwordField.getText());
                carStorage.saveUser(user);
                LoginFrame authForm = new LoginFrame();

                authForm.show();

                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameTextField.getText();
        String lastName = lastNameTextField.getText();
        String password = new String(passwordField.getPassword());

        // Do something with the user input, for example, save it to a database or text file
        System.out.println("Name: " + name);
        System.out.println("Last name: " + lastName);
        System.out.println("Password: " + password);
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
