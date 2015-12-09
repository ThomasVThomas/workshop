package bill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Tryproject {

    public static void main(String[] args) {
     /*   try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","envox" );
            Statement stmt = (Statement) con.createStatement();
            
            String uname = "rit2012004";
            String pass = "munda";
            String insert = "INSERT INTO login VALUES('" +uname+"','"+ pass +"')";
            stmt.executeUpdate(insert);
        } catch (Exception e) {
            
        }*/
      //  login ob = new login();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    
}
