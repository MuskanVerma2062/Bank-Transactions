package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4, label5, underline;
    JPasswordField textField1, textField2, textField3;
    JButton button1, button2, button3;

    String pin;

    Pin(String pin){

        this.pin = pin;

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("PIN CHANGE");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "PIN CHANGE");

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label5 = new JLabel(imageIcon3);
        label5.setBounds(20, 0, 100, 100);
        add(label5);

        label1 = new JLabel("PIN CHANGE");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 25));
        label1.setBounds(280, 0, 600, 90);
        add(label1);

        underline = new JLabel("_____________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(150, 0, 700, 100);
        add(underline);

        //current pin
        label2 = new JLabel("Enter your current PIN:");
        //label2.setForeground(new Color(254, 100, 45));
        label2.setFont(new Font("Raleway", Font.BOLD, 19));
        label2.setBounds(150, 100, 600, 50);
        add(label2);

        textField1 = new JPasswordField(20);
        textField1.setFont(new Font("Arial", Font.BOLD, 20));
        textField1.setBounds(380, 110, 160, 30);
        add(textField1);

        //new pin
        label3 = new JLabel("Enter your new PIN:");
        //label2.setForeground(new Color(254, 100, 45));
        label3.setFont(new Font("Raleway", Font.BOLD, 19));
        label3.setBounds(150, 140, 600, 50);
        add(label3);

        textField2 = new JPasswordField(20);
        textField2.setFont(new Font("Arial", Font.BOLD, 20));
        textField2.setBounds(380, 150, 160, 30);
        add(textField2);

        //re enter new pin
        label4 = new JLabel("Re-enter your new PIN:");
        //label2.setForeground(new Color(254, 100, 45));
        label4.setFont(new Font("Raleway", Font.BOLD, 19));
        label4.setBounds(150, 180, 600, 50);
        add(label4);

        textField3 = new JPasswordField(20);
        textField3.setFont(new Font("Arial", Font.BOLD, 20));
        textField3.setBounds(380, 190, 160, 30);
        add(textField3);

        //change pin
        button1 = new JButton("CHANGE PIN");
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

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(400, 70);
        setUndecorated(true);
        setSize(700, 400);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //String currentPin = textField1.getText();
        String newPin = textField2.getText();
        String reEnterPin = textField3.getText();

        try {

            if(!newPin.equals(reEnterPin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (e.getSource() == button1) {

                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter your current PIN");
                }
                if (textField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter your new PIN");
                }
                if (textField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter your new PIN");
                }
                if (textField2.getText().equals(textField3.getText())) {

                    Bank connection1 = new Bank();

                    String query1 = "update bank set pin = '" + reEnterPin + "' where pin = '" + pin + "' ";
                    String query2 = "update login set pin = '" + reEnterPin + "' where pin = '" + pin + "' ";
                    String query3 = "update signup3 set pin = '" + reEnterPin + "' where pin = '" + pin + "' ";

                    connection1.statement.executeUpdate(query1);
                    connection1.statement.executeUpdate(query2);
                    connection1.statement.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully!");
                    setVisible(false);
                    new Transactions(reEnterPin).setVisible(true);
                }

            } else if (e.getSource() == button2) {
                System.exit(0);
            } else if (e.getSource() == button3) {
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        }catch (Exception e1){
            e1.printStackTrace();
            System.out.println(e1);
        }
    }

    public static void main(String[] args) {
        new Pin("").setVisible(true);
    }
}
