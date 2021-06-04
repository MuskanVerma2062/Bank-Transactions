package BankTransactions;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame {

    JLabel label1, label2, label3, message;
    JProgressBar progressBar;

    Loading(){

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("BankTransactions/icons/intro.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        label1 = new JLabel(imageIcon3);
        label1.setBounds(0, 0, 800, 400);
        add(label1);

        label2 = new JLabel("E BANK");
        label2.setFont(new Font("Oswald", Font.BOLD, 55));
        label2.setBounds(470, 100, 375, 100);
        label1.add(label2);

        label3 = new JLabel("Together we Prosper...");
        label3.setFont(new Font("Raleway", Font.ITALIC, 25));
        label3.setBounds(470, 175, 375, 30);
        label1.add(label3);


        progressBar = new JProgressBar();
        progressBar.setBounds(0,290,800,7);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(new Color(252, 190, 133));
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        label1.add(progressBar);

        message = new JLabel();
        message.setBounds(750,310,50,50);
        message.setForeground(Color.black);
        message.setFont(new Font("arial",Font.BOLD,15));
        label1.add(message);

        /*int i = 0;
        while(i<=100){
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText(Integer.toString(i)+"%");
                i++;
                if(i==100)
                    new Loading().setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }*/

        /*try{
            for (int i=0; i<100; i++){
                Thread.sleep(60);
                progressBar.setValue(i);

            }
        }catch (Exception e1){ e1.printStackTrace();
            System.out.println(e1);}*/

        //new Loading().setVisible(false);
        //new Login().setVisible(true);



        getContentPane().setBackground(new Color(252, 190, 133));

        setLayout(null);
        //setBackground(new Color(247, 152, 100));
        setLocation(300, 250);
        setUndecorated(true);
        setSize(800, 400);
        setVisible(true);
    }


    public static void main(String[] args) {

        Loading loading = new Loading();
        loading.setVisible(true);

        //Login login = new Login();
        try{
            for (int i=0; i<=100; i++){
                Thread.sleep(40);
                loading.progressBar.setValue(i);

            }
        }catch (Exception e1){}

        loading.setVisible(false);
        new Login().setVisible(true);
        loading.dispose();

    }
}
