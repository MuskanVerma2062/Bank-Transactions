package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup4 extends JFrame implements ActionListener {

    JButton button1, button2;
    JLabel label1, label2, label3, label4, label5, label6;
//    JPanel panel1;
    String pin;
    Signup4(String pin){

        this.pin = pin;

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/creditcard.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(300, 260, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label6 = new JLabel(imageIcon3);
        label6.setBounds(5, 10, 390, 360);
        add(label6);

        label1 = new JLabel("We're excited to have you get started. ");
        label1.setFont(new Font("Oswald", Font.PLAIN, 20));
        label1.setBounds(380, 200, 600, 25);
        add(label1);

        label2 = new JLabel("First, you need to confirm your account. ");
        label2.setFont(new Font("Oswald", Font.PLAIN, 20));
        label2.setBounds(380, 220, 600, 25);
        add(label2);

        label3 = new JLabel("Just press the button below. ");
        label3.setFont(new Font("Oswald", Font.PLAIN, 20));
        label3.setBounds(380, 240, 600, 25);
        add(label3);

        label4 = new JLabel("WELCOME!");
        label4.setForeground(new Color(254, 100, 45));
        label4.setFont(new Font("", Font.PLAIN, 40));
        label4.setBounds(380, 100, 500, 50);
        add(label4);

        label5 = new JLabel("_____________________________");
        label5.setForeground(new Color(254, 100, 45));
        label5.setFont(new Font("Oswald", Font.BOLD, 20));
        label5.setBounds(380, 130, 600, 25);
        add(label5);

        button1 = new JButton("CONFIRM ACCOUNT");
        //button1.setBackground(Color.ORANGE);
        button1.setBackground(new Color(255, 153, 0));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 17));
        button1.setBounds(500, 290, 200, 35);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CANCEL");
        //button2.setBackground(Color.ORANGE);
        button2.setBackground(new Color(255, 153, 0));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 17));
        button2.setBounds(380, 290, 110, 35);
        button2.addActionListener(this);
        add(button2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        //setBackground(new Color(180, 148, 79));
        setLocation(300, 250);
        setUndecorated(true);
        setSize(800, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {     //confirm account
            new Deposit(pin).setVisible(true);     //deposit
            setVisible(false);
        }

        if (e.getSource() == button2) {     //previous
            //new Signup3().setVisible(true);
            setVisible(false);
        }

    }

    public static void main(String[] args) {

        new Signup4("").setVisible(true);
    }
}
