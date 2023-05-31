package gui;

import iate.java.model.Car;
import iate.java.storage.CarStorage;
import iate.java.storage.ModelStorage;
import iate.java.utils.CarFilterCriterion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.*;
import java.util.List;


public class CarList extends JFrame {

    private JPanel panel1;
    private JButton butApply;
    private JLabel label1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox yearFromBox;
    private JComboBox yearToBox;
    private JTextField vinField;
    private JLabel vin;

    private CarStorage carStorage = new CarStorage();

    private ModelStorage modelStorage = new ModelStorage();
    DefaultListModel<String> carListHuman = new DefaultListModel<>();

    private ArrayList<Integer> yearList = new ArrayList();

    boolean shouldFire = false;


    public CarList() {


        for (Car i : carStorage.getAllCars()) {
            carListHuman.addElement(i.toString());
        }

        for (Integer i = 1990; i < 2023; i++) {
            yearFromBox.addItem(i.toString());
            yearToBox.addItem(i.toString());
            yearList.add(i);
        }

        for (String i : modelStorage.getAllBrands()) {
            comboBox1.addItem(i);
        }

        for (String i : modelStorage.getModelsByBrand(Objects.requireNonNull(comboBox1.getSelectedItem()).toString())) {
            comboBox2.addItem(i);
        }

        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // проверяем, что выбран новый элемент
                comboBox2.removeAllItems();
                for (String i : modelStorage.getModelsByBrand((String) e.getItem())) {
                    comboBox2.addItem(i);
                }
            }
        });

        yearToBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!shouldFire) {
                    shouldFire = true;
                    yearFromBox.removeAllItems();
                    for (Integer i : yearList) {
                        if (i <= Integer.parseInt((String) e.getItem()))
                            yearFromBox.addItem(i.toString());
                    }
                    shouldFire = false;
                }
            }
        });

        yearFromBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!shouldFire) {
                    shouldFire = true;
                    yearToBox.removeAllItems();
                    for (Integer i : yearList) {
                        if (i >= Integer.parseInt((String) e.getItem())) {
                            yearToBox.addItem(i.toString());
                        }
                    }
                    shouldFire = false;
                }
            }
        });

        butApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.removeAll();
                carListHuman.removeAllElements();
                if (!Objects.equals(vinField.getText(), "")) {
                    carListHuman.addElement(carStorage.getCarByVin(vinField.getText()).toString());
                    list1.setModel(carListHuman);
                } else {
                    Map<CarFilterCriterion, String> params = new LinkedHashMap<>() {{
                        put(CarFilterCriterion.BRAND, Objects.requireNonNull(comboBox1.getSelectedItem()).toString());
                        put(CarFilterCriterion.MODEL, Objects.requireNonNull(comboBox2.getSelectedItem()).toString());
                        put(CarFilterCriterion.YEAR_FROM, Objects.requireNonNull(yearFromBox.getSelectedItem()).toString());
                        put(CarFilterCriterion.YEAR_TO, Objects.requireNonNull(yearToBox.getSelectedItem()).toString());
                    }};
                    for (Car i : carStorage.getCarByFilter(params)) {
                        carListHuman.addElement(i.toString());
                    }
                    if (carListHuman.isEmpty()) {
                        carListHuman.addElement("К сожалению по данному фильтру машин не найдено");
                    } else {
                        list1.setModel(carListHuman);
                    }
                }
            }
        });


        list1.setModel(carListHuman);
        //region IMAGE SCALING
        ImageIcon icon = new ImageIcon("Icons/menu.png");
        Image image = icon.getImage();
        Image NewIcon = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        icon = new ImageIcon(NewIcon);
        label1.setIcon(icon);

        ImageIcon usericon = new ImageIcon("Icons/user.png");
        Image image2 = usericon.getImage();
        Image NewIcon2 = image2.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        usericon = new ImageIcon(NewIcon2);
        button1.setIcon(usericon);


        ImageIcon carsicon = new ImageIcon("Icons/cars.png");
        Image image3 = carsicon.getImage();
        Image NewIcon3 = image3.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        carsicon = new ImageIcon(NewIcon3);
        button2.setIcon(carsicon);

        ImageIcon newcar = new ImageIcon("Icons/new.png");
        Image image4 = newcar.getImage();
        Image NewIcon4 = image4.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        newcar = new ImageIcon(NewIcon4);
        button3.setIcon(newcar);

        ImageIcon info = new ImageIcon("Icons/info.png");
        Image image5 = info.getImage();
        Image NewIcon5 = image5.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        info = new ImageIcon(NewIcon5);
        button4.setIcon(info);

        ImageIcon exit = new ImageIcon("Icons/exit.png");
        Image image6 = exit.getImage();
        Image NewIcon6 = image6.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        exit = new ImageIcon(NewIcon6);
        button5.setIcon(exit);
        //endregion

        button3.setPreferredSize(new Dimension(25, 25));
        button4.setPreferredSize(new Dimension(25, 25));
        button5.setPreferredSize(new Dimension(25, 25));
        button2.setPreferredSize(new Dimension(25, 25));
        button1.setPreferredSize(new Dimension(25, 25));


        //region BORDERS and COLORS
        LineBorder lineBorder = new LineBorder(Color.gray, 2, true);
        setLocationRelativeTo(null);
        setSize(1000, 1000);
        panel1.setBackground(Color.LIGHT_GRAY);
        //endregion

        setContentPane(panel1);
        setVisible(true);


        //region ACTIONS

        button5.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          System.exit(0);
                                      }
                                  }


        );

        //endregion
    }

    public static void main(String[] args) {
        new gui.CarList();


    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
