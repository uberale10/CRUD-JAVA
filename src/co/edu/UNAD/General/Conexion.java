
package co.edu.UNAD.General;

import java.sql.*;

import javax.swing.JOptionPane;


public class Conexion {
    
    public static Connection getConexion() {
        Connection cn = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/calzado","root","12345678");
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Informacion del Error : "+e.getMessage(),"Error",0);
        }
        
        return cn;
    }
}
