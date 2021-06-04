package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel label1, label2, underline, label3;
    JButton button1, button2;
    //JTextField textField1;

    String pin;


    BalanceEnquiry(String pin){

        this.pin = pin;

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("BALANCE ENQUIRY");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "BALANCE ENQUIRY");


        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label3 = new JLabel(imageIcon3);
        label3.setBounds(20, 0, 100, 100);
        add(label3);

        label1 = new JLabel("BALANCE ENQUIRY");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 25));
        label1.setBounds(250, 0, 600, 90);
        add(label1);

        underline = new JLabel("_______________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(150, 0, 700, 95);
        add(underline);

        //pin
        /*label3 = new JLabel("Please enter your PIN:");
        //label2.setForeground(new Color(254, 100, 45));
        label3.setFont(new Font("Raleway", Font.BOLD, 18));
        label3.setBounds(50, 100, 600, 50);
        add(label3);

        textField1 = new JTextField(20);
        textField1.setFont(new Font("Arial", Font.BOLD, 19));
        textField1.setBounds(150, 110, 100, 30);
        add(textField1);*/

        button1 = new JButton("BACK TO TRANSACTIONS");
        button1.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setBounds(220, 230, 250, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("EXIT");
        button2.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setBounds(220, 270, 250, 30);
        button2.addActionListener(this);
        add(button2);

        label2 = new JLabel();
        //label2.setForeground(new Color(254, 100, 45));
        label2.setFont(new Font("Arial", Font.PLAIN, 22));
        label2.setBounds(150, 100, 600, 90);
        add(label2);

        //String pin = textField1.getText();

        int balance = 0;

        try{
            Bank connection1 = new Bank();
            ResultSet resultSet = connection1.statement.executeQuery("select * from transaction where pin = '"+pin+"'");

            while (resultSet.next()) {
                if (resultSet.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch(Exception e1){
            e1.printStackTrace();
        }

        label2.setText("Your Current Account Balance is Rs " + balance);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(400, 70);
        setUndecorated(true);
        setSize(700, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        if (e.getSource()==button2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

}
