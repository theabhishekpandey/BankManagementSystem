package bank.management.system;

import java.sql.*;

public class Connect {

    Connection c;
    java.sql.Statement statement;

    public Connect()
    {
        try
        {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","w@tchcl0cK");
            statement=c.createStatement();

        } 
        
        
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
