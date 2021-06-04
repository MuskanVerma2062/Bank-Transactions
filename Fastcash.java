package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JLabel label1, label2, underline, label3, label4;
    JButton button1, button2, button3, button4, button5, button6, button7, button8;
    JPasswordField textField1;

    String pin;

    Fastcash(String pin){

        this.pin = pin;

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("FAST CASH");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "FAST CASH");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/withdrawal2.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(300, 260, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label3 = new JLabel(imageIcon3);
        label3.setBounds(0, 150, 390, 360);
        add(label3);


        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon5 = imageIcon4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon6 = new ImageIcon(imageIcon5);
        label4 = new JLabel(imageIcon6);
        label4.setBounds(0, 0, 90, 90);
        add(label4);


        label1 = new JLabel("SELECT YOUR WITHDRAWAL AMOUNT TO PROCEED");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 20));
        label1.setBounds(100, 0, 600, 90);
        add(label1);

        underline = new JLabel("_________________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(100, 0, 700, 100);
        add(underline);

        label2 = new JLabel("Enter PIN:");
        //label2.setForeground(new Color(254, 100, 45));
        label2.setFont(new Font("Raleway", Font.BOLD, 18));
        label2.setBounds(100, 100, 600, 50);
        add(label2);

        textField1 = new JPasswordField(20);
        textField1.setFont(new Font("Arial", Font.BOLD, 19));
        textField1.setBounds(200, 110, 100, 30);
        add(textField1);


        //100
        button1 = new JButton("Rs. 100");
        button1.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setBounds(390, 100, 250, 40);
        button1.addActionListener(this);
        add(button1);

        //500
        button2 = new JButton("Rs. 500");
        button2.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        button2.setBounds(390, 160, 250, 40);
        button2.addActionListener(this);
        add(button2);

        //1000
        button3 = new JButton("Rs. 1,000");
        button3.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        button3.setBounds(390, 220, 250, 40);
        button3.addActionListener(this);
        add(button3);

        //20,000
        button4 = new JButton("Rs. 2,000");
        button4.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button4.setForeground(Color.WHITE);
        button4.setFont(new Font("Arial", Font.BOLD, 20));
        button4.setBounds(390, 280, 250, 40);
        button4.addActionListener(this);
        add(button4);

        //50,000
        button5 = new JButton("Rs. 5,000");
        button5.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button5.setForeground(Color.WHITE);
        button5.setFont(new Font("Arial", Font.BOLD, 20));
        button5.setBounds(390, 340, 250, 40);
        button5.addActionListener(this);
        add(button5);

        //1,00,000
        button6 = new JButton("Rs. 10,000");
        button6.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button6.setForeground(Color.WHITE);
        button6.setFont(new Font("Arial", Font.BOLD, 20));
        button6.setBounds(390, 400, 250, 40);
        button6.addActionListener(this);
        add(button6);

        //transactions
        button7 = new JButton("TRANSACTIONS");
        button7.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button7.setForeground(Color.WHITE);
        button7.setFont(new Font("Arial", Font.BOLD, 20));
        button7.setBounds(390, 460, 250, 40);
        button7.addActionListener(this);
        add(button7);

        //exit
        button8 = new JButton("EXIT");
        button8.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button8.setForeground(Color.WHITE);
        button8.setFont(new Font("Arial", Font.BOLD, 20));
        button8.setBounds(390, 520, 250, 40);
        button8.addActionListener(this);
        add(button8);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(400, 70);
        setUndecorated(true);
        setSize(700, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            

            //String pin = textField1.getText();
            double balance = 0;

            if (e.getSource()==button1){                //100

                Bank connection1 = new Bank();
                ResultSet resultSet = connection1.statement.executeQuery("select * from bank where pin = '"+pin+"' ");

                if (resultSet.next()){
                    String pinNum = resultSet.getString("pin");
                    balance = resultSet.getDouble("balance");

                    balance -= 100;

                    //String query1 = "insert into transaction (pin, mode, balance, withdraw) values('"+pinNum+"', 'withdraw', '"+balance+"', 100)";
                    String query1 = "insert into bank values('"+pinNum+"', null, 100, '"+balance+"')";
                    connection1.statement.executeUpdate(query1);
                }

                JOptionPane.showMessageDialog(null, "Rs. 100 debited successfully!");

                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
            else if (e.getSource()==button2){                //500

                Bank connection1 = new Bank();
                ResultSet resultSet = connection1.statement.executeQuery("select * from bank where pin = '"+pin+"' ");

                if (resultSet.next()){
                    String pinNum = resultSet.getString("pin");
                    balance = resultSet.getDouble("balance");

                    balance -= 500;
                    //String query1 = "insert into transaction (pin, mode, balance, withdraw) values('"+pinNum+"', 'withdraw', '"+balance+"', 500)";
                    String query1 = "insert into bank values('"+pinNum+"', null, 500, '"+balance+"')";
                    connection1.statement.executeUpdate(query1);
                }

                JOptionPane.showMessageDialog(null, "Rs. 500 debited successfully!");

                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
            else if (e.getSource()==button3){                //1000

                Bank connection1 = new Bank();
                ResultSet resultSet = connection1.statement.executeQuery("select * from bank where pin = '"+pin+"' ");

                if (resultSet.next()){
                    String pinNum = resultSet.getString("pin");
                    balance = resultSet.getDouble("balance");

                    balance -= 1000;
                    //String query1 = "insert into transaction (pin, mode, balance, withdraw) values('"+pinNum+"', 'withdraw', '"+balance+"', 1000)";
                    String query1 = "insert into bank values('"+pinNum+"', null, 1000, '"+balance+"')";
                    connection1.statement.executeUpdate(query1);
                }

                JOptionPane.showMessageDialog(null, "Rs. 1000 debited successfully!");

                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
            else if (e.getSource()==button4){                //2000

                Bank connection1 = new Bank();
                ResultSet resultSet = connection1.statement.executeQuery("select * from bank where pin = '"+pin+"' ");

                if (resultSet.next()){
                    String pinNum = resultSet.getString("pin");
                    balance = resultSet.getDouble("balance");

                    balance -= 2000;
                    //String query1 = "insert into transaction (pin, mode, balance, withdraw) values('"+pinNum+"', 'withdraw', '"+balance+"', 2000)";
                    String query1 = "insert into bank values('"+pinNum+"', null, 2000, '"+balance+"')";
                    connection1.statement.executeUpdate(query1);
                }

                JOptionPane.showMessageDialog(null, "Rs. 2000 debited successfully!");

                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
            else if (e.getSource()==button5){                //5000

                Bank connection1 = new Bank();
                ResultSet resultSet = connection1.statement.executeQuery("select * from bank where pin = '"+pin+"' ");

                if (resultSet.next()){
                    String pinNum = resultSet.getString("pin");
                    balance = resultSet.getDouble("balance");

                    balance -= 5000;
                    //String query1 = "insert into transaction (pin, mode, balance, withdraw) values('"+pinNum+"', 'withdraw', '"+balance+"', 5000)";
                    String query1 = "insert into bank values('"+pinNum+"', null, 5000, '"+balance+"')";
                    connection1.statement.executeUpdate(query1);
                }

                JOptionPane.showMessageDialog(null, "Rs. 5000 debited successfully!");

                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
            else if (e.getSource()==button6){                //10,000

                Bank connection1 = new Bank();
                ResultSet resultSet = connection1.statement.executeQuery("select * from bank where pin = '"+pin+"' ");

                if (resultSet.next()){
                    String pinNum = resultSet.getString("pin");
                    balance = resultSet.getDouble("balance");

                    balance -= 10000;
                    //String query1 = "insert into transaction (pin, mode, balance, withdraw) values('"+pinNum+"', 'withdraw', '"+balance+"', 10000)";
                    String query1 = "insert into bank values('"+pinNum+"', null, 10000, '"+balance+"')";
                    connection1.statement.executeUpdate(query1);
                }

                JOptionPane.showMessageDialog(null, "Rs. 10,000 debited successfully!");

                new Transactions(pin).setVisible(true);
                setVisible(false);
            }

            else if (e.getSource()==button7){            //transactions
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
            else if (e.getSource()==button8){            //exit
                System.exit(0);
            }

        }catch (Exception e1) {
            e1.printStackTrace();
            System.out.println(e1);
        }

            /*String amount = ((JButton) e.getSource()).getText().substring(3);
            Bank connection1 = new Bank();
            ResultSet resultSet = connection1.statement.executeQuery("select * from transaction where pin = '" + pin + "'");
            int balance = 0;
            while (resultSet.next()) {
                if (resultSet.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            String num = "17";
            if (e.getSource() != button8 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (e.getSource() == button7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            } else {
                Date date = new Date();
                connection1.statement.executeUpdate("insert into transaction values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);
            }*/

        }


    public static void main(String[] args) {
        new Fastcash("").setVisible(true);
    }
}

