package BankTransactions;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    //global variables
    JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    JTextField textField;
    JPasswordField passwordField;
    JButton button1, button2, button3;


    Login() {
        //super("TRANSACTIONS MANAGEMENT");
        //setTitle("TRANSACTIONS MANAGEMENT");

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("TRANSACTIONS MANAGEMENT");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "TRANSACTIONS MANAGEMENT");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label6 = new JLabel(imageIcon3);
        label6.setBounds(65, 0, 250, 250);
        add(label6);


        label1 = new JLabel("ACCOUNT LOGIN");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("", Font.PLAIN, 28));
        label1.setBounds(430, 55, 400, 50);
        add(label1);

        label5 = new JLabel("______________________________");
        label5.setForeground(new Color(254, 100, 45));
        label5.setFont(new Font("Oswald", Font.BOLD, 20));
        label5.setBounds(380, 80, 600, 25);
        add(label5);

        label2 = new JLabel("Card Number :");
        label2.setFont(new Font("Raleway", Font.PLAIN, 20));
        label2.setBounds(380, 75, 375, 200);
        add(label2);

        label3 = new JLabel("Enter your PIN :");
        label3.setFont(new Font("Raleway", Font.PLAIN, 20));
        label3.setBounds(380, 118, 375, 200);
        add(label3);

        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.BOLD, 15));
        passwordField.setBounds(540, 200, 180, 30);
        add(passwordField);

        textField = new JTextField(15);
        textField.setToolTipText("Enter card number");
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setBounds(540, 160, 180, 30);
        add(textField);

        button1 = new JButton("SIGN IN");
        button1.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setBounds(380, 260, 160, 30);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setBackground(new Color(255, 153, 0));
        //button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setBounds(560, 260, 160, 30);
        add(button2);

        label4 = new JLabel("Don't have an account?");
        label4.setFont(new Font("Arial", Font.ITALIC, 15));
        label4.setBounds(380, 295, 300, 20);
        add(label4);

        button3 = new JButton("SIGN UP");
        button3.setBackground(new Color(255, 153, 0));
        //button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Arial", Font.BOLD, 15));
        button3.setBounds(380, 315, 340, 30);
        add(button3);


        //name and slogan
        label7 = new JLabel("E BANK");
        label7.setFont(new Font("Oswald", Font.BOLD, 50));
        label7.setBounds(90, 250, 375, 70);
        add(label7);

        label8 = new JLabel("Together we Prosper...");
        label8.setFont(new Font("Raleway", Font.ITALIC, 20));
        label8.setBounds(90, 311, 375, 30);
        add(label8);


        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

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

        if (e.getSource() == button3) {     //signup
            new Signup1().setVisible(true);
            setVisible(false);
        }else if (e.getSource()==button2){  //clear
            textField.setText("");
            passwordField.setText("");
        }

        try {

            if (e.getSource()==button1){

                Bank connection1 = new Bank();
                String cardNum = textField.getText();
                String pin = passwordField.getText();
                String query1 = "select * from login where cardNumber = '" + cardNum + "' and pin = '" + pin + "'";
                ResultSet resultSet = connection1.statement.executeQuery(query1);


                if (resultSet.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password!");
                }
            }
        }catch(Exception e1){
            e1.printStackTrace();
            System.out.println("Error : " +e1);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
