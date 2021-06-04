package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, underline;
    JTextField textField1;
    JButton button1, button2;
    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;

    String formNum;

    Signup3(String formNum){

        this.formNum = formNum;

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("ACCOUNT APPLICATION FORM Page 3");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "ACCOUNT APPLICATION FORM Page 3");


        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label13 = new JLabel(imageIcon3);
        label13.setBounds(0, 0, 90, 90);
        add(label13);


        label1 = new JLabel("ACCOUNT DETAILS");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 27));
        label1.setBounds(220, 0, 600, 90);
        add(label1);

        underline = new JLabel("______________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(90, 0, 600, 100);
        add(underline);

        label2 = new JLabel("Card Number :");
        label2.setFont(new Font("Raleway", Font.BOLD, 20));
        label2.setBounds(50, 100, 200, 50);
        add(label2);

        label3 = new JLabel("(Your 16 digit card number)");
        label3.setFont(new Font("Arial", Font.PLAIN, 15));
        label3.setBounds(50, 125, 200, 50);
        add(label3);

        label4 = new JLabel("(It would appear on ATM card, checkbook and statements)");
        label4.setFont(new Font("Raleway", Font.PLAIN, 15));
        label4.setBounds(265, 125, 500, 50);
        add(label4);

        label5 = new JLabel("ATM PIN :");
        label5.setFont(new Font("Raleway", Font.BOLD, 20));
        label5.setBounds(50, 160, 200, 50);
        add(label5);

        label6 = new JLabel("(Your 4 digit pin)");
        label6.setFont(new Font("Arial", Font.PLAIN, 15));
        label6.setBounds(50, 185, 200, 50);
        add(label6);

        label7 = new JLabel("(High security password)");
        label7.setFont(new Font("Raleway", Font.PLAIN, 15));
        label7.setBounds(265, 185, 500, 50);
        add(label7);

        label8 = new JLabel("Account Type :");
        label8.setFont(new Font("Raleway", Font.BOLD, 20));
        label8.setBounds(50, 220, 200, 50);
        add(label8);

        radioButton1 = new JRadioButton("Savings Account");
        radioButton1.setFont(new Font("Raleway", Font.PLAIN, 18));
        radioButton1.setBackground(Color.WHITE);
        radioButton1.setBounds(265, 259, 300, 20);
        add(radioButton1);

        radioButton2 = new JRadioButton("Current Account");
        radioButton2.setFont(new Font("Raleway", Font.PLAIN, 18));
        radioButton2.setBackground(Color.WHITE);
        radioButton2.setBounds(265, 289, 300, 20);
        add(radioButton2);

        radioButton3 = new JRadioButton("Fixed Deposit Account");
        radioButton3.setFont(new Font("Raleway", Font.PLAIN, 18));
        radioButton3.setBackground(Color.WHITE);
        radioButton3.setBounds(265, 319, 300, 20);
        add(radioButton3);

        radioButton4 = new JRadioButton("Recurring Deposit Account");
        radioButton4.setFont(new Font("Raleway", Font.PLAIN, 18));
        radioButton4.setBackground(Color.WHITE);
        radioButton4.setBounds(265, 349, 300, 20);
        add(radioButton4);

        label9 = new JLabel("Services Required :");
        label9.setFont(new Font("Raleway", Font.BOLD, 20));
        label9.setBounds(50, 390, 200, 50);
        add(label9);

        checkBox1 = new JCheckBox("ATM Card");
        checkBox1.setFont(new Font("Raleway", Font.PLAIN, 18));
        checkBox1.setBackground(Color.WHITE);
        checkBox1.setBounds(50, 450, 150, 20);
        add(checkBox1);

        checkBox2 = new JCheckBox("Internet Banking");
        checkBox2.setFont(new Font("Raleway", Font.PLAIN, 18));
        checkBox2.setBackground(Color.WHITE);
        checkBox2.setBounds(230, 450, 200, 20);
        add(checkBox2);

        checkBox3 = new JCheckBox("Mobile Banking");
        checkBox3.setFont(new Font("Raleway", Font.PLAIN, 18));
        checkBox3.setBackground(Color.WHITE);
        checkBox3.setBounds(430, 450, 200, 20);
        add(checkBox3);

        checkBox4 = new JCheckBox("Email Alerts");
        checkBox4.setFont(new Font("Raleway", Font.PLAIN, 18));
        checkBox4.setBackground(Color.WHITE);
        checkBox4.setBounds(50, 480, 150, 20);
        add(checkBox4);

        checkBox5 = new JCheckBox("Cheque Book");
        checkBox5.setFont(new Font("Raleway", Font.PLAIN, 18));
        checkBox5.setBackground(Color.WHITE);
        checkBox5.setBounds(230, 480, 200, 20);
        add(checkBox5);

        checkBox6 = new JCheckBox("E-Statement");
        checkBox6.setFont(new Font("Raleway", Font.PLAIN, 18));
        checkBox6.setBackground(Color.WHITE);
        checkBox6.setBounds(430, 480, 200, 20);
        add(checkBox6);

        //unique card number
        label10 = new JLabel("XXXX XXXX XXXX 4184");
        label10.setFont(new Font("Raleway", Font.BOLD, 20));
        label10.setBounds(265, 100, 400, 50);
        add(label10);

        //4 digit password
        label11 = new JLabel("XXXX");
        label11.setFont(new Font("Raleway", Font.BOLD, 20));
        label11.setBounds(265, 160, 150, 50);
        add(label11);

        //enter form number
        label12 = new JLabel("Enter your form no. :");
        label12.setFont(new Font("Raleway", Font.BOLD, 20));
        label12.setBounds(50, 515, 300, 50);
        add(label12);

        textField1 = new JTextField(10);
        textField1.setFont(new Font("Arial", Font.BOLD, 15));
        textField1.setBounds(265, 530, 250, 23);
        add(textField1);

        //confirmation
        checkBox7 = new JCheckBox("I hereby declare that all previously entered details are correct to the best of my knowledge.", true);
        checkBox7.setFont(new Font("Oswald", Font.BOLD, 13));
        checkBox7.setBackground(Color.WHITE);
        checkBox7.setBounds(50, 590, 700, 20);
        add(checkBox7);


        button1 = new JButton("PROCEED");
        button1.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.ORANGE);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setBounds(520, 635, 110, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("EXIT");
        //button2.setBackground(Color.ORANGE);
        button2.setBackground(new Color(255, 153, 0));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setBounds(50, 635, 110, 30);
        button2.addActionListener(this);
        add(button2);


        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setLocation(400, 70);
        setUndecorated(true);
        setSize(700, 700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        //String formNum = textField1.getText();

        String accountType = null;
        if (radioButton1.isSelected()){
            accountType = "Savings Account";
        }else if (radioButton2.isSelected()){
            accountType = "Current Account";
        }else if (radioButton3.isSelected()){
            accountType = "Fixed Deposit Account";
        }else if (radioButton4.isSelected()){
            accountType = "Recurring Deposit Account";
        }

        Random random = new Random();
        long card = (random.nextLong() % 90000000L) + 5062108000000000L;
        long cardNumber = Math.abs(card);

        long pin = (random.nextLong() % 1000L) + 9000L;
        long pinNumber = Math.abs(pin);

        String servicesRequired = "";
        if (checkBox1.isSelected()){
            servicesRequired = servicesRequired + "  ATM Card";
        }if (checkBox2.isSelected()){
            servicesRequired = servicesRequired + "  Internet Banking";
        }if (checkBox3.isSelected()){
            servicesRequired = servicesRequired + "  Mobile Banking";
        }if (checkBox4.isSelected()){
            servicesRequired = servicesRequired + "  Email Address";
        }if (checkBox5.isSelected()){
            servicesRequired = servicesRequired + "  Cheque Book";
        }if (checkBox6.isSelected()){
            servicesRequired = servicesRequired + "  E-statement";
        }


        try{

            if (e.getSource() == button1) {       //proceed

                if (servicesRequired.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required credentials!");
                } else {
                    Bank connection1 = new Bank();
                    String query1 = "insert into signup3 values('" + cardNumber + "','" + pinNumber + "','" + accountType + "','" + servicesRequired + "','" + formNum + "')";
                    String query2 = "insert into login values('" + cardNumber + "','" + pinNumber + "')";
                    connection1.statement.executeUpdate(query1);
                    connection1.statement.executeUpdate(query2);

                    //JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPIN: " + pinNumber);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPIN: " + pinNumber);
                    new Signup4("").setVisible(true);
                    setVisible(false);
                }
            }

            if (e.getSource()==button2) {       //EXIT
                System.exit(0);
            }

        }catch (Exception e1){
            e1.printStackTrace();
            System.out.println(e1);
        }

    }

    public static void main(String[] args){
        new Signup3("").setVisible(true);
    }
}
