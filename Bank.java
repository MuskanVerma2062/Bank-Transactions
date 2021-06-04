package BankTransactions;

import java.sql.*;

public class Bank{
    Connection connection;
    Statement statement;

    public Bank(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///bankproject","root","");
            statement = connection.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
