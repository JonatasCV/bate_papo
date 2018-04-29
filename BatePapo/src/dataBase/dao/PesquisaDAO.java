package dataBase.dao;

import dataBase.beans.Pesquisa;
import dataBase.util.ConectaBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PesquisaDAO {

    private static Timestamp ts;
    
    public void insert(Pesquisa obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "INSERT INTO pesquisa (dataHora, topico) VALUES (?, ?)");
            
            ts = new Timestamp(obj.getDataHora().getTimeInMillis());
            
            pst.setTimestamp(1, ts);
            pst.setInt(2, obj.getTopico().getId());

            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(PesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Pesquisa obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "DELETE FROM pesquisa WHERE dataHora = ? AND topico = ?");
            
            ts = new Timestamp(obj.getDataHora().getTimeInMillis());
            
            pst.setTimestamp(1, ts);
            pst.setInt(2, obj.getTopico().getId());

            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(PesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
