package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectaBD {
    private static Connection con = null;
    private static final String URL  = "jdbc:postgresql://localhost/Bate-Papo";
    private static final String USER = "postgres";
    private static final String PASS = "masterkey";
    
    public static Connection getConection() {
        if(con == null) {
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(URL, USER, PASS);
            } catch (ClassNotFoundException ex) {
                // TRATAR ERRO
                Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                // TRATAR ERRO
                Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
    public static void disconnect() {
        try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            // TRATAR ERRO
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
