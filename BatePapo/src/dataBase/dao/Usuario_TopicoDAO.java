package dataBase.dao;

import dataBase.beans.Usuario_Topico;
import dataBase.util.ConectaBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario_TopicoDAO {

    public void insert(Usuario_Topico obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "INSERT INTO usuario_topico (codUsuario, idTopico) VALUES (?, ?)");
            pst.setInt(1, obj.getUsuario().getCodUsuario());
            pst.setInt(2, obj.getTopico().getId());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Usuario_Topico obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "DELETE FROM usuario_topico WHERE codUsuario = ? AND idTopico = ?");
            pst.setInt(1, obj.getUsuario().getCodUsuario());
            pst.setInt(2, obj.getTopico().getId());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
