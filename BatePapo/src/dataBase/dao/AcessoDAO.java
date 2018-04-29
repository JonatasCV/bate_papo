package dataBase.dao;

import dataBase.beans.Acesso;
import dataBase.util.ConectaBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcessoDAO {
    
    private static Timestamp ts;

    public void insert(Acesso obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "INSERT INTO acesso (codUsuario, dataHora) VALUES (?, ?)");
            pst.setInt(1, obj.getUsuario().getCodUsuario());
            
            ts = new Timestamp(obj.getDataHora().getTimeInMillis());
            
            pst.setTimestamp(2, ts);
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(AcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Acesso obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "DELETE FROM acesso WHERE codUsuario = ? AND dataHora = ?");
            pst.setInt(1, obj.getUsuario().getCodUsuario());

            ts = new Timestamp(obj.getDataHora().getTimeInMillis());

            pst.setTimestamp(2, ts);
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(AcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
