package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.sql.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JLabel label1, underline, label2, label3, label4, label5;
    JTextField textField1;
    JPasswordField textField2;
    JButton button1, button2, button3;

    String pin;

    Withdrawal(String pin){

        this.pin = pin;

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("MONEY WITHDRAWAL");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "MONEY WITHDRAWAL");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label5 = new JLabel(imageIcon3);
        label5.setBounds(20, 0, 100, 100);
        add(label5);

        label1 = new JLabel("MONEY WITHDRAWAL");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 25));
        label1.setBounds(200, 0, 600, 90);
        add(label1);

        underline = new JLabel("_____________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(150, 0, 700, 100);
        add(underline);

        label2 = new JLabel("Enter the amount you want to withdraw:");
        //label2.setForeground(new Color(254, 100, 45));
        label2.setFont(new Font("Oswald", Font.BOLD, 20));
        label2.setBounds(150, 150, 600, 50);
        add(label2);

        //pin
        label3 = new JLabel("Enter your PIN:");
        //label2.setForeground(new Color(254, 100, 45));
        label3.setFont(new Font("Oswald", Font.BOLD, 20));
        label3.setBounds(150, 100, 600, 50);
        add(label3);

        textField2 = new JPasswordField(20);
        textField2.setFont(new Font("Arial", Font.BOLD, 20));
        textField2.setBounds(330, 110, 208, 30);
        add(textField2);

        //amount withdraw
        textField1 = new JTextField(20);
        textField1.setFont(new Font("Arial", Font.BOLD, 20));
        textField1.setBounds(150, 200, 390, 30);
        add(textField1);

        //withdraw
        button1 = new JButton("WITHDRAW");
        button1.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setBounds(150, 250, 190, 30);
        button1.addActionListener(this);
        add(button1);

        //exit
        button2 = new JButton("EXIT");
        //button2.setBackground(Color.ORANGE);
        button2.setBackground(new Color(255, 153, 0));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setBounds(350, 250, 190, 30);
        button2.addActionListener(this);
        add(button2);

        //transactions
        button3 = new JButton("TRANSACTIONS");
        //button2.setBackground(Color.ORANGE);
        button3.setBackground(new Color(255, 153, 0));
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Arial", Font.BOLD, 15));
        button3.setBounds(150, 290, 390, 30);
        button3.addActionListener(this);
        add(button3);

        label4 = new JLabel("* Maximum daily withdrawal is Rs. 10,000 *");
        //label4.setForeground(new Color(254, 100, 45));
        label4.setFont(new Font("Arial", Font.PLAIN, 17));
        label4.setBounds(180, 350, 600, 50);
        add(label4);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(400, 70);
        setUndecorated(true);
        setSize(700, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            String amountWithdraw = textField1.getText();
            //String pinCode = textField2.getText();

            Date date = new Date();

            if (e.getSource() == button1) {

                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");    //withdraw
                } else {

                    Bank connection1 = new Bank();
                    //connection1.statement.executeUpdate("insert into transaction values ('"+pinCode+"', '"+date+"', 'Withdrawal', '"+amountWithdraw+"')");

                    /*ResultSet resultSet = connection1.statement.executeQuery("select * from transaction where pin = '"+pin+"'");

                    int balance = 0;

                    while(resultSet.next()){
                        if(resultSet.getString("mode").equals("Deposit")){
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amountWithdraw)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }*/

                    connection1.statement.executeUpdate("insert into transaction values('"+pin+"', '"+date+"', 'Withdrawl', '"+amountWithdraw+"' )");

                    JOptionPane.showMessageDialog(null, "Amount "+amountWithdraw+" Debited Successfully!");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if (e.getSource() == button2) {     //exit
                System.exit(0);
            }
            else if (e.getSource() == button3) {
                new Transactions(pin).setVisible(true);     //more transactions
                setVisible(false);
            }
        }
        catch (Exception e1){
            e1.printStackTrace();
            System.out.println(e1);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("").setVisible(true);
    }
}
