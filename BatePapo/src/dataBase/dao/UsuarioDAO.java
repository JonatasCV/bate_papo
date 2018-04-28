package dataBase.dao;

import dataBase.beans.Usuario;
import dataBase.util.ConectaBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    public void insert(Usuario obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "INSERT INTO usuario (nome, iPaddres) VALUES (?, ?)");
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getiPaddres());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Não foi possível incluir o usuario! ");
        }
    }

    public void update(Usuario obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
               "UPDATE usuario set nome = ?, iPaddres = ? WHERE codUsuario = ?");
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getiPaddres());
            pst.setInt(3, obj.getCodUsuario());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Não foi possível alterar o usuario! ");
        }
    }

    public void delete(Usuario obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
               "DELETE from usuario WHERE codUsuario = ?");
            pst.setInt(1, obj.getCodUsuario());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuario! ");
        }
    }

    public Usuario findById(Integer id) {
        Usuario obj = null;
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "SELECT * FROM usuario WHERE codUsuario = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if(rs.next()) {
                obj = new Usuario(id, rs.getString("nome"), 
                                      rs.getString("iPaddres"));
            }
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "SELECT * FROM usuario ORDER BY nome");
            rs = pst.executeQuery();
            while(rs.next()) {
                usuarios.add(new Usuario(rs.getInt("codUsuario"), 
                                        rs.getString("nome"), 
                                        rs.getString("iPaddres")));
            }
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
}
