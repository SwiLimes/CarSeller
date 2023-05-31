package gui;

import iate.java.model.Car;
import iate.java.model.User;
import iate.java.storage.CarStorage;
import iate.java.utils.CarFilterCriterion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LoginFrame extends JFrame {
    // Компоненты окна
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JButton registBut;

    private CarStorage carStorage = new CarStorage();

    public LoginFrame() {
        // Настройка окна
        setTitle("Авторизация");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание компонентов
        nameLabel = new JLabel("Имя:");
        nameField = new JTextField();
        passwordLabel = new JLabel("Пароль:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Войти");
        registBut = new JButton("Зарегистроваться");



        // Настройка компонентов
        nameLabel.setBounds(30, 20, 50, 25);
        nameField.setBounds(80, 20, 180, 25);
        passwordLabel.setBounds(10, 50, 70, 25);
        passwordField.setBounds(80, 50, 180, 25);
        loginButton.setBounds(20, 90, 100, 25);
        registBut.setBounds(150,90,120,25);

        // Добавление компонентов на окно
        add(nameLabel);
        add(nameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registBut);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = carStorage.getUser();
                if(nameField.getText().equals(user.getName()) && passwordField.getText().equals(user.getPass())){
                    CarList carList = new CarList(user);

                    carList.show();

                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Неправильный пароль");
                }
            }
        });

        registBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationForm registrationForm = new RegistrationForm();

                registrationForm.show();

                dispose();
            }
        });

        // Установка менеджера компоновки
        setLayout(null);
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}