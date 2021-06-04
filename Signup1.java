package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Signup1 extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, underline;
    JButton button1, button2;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9;
    JRadioButton male, female, other1, married, unmarried, other2;
    JComboBox comboBox1, comboBox2, comboBox3;

    Random random = new Random();
    long first4 = (random.nextLong() % 1000L) + 9000L;
    String first = "" + Math.abs(first4);

    Signup1() {

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("NEW ACCOUNT APPLICATION FORM");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "NEW ACCOUNT APPLICATION FORM");


        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label17 = new JLabel(imageIcon3);
        label17.setBounds(0, 0, 90, 90);
        add(label17);


        label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 27));
        label1.setBounds(140, 0, 600, 90);
        add(label1);

        underline = new JLabel("______________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(90, 0, 600, 100);
        add(underline);

        label2 = new JLabel("Section 1: Personal Details");
        label2.setFont(new Font("Raleway", Font.BOLD, 19));
        label2.setBounds(200, 63, 400, 40);
        add(label2);

        label16 = new JLabel("Name :");
        label16.setFont(new Font("Raleway", Font.BOLD, 20));
        label16.setBounds(70, 110, 200, 50);
        add(label16);

        label3 = new JLabel("Phone Number :");
        label3.setFont(new Font("Raleway", Font.BOLD, 20));
        label3.setBounds(70, 150, 200, 50);
        add(label3);

        label4 = new JLabel("Father's Name :");
        label4.setFont(new Font("Raleway", Font.BOLD, 20));
        label4.setBounds(70, 190, 200, 50);
        add(label4);

        label5 = new JLabel("Date of Birth :");
        label5.setFont(new Font("Raleway", Font.BOLD, 20));
        label5.setBounds(70, 230, 200, 50);
        add(label5);

        label6 = new JLabel("Gender :");
        label6.setFont(new Font("Raleway", Font.BOLD, 20));
        label6.setBounds(70, 270, 200, 50);
        add(label6);

        label7 = new JLabel("Email Address :");
        label7.setFont(new Font("Raleway", Font.BOLD, 20));
        label7.setBounds(70, 310, 200, 50);
        add(label7);

        label8 = new JLabel("Marital Status :");
        label8.setFont(new Font("Raleway", Font.BOLD, 20));
        label8.setBounds(70, 350, 200, 50);
        add(label8);

        label9 = new JLabel("Address :");
        label9.setFont(new Font("Raleway", Font.BOLD, 20));
        label9.setBounds(70, 390, 200, 50);
        add(label9);

        label10 = new JLabel("District :");
        label10.setFont(new Font("Raleway", Font.BOLD, 20));
        label10.setBounds(70, 430, 200, 50);
        add(label10);

        label11 = new JLabel("Pin Code :");
        label11.setFont(new Font("Raleway", Font.BOLD, 20));
        label11.setBounds(70, 470, 200, 50);
        add(label11);

        label12 = new JLabel("State :");
        label12.setFont(new Font("Raleway", Font.BOLD, 20));
        label12.setBounds(70, 510, 200, 50);
        add(label12);

        label18 = new JLabel("Country :");
        label18.setFont(new Font("Raleway", Font.BOLD, 20));
        label18.setBounds(70, 550, 200, 50);
        add(label18);

        button1 = new JButton("NEXT");
        button1.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setBounds(520, 635, 110, 30);
        button1.addActionListener(this);
        add(button1);

        //exit
        button2 = new JButton("EXIT");
        button2.setBackground(new Color(255, 153, 0));
        //button1.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setBounds(70, 635, 110, 30);
        button2.addActionListener(this);
        add(button2);

        //phone number
        textField8 = new JTextField(50);
        textField8.setFont(new Font("Arial", Font.BOLD, 15));
        textField8.setBounds(260, 125, 370, 25);
        add(textField8);

        //name
        textField1 = new JTextField(50);
        textField1.setFont(new Font("Arial", Font.BOLD, 15));
        textField1.setBounds(260, 165, 370, 25);
        add(textField1);

        //Father's name
        textField2 = new JTextField(50);
        textField2.setFont(new Font("Arial", Font.BOLD, 15));
        textField2.setBounds(260, 205, 370, 25);
        add(textField2);

        //Date of Birth
        label13 = new JLabel("Date");
        label13.setFont(new Font("Arial", Font.PLAIN, 15));
        label13.setBounds(260, 245, 50, 20);
        add(label13);

        String date[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        comboBox1 =new JComboBox(date);
        comboBox1.setBounds(300, 245,50,20);
        add(comboBox1);

        label14 = new JLabel("Month");
        label14.setFont(new Font("Arial", Font.PLAIN, 15));
        label14.setBounds(365, 245, 50, 20);
        add(label14);

        String month[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        comboBox2 =new JComboBox(month);
        comboBox2.setBounds(415, 245,100,20);
        add(comboBox2);

        label15 = new JLabel("Year");
        label15.setFont(new Font("Arial", Font.PLAIN, 15));
        label15.setBounds(525, 245, 50, 20);
        add(label15);

        ArrayList<String> years_tmp = new ArrayList<String>();
        for(int years = 1950; years<= Calendar.getInstance().get(Calendar.YEAR); years++) {
            years_tmp.add(years+"");
        }
        comboBox3 =new JComboBox(years_tmp.toArray());
        comboBox3.setBounds(565, 245,65,20);
        add(comboBox3);

        //gender
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.PLAIN, 15));
        male.setBackground(Color.WHITE);
        male.setBounds(260, 288, 70, 20);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.PLAIN, 15));
        female.setBackground(Color.WHITE);
        female.setBounds(400, 288, 80, 20);
        add(female);

        other1 = new JRadioButton("Other");
        other1.setFont(new Font("Raleway", Font.PLAIN, 15));
        other1.setBackground(Color.WHITE);
        other1.setBounds(550, 288, 70, 20);
        add(other1);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(male);
        groupgender.add(female);
        groupgender.add(other1);

        //marital status
        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.PLAIN, 15));
        married.setBackground(Color.WHITE);
        married.setBounds(260, 365, 100, 20);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.PLAIN, 15));
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(400, 365, 100, 20);
        add(unmarried);

        other2 = new JRadioButton("Other");
        other2.setFont(new Font("Raleway", Font.PLAIN, 15));
        other2.setBackground(Color.WHITE);
        other2.setBounds(550, 365, 70, 20);
        add(other2);

        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(married);
        groupstatus.add(unmarried);
        groupstatus.add(other2);

        //email address
        textField3 = new JTextField(50);
        textField3.setFont(new Font("Arial", Font.BOLD, 15));
        textField3.setBounds(260, 325, 370, 25);
        add(textField3);

        //Address
        textField4 = new JTextField(50);
        textField4.setFont(new Font("Arial", Font.BOLD, 15));
        textField4.setBounds(260, 405, 370, 25);
        add(textField4);

        //District
        textField5 = new JTextField(50);
        textField5.setFont(new Font("Arial", Font.BOLD, 15));
        textField5.setBounds(260, 447, 370, 25);
        add(textField5);

        //pin code
        textField6 = new JTextField(50);
        textField6.setFont(new Font("Arial", Font.BOLD, 15));
        textField6.setBounds(260, 487, 370, 25);
        add(textField6);

        //State
        textField7 = new JTextField(50);
        textField7.setFont(new Font("Arial", Font.BOLD, 15));
        textField7.setBounds(260, 525, 370, 25);
        add(textField7);

        //country
        textField9 = new JTextField(50);
        textField9.setFont(new Font("Arial", Font.BOLD, 15));
        textField9.setBounds(260, 567, 370, 25);
        add(textField9);


        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setUndecorated(true);
        setLocation(400, 70);
        setSize(700, 700);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = textField8.getText();
        String phone = textField1.getText();
        String father = textField2.getText();
        String formNum = first;

        String date = (String)comboBox1.getSelectedItem();
        String month = (String)comboBox2.getSelectedItem();
        String year = (String)comboBox3.getSelectedItem();

        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }else if (other1.isSelected()){
            gender = "Other";
        }

        String email = textField3.getText();

        String maritalStatus = null;
        if (married.isSelected()){
            maritalStatus = "Married";
        }else if (unmarried.isSelected()){
            maritalStatus = "Unmarried";
        }else if (other2.isSelected()){
            maritalStatus = "Other";
        }

        String address = textField4.getText();
        String district = textField5.getText();
        String pinCode = textField6.getText();
        String state = textField7.getText();

        try{

            if (e.getSource() == button1) {
                if (textField6.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required credentials!");
                } else {
                    Bank connection1 = new Bank();
                    String query1 = "insert into signup1 values('" + name + "','" + phone + "','" + father + "','" + date + "','" + month + "','" + year + "','" + gender + "','" + email + "','" + maritalStatus + "','" + address + "','" + district + "','" + pinCode + "','" + state + "','" + formNum + "')";
                    connection1.statement.executeUpdate(query1);

                    new Signup2(first).setVisible(true);
                    setVisible(false);
                }
            }
            if (e.getSource() == button2){
                System.exit(0);
            }
        }catch (Exception e1){
            e1.printStackTrace();
            System.out.println(e1);
        }

    }

    public static void main(String[] args){
        new Signup1().setVisible(true);
    }
}
