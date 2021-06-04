package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Transactions extends JFrame implements ActionListener {

    JLabel label1, underline, label2, label3, label4;
    JButton button1, button2, button3, button4, button5, button6, button7;
    String pin;
    //int balance = 0;

    Transactions(String pin){

        this.pin = pin;

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("TRANSACTIONS");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "TRANSACTIONS");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/man-holding-big-credit-card.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(300, 260, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label2 = new JLabel(imageIcon3);
        label2.setBounds(0, 100, 390, 360);
        add(label2);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        label4 = new JLabel(imageIcon6);
        label4.setBounds(0, 0, 90, 90);
        add(label4);

        label3 = new JLabel("Fast and Secure Transactions!");
        label3.setFont(new Font("Arial",Font.ITALIC, 22));
        label3.setBounds(50, 440, 600, 90);
        add(label3);


        label1 = new JLabel("SELECT YOUR TRANSACTION TO PROCEED");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 22));
        label1.setBounds(100, 0, 600, 90);
        add(label1);

        underline = new JLabel("__________________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(100, 0, 700, 100);
        add(underline);


        //deposit
        button1 = new JButton("DEPOSIT");
        button1.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setBounds(390, 100, 250, 40);
        button1.addActionListener(this);
        add(button1);

        //Cash withdrawal
        button2 = new JButton("CASH WITHDRAWAL");
        button2.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        button2.setBounds(390, 160, 250, 40);
        button2.addActionListener(this);
        add(button2);

        //fast cash (neft)
        button3 = new JButton("FAST CASH");
        button3.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        button3.setBounds(390, 220, 250, 40);
        button3.addActionListener(this);
        add(button3);

        //mini statement
        button4 = new JButton("MINI STATEMENT");
        button4.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button4.setForeground(Color.WHITE);
        button4.setFont(new Font("Arial", Font.BOLD, 20));
        button4.setBounds(390, 280, 250, 40);
        button4.addActionListener(this);
        add(button4);

        //pin change
        button5 = new JButton("PIN CHANGE");
        button5.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button5.setForeground(Color.WHITE);
        button5.setFont(new Font("Arial", Font.BOLD, 20));
        button5.setBounds(390, 340, 250, 40);
        button5.addActionListener(this);
        add(button5);

        //balance enquiry
        button6 = new JButton("BALANCE ENQUIRY");
        button6.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button6.setForeground(Color.WHITE);
        button6.setFont(new Font("Arial", Font.BOLD, 20));
        button6.setBounds(390, 400, 250, 40);
        button6.addActionListener(this);
        add(button6);

        //exit
        button7 = new JButton("EXIT");
        button7.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button7.setForeground(Color.WHITE);
        button7.setFont(new Font("Arial", Font.BOLD, 20));
        button7.setBounds(390, 460, 250, 40);
        button7.addActionListener(this);
        add(button7);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(400, 70);
        setUndecorated(true);
        setSize(700, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1){                //deposit
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if (e.getSource() == button2) {
            setVisible(false);
            new Withdrawal(pin).setVisible(true);     //cash withdrawal
        }
        else if (e.getSource() == button3) {
            setVisible(false);
            new Fastcash(pin).setVisible(true);     //fast cash
        }
        else if (e.getSource() == button4) {
            //setVisible(false);
            new MiniStatement(pin).setVisible(true);     //mini statement
        }
        else if (e.getSource() == button5) {
            setVisible(false);
            new Pin(pin).setVisible(true);     //pin change
        }
        else if (e.getSource() == button6) {        //balance enquiry

            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);

            /*String pin = JOptionPane.showInputDialog("Enter PIN:");
            Bank connection1 = new Bank();

            try{
                ResultSet resultSet = connection1.statement.executeQuery("SELECT balance FROM bank ORDER BY pin = '"+pin+"' DESC LIMIT 1");
                if (resultSet.next()){
                    String balance = resultSet.getString("balance");
                    JOptionPane.showMessageDialog(null, "Your Account Balance is " + balance);
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
                System.out.println(e1);
            }*/


        }
        else if (e.getSource()==button7){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }

}
