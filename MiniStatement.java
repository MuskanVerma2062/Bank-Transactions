package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JLabel label1, label2, underline, label3, label4, label5;
    JButton button1, button2;
    //String pin;

    MiniStatement(String pin){

        //this.pin = pin;

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("MINI STATEMENT");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "MINI STATEMENT");


        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label2 = new JLabel(imageIcon3);
        label2.setBounds(20, 0, 100, 100);
        add(label2);

        label1 = new JLabel("MINI STATEMENT");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 25));
        label1.setBounds(270, 0, 600, 90);
        add(label1);

        underline = new JLabel("_______________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(150, 0, 700, 95);
        add(underline);


        label3 = new JLabel();
        //label2.setForeground(new Color(254, 100, 45));
        label3.setFont(new Font("Arial", Font.PLAIN, 20));
        label3.setBounds(150, 45, 800, 90);
        add(label3);

        label4 = new JLabel();
        //label2.setForeground(new Color(254, 100, 45));
        label4.setFont(new Font("Arial", Font.PLAIN, 15));
        label4.setBounds(150, 150, 800, 100);
        add(label4);

        label5 = new JLabel();
        //label2.setForeground(new Color(254, 100, 45));
        label5.setFont(new Font("Arial", Font.PLAIN, 20));
        label5.setBounds(150, 70, 800, 90);
        add(label5);


        button1 = new JButton("BACK TO TRANSACTIONS");
        button1.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setBounds(220, 280, 250, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("EXIT");
        button2.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setBounds(220, 320, 250, 30);
        button2.addActionListener(this);
        add(button2);


        try{
            Bank connection = new Bank();
            ResultSet resultSet = connection.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while(resultSet.next()){
                label3.setText("Card Number:    " + resultSet.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + resultSet.getString("cardNumber").substring(12));
            }
        }catch(Exception e1){
            //e1.printStackTrace();
        }


        try{
            int balance = 0;
            Bank connection1  = new Bank();
            ResultSet resultSet = connection1.statement.executeQuery("SELECT * FROM transaction where pin = '"+pin+"'");
            while(resultSet.next()){
                label4.setText(label4.getText() + "<html>"+resultSet.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");
                if(resultSet.getString("mode").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label5.setText("Your total Balance is Rs " + balance);
        }catch(Exception e){
            e.printStackTrace();
        }


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(400, 70);
        setUndecorated(true);
        setSize(700, 400);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1){
            this.setVisible(false);
            //new Transactions(pin).setVisible(true);
        }
        if (e.getSource()==button2){
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }

}
