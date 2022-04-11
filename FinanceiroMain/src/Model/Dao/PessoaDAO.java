/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Connection.ConnectionFactory;
import Model.bean.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 *
 * @author rafaelmuniz
 */
public class PessoaDAO {
    
    public void create(Pessoa p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Pessoa (Nome, RG, dataNascimento) VALUES (?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRG());
            stmt.setString(3, p.getdataNascimento());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void read() {
        
    Connection con = ConnectionFactory.getConnection();
    String query = "SELECT * FROM Pessoa";
    
    try (Statement stmt = con.createStatement()) {
        
      ResultSet rs = stmt.executeQuery(query);
      
      while (rs.next()) {
        
            String nome = rs.getString("Nome");
            String rg = rs.getString("RG");
            String dataNasc = rs.getString("dataNascimento");

            System.out.println(nome + ", " + rg + ", " + dataNasc);
      }
      
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        
        }
    }
    
        public void delete(Pessoa p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Pessoa WHERE Nome = (?) AND"
                    + " RG = (?) AND DataNascimento = (?)");
                        
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRG());
            stmt.setString(3, p.getdataNascimento());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex);
        
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
