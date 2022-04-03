/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Connection.ConnectionFactory;
import Model.bean.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    // MODIFICAR PARA TENTAR IMPRIMIR OS DADOS DA TABELA NA TELA 
    public List<Pessoa> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Pessoa");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               
                Pessoa p = new Pessoa();
                
                p.setNome(rs.getString("Nome"));
                p.setRG(rs.getString("RG"));
                p.setdataNascimento(rs.getString("dataNascimento"));
                pessoas.add(p);

            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        
        }
        
        return pessoas;
    }
    
    /*
    public List<Pessoa> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Pessoa");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               
                Pessoa p = new Pessoa();
                
                p.setNome(rs.getString("Nome"));
                p.setRG(rs.getString("RG"));
                p.setdataNascimento(rs.getString("dataNascimento"));
                pessoas.add(p);

            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        
        }
        
        return pessoas;
    }
   */
    
    
}
