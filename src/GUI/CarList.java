package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;

public class CarList extends JFrame {

    private JPanel panel1;
    private JButton ПРИМЕНИТЬButton;
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
    private JTextField textField1;
    private JTextField textField2;

    public CarList(){

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
        setSize(800, 480);
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
