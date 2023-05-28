package GUI;

import iate.java.model.Car;
import iate.java.storage.CarStorage;
import iate.java.storage.ModelStorage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;


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
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField vinField;
    private JTextField textField2;
    private JLabel vin;

    private CarStorage carStorage = new CarStorage();

    private ModelStorage modelStorage = new ModelStorage();

    public CarList(){


        DefaultListModel<String> model = new DefaultListModel<>();
        for(Car i : carStorage.getAllCars() ){
            model.addElement(i.toString());
        }

        for(String i : modelStorage.getAllBrands() ){
            comboBox1.addItem(i);
        }

        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // проверяем, что выбран новый элемент
                comboBox2.removeAllItems();
                for(String i : modelStorage.getModelsByBrand((String) e.getItem())){
                    comboBox2.addItem(i);
                }
            }
        });

        butApply.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if(vinField.getText()!=""){
                                              list1.removeAll();
                                              model.removeAllElements();
                                              model.addElement(carStorage.getCarByVin(vinField.getText()).toString());
                                              list1.setModel(model);
                                          }
                                      }
                                  });



        list1.setModel(model);
        //region IMAGE SCALING
        ImageIcon icon = new ImageIcon("Icons/menu.png");
        Image image = icon.getImage();
        Image NewIcon = image.getScaledInstance(25,25, Image.SCALE_SMOOTH);
        icon = new ImageIcon(NewIcon);
        label1.setIcon(icon);

        ImageIcon usericon = new ImageIcon("Icons/user.png");
        Image image2 = usericon.getImage();
        Image NewIcon2 = image2.getScaledInstance(25,25, Image.SCALE_SMOOTH);
        usericon = new ImageIcon(NewIcon2);
        button1.setIcon(usericon);


        ImageIcon carsicon = new ImageIcon("Icons/cars.png");
        Image image3 = carsicon.getImage();
        Image NewIcon3 = image3.getScaledInstance(25,25, Image.SCALE_SMOOTH);
        carsicon = new ImageIcon(NewIcon3);
        button2.setIcon(carsicon);

        ImageIcon newcar = new ImageIcon("Icons/new.png");
        Image image4 = newcar.getImage();
        Image NewIcon4 = image4.getScaledInstance(25,25, Image.SCALE_SMOOTH);
        newcar = new ImageIcon(NewIcon4);
        button3.setIcon(newcar);

        ImageIcon info = new ImageIcon("Icons/info.png");
        Image image5 = info.getImage();
        Image NewIcon5 = image5.getScaledInstance(25,25, Image.SCALE_SMOOTH);
        info = new ImageIcon(NewIcon5);
        button4.setIcon(info);

        ImageIcon exit = new ImageIcon("Icons/exit.png");
        Image image6 = exit.getImage();
        Image NewIcon6 = image6.getScaledInstance(25,25, Image.SCALE_SMOOTH);
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

    public static void main(String[] args){
        new GUI.CarList();


    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
