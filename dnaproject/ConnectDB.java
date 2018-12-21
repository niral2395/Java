/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnaproject;

/**
 *
 * @author Jainam
 */
import java.sql.*;
import javax.swing.*;
public class ConnectDB {

    Connection conn=null;
    
    public static Connection Connect(){
        
        try {
            //Class.forName(org.sqlite.JDBC);
            //DriverManager.registerDriver(new org.sqlite.JDBC());
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/onepass1","root","");
            
            //JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        }    
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connection Failed To Establish"+ex);
            return null;
        }
    }
}
