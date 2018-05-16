package dataBase.dao;

import dataBase.beans.Topico;
import dataBase.util.ConectaBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TopicoDAO {

    public void insert(Topico obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "INSERT INTO topico (nome) VALUES (?)");
            pst.setString(1, obj.getNome());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(TopicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Topico obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
               "UPDATE topico SET nome = ? WHERE id = ?");
            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getId());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(TopicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Topico obj) {
        PreparedStatement pst;
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "DELETE FROM topico WHERE id = ?");
            pst.setInt(1, obj.getId());
            pst.execute();
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(TopicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Topico findById(Integer id) {
        Topico obj = null;
        ResultSet rs;
        PreparedStatement pst;
        
        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "SELECT * FROM topico WHERE id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                obj = new Topico(id, rs.getString("nome"));
            }
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(TopicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return obj;
    }

    public List<Topico> findAll() {
        List<Topico> topicos = new ArrayList<>();
        ResultSet rs;
        PreparedStatement pst;

        try {
            pst = ConectaBD.getConection().prepareStatement(
                    "SELECT * FROM topico ORDER BY nome");
            rs = pst.executeQuery();

            while(rs.next()) {
                topicos.add(new Topico(rs.getInt("id"), 
                                       rs.getString("nome")));
            }
        } catch (SQLException ex) {
            // TRATAR EXCESSAO
            Logger.getLogger(TopicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return topicos;
    }
    
}
