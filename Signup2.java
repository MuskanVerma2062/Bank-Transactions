package BankTransactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, underline;
    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    JTextField textField1, textField2, textField3, textField4, textField5;
    JButton button1, button2;
    JComboBox comboBox1, comboBox2, comboBox3, comboBox4;
    String formNum;

    Signup2(String formNum){

        this.formNum = formNum;

        setFont(new Font("System", Font.BOLD, 22));
        Font font = getFont();
        FontMetrics fontMetrics = getFontMetrics(font);
        int x = fontMetrics.stringWidth("ACCOUNT APPLICATION FORM Page 2");
        int y = fontMetrics.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "ACCOUNT APPLICATION FORM Page 2");


        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/banklogo1.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label15 = new JLabel(imageIcon3);
        label15.setBounds(0, 0, 90, 90);
        add(label15);


        label1 = new JLabel("APPLICATION FORM DETAILS");
        label1.setForeground(new Color(254, 100, 45));
        label1.setFont(new Font("Oswald", Font.BOLD, 27));
        label1.setBounds(160, 0, 600, 90);
        add(label1);

        underline = new JLabel("_______________________________");
        underline.setForeground(new Color(254, 100, 45));
        underline.setFont(new Font("Raleway", Font.PLAIN, 30));
        underline.setBounds(90, 0, 600, 100);
        add(underline);

        label2 = new JLabel("Section 2: Additional Details");
        label2.setFont(new Font("Raleway", Font.BOLD, 19));
        label2.setBounds(200, 63, 400, 40);
        add(label2);

        label12 = new JLabel("Enter your Form Number:");
        label12.setFont(new Font("Raleway", Font.BOLD, 20));
        label12.setBounds(70, 530, 400, 50);
        add(label12);

        //form number
        textField1 = new JTextField();
        textField1.setFont(new Font("Arial", Font.BOLD, 15));
        textField1.setBounds(330, 545, 300, 25);
        add(textField1);

        label14 = new JLabel("Driving Licence No. :");
        label14.setFont(new Font("Raleway", Font.BOLD, 20));
        label14.setBounds(70, 110, 200, 50);
        add(label14);

        label3 = new JLabel("Religion :");
        label3.setFont(new Font("Raleway", Font.BOLD, 20));
        label3.setBounds(70, 150, 200, 50);
        add(label3);

        label4 = new JLabel("Catagory :");
        label4.setFont(new Font("Raleway", Font.BOLD, 20));
        label4.setBounds(70, 190, 200, 50);
        add(label4);

        label5 = new JLabel("Income :");
        label5.setFont(new Font("Raleway", Font.BOLD, 20));
        label5.setBounds(70, 230, 200, 50);
        add(label5);

        label6 = new JLabel("Educational Qualifications :");
        label6.setFont(new Font("Raleway", Font.BOLD, 20));
        label6.setBounds(70, 270, 300, 50);
        add(label6);

        label7 = new JLabel("Occupation :");
        label7.setFont(new Font("Raleway", Font.BOLD, 20));
        label7.setBounds(70, 310, 200, 50);
        add(label7);

        label8 = new JLabel("PAN Number :");
        label8.setFont(new Font("Raleway", Font.BOLD, 20));
        label8.setBounds(70, 350, 200, 50);
        add(label8);

        label9 = new JLabel("Aadhar Number :");
        label9.setFont(new Font("Raleway", Font.BOLD, 20));
        label9.setBounds(70, 390, 200, 50);
        add(label9);

        label10 = new JLabel("Senior Citizen :");
        label10.setFont(new Font("Raleway", Font.BOLD, 20));
        label10.setBounds(70, 430, 200, 50);
        add(label10);

        label13 = new JLabel("(Are you above 60?)");
        label13.setFont(new Font("Raleway", Font.ITALIC, 15));
        label13.setBounds(70, 460, 200, 30);
        add(label13);

        label11 = new JLabel("Existing Account :");
        label11.setFont(new Font("Raleway", Font.BOLD, 20));
        label11.setBounds(70, 480, 200, 50);
        add(label11);

        button1 = new JButton("NEXT");
        //button1.setBackground(Color.BLACK);
        button1.setBackground(new Color(255, 153, 0));
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setBounds(520, 635, 110, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("EXIT");
        //button2.setBackground(Color.BLACK);
        button2.setBackground(new Color(255, 153, 0));
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setBounds(70, 635, 110, 30);
        button2.addActionListener(this);
        add(button2);

        //Driving Licence no.
        textField5 = new JTextField();
        textField5.setFont(new Font("Arial", Font.BOLD, 15));
        textField5.setBounds(280, 125, 350, 25);
        add(textField5);

        //religion
        textField2 = new JTextField();
        textField2.setFont(new Font("Arial", Font.BOLD, 15));
        textField2.setBounds(280, 163, 350, 25);
        add(textField2);

        //category
        String category[] = {"General", "OBC", "SC", "ST", "Others"};
        comboBox1 = new JComboBox(category);
        comboBox1.setBounds(280, 204, 350, 25);
        add(comboBox1);

        //income
        String income[] = {"Null", "> 1,00,000", "1,00,000 to 2,50,000", "2,50,000 to 5,00,000", "above 5,00,000"};
        comboBox2 = new JComboBox(income);
        comboBox2.setBounds(280, 244, 350, 25);
        add(comboBox2);

        //educational qualifications
        String eduInfo[] = {"Non Graduate", "Graduate", "Post Graduate", "Doctorate", "Others"};
        comboBox3 = new JComboBox(eduInfo);
        comboBox3.setBounds(345, 284, 285, 25);
        add(comboBox3);

        //occupation
        String occupation[] = {"Student", "Business", "Employed", "Retired", "Others"};
        comboBox4 = new JComboBox(occupation);
        comboBox4.setBounds(280, 324, 350, 25);
        add(comboBox4);

        //PAN Number
        textField3 = new JTextField();
        textField3.setFont(new Font("Arial", Font.BOLD, 15));
        textField3.setBounds(280, 365, 350, 25);
        add(textField3);

        //aadhar number
        textField4 = new JTextField();
        textField4.setFont(new Font("Arial", Font.BOLD, 15));
        textField4.setBounds(280, 405, 350, 25);
        add(textField4);

        //senior citizen
        radioButton1 = new JRadioButton("Yes");
        radioButton1.setFont(new Font("Raleway", Font.PLAIN, 15));
        radioButton1.setBackground(Color.WHITE);
        radioButton1.setBounds(280, 450, 100, 20);
        add(radioButton1);

        radioButton2 = new JRadioButton("No");
        radioButton2.setFont(new Font("Raleway", Font.PLAIN, 15));
        radioButton2.setBackground(Color.WHITE);
        radioButton2.setBounds(450, 450, 100, 20);
        add(radioButton2);

        //existing account
        radioButton3 = new JRadioButton("Yes");
        radioButton3.setFont(new Font("Raleway", Font.PLAIN, 15));
        radioButton3.setBackground(Color.WHITE);
        radioButton3.setBounds(280, 498, 100, 20);
        add(radioButton3);

        radioButton4 = new JRadioButton("No");
        radioButton4.setFont(new Font("Raleway", Font.PLAIN, 15));
        radioButton4.setBackground(Color.WHITE);
        radioButton4.setBounds(450, 498, 100, 20);
        add(radioButton4);


        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setUndecorated(true);
        setLocation(400, 70);
        setSize(700, 700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //String formNum = textField1.getText();
        String driving = textField5.getText();
        String religion = textField2.getText();

        String category = (String)comboBox1.getSelectedItem();
        String income = (String)comboBox2.getSelectedItem();
        String education = (String)comboBox3.getSelectedItem();
        String occupation = (String)comboBox4.getSelectedItem();

        String panNum = textField3.getText();
        String aadharNum = textField4.getText();

        String seniorCitizen = null;
        if (radioButton1.isSelected()){
            seniorCitizen = "Yes";
        }else if (radioButton2.isSelected()){
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if (radioButton3.isSelected()){
            existingAccount = "Yes";
        }else if (radioButton4.isSelected()){
            existingAccount = "No";
        }


        try{

            if (e.getSource() == button1) {     //next

                if (textField4.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required credentials!");
                } else {
                    Bank connection1 = new Bank();
                    String query1 = "insert into signup2 values('" + formNum + "','" + driving + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + panNum + "','" + aadharNum + "','" + seniorCitizen + "','" + existingAccount + "')";
                    connection1.statement.executeUpdate(query1);

                    new Signup3(formNum).setVisible(true);
                    setVisible(false);

                }
            }
            if (e.getSource() == button2) {     //EXIT
                System.exit(0);
            }
        }catch (Exception e1){
            e1.printStackTrace();
            System.out.println(e1);
        }

    }

    public static void main(String[] args){
        new Signup2("").setVisible(true);
    }
}
