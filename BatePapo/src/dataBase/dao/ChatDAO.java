package dataBase.dao;

import dataBase.beans.Chat;
import dataBase.util.ConectaBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatDAO {
    
    private static Timestamp ts;
    
    public void insert(Chat obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "INSERT INTO chat (codUsuario1, codUsuario2, dataHora, topico) VALUES (?, ?, ?, ?)");
            pst.setInt(1, obj.getUsuario1().getCodUsuario());
            pst.setInt(2, obj.getUsuario2().getCodUsuario());

            ts = new Timestamp(obj.getDataHora().getTimeInMillis());

            pst.setTimestamp(3, ts);
            pst.setInt(4, obj.getTopico().getId());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(ChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Chat obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "DELETE FROM chat WHERE codUsuario1 = ? AND codUsuario2 = ? AND dataHora = ?");
            pst.setInt(1, obj.getUsuario1().getCodUsuario());
            pst.setInt(2, obj.getUsuario2().getCodUsuario());

            ts = new Timestamp(obj.getDataHora().getTimeInMillis());

            pst.setTimestamp(3, ts);
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(ChatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
