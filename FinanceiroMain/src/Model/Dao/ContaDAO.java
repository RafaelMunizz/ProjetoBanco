/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Connection.ConnectionFactory;
import Model.bean.Conta;
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
public class ContaDAO {
    
    
    public void insertConta(Conta c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        System.out.println(PessoaDAO.getID_Pessoa(c.getRG()));
        
        /*
        try {
            
        
            // Ajeitar para pegar o ID da pessoa (chave primária) e passar para a tabela Conta como secundária
            stmt = con.prepareStatement("INSERT INTO Conta (saldo, tipoConta, ID_Pessoa) VALUES (?,?,?)");
            stmt.setDouble(1, c.getSaldo());
            stmt.setString(2, c.getTipoConta());
            stmt.setInt(3, PessoaDAO.getID_Pessoa(c.getRG()));
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
         */
    }
    
    public void readConta() {
        
    Connection con = ConnectionFactory.getConnection();
    String query = "SELECT * FROM Conta";
    
    try (Statement stmt = con.createStatement()) {
        
      ResultSet rs = stmt.executeQuery(query);
      
      while (rs.next()) {
        
            int ID_Conta = rs.getInt("ID_Conta");
            double saldo = rs.getDouble("saldo");
            String tipoConta = rs.getString("tipoConta");
            int ID_Pessoa = rs.getInt("ID_Pessoa");

            System.out.printf("ID_Conta = %d\nSaldo = %f\nTipoConta = %s\nID_Pessoa = %d", ID_Conta, saldo, tipoConta, ID_Pessoa);
      }
      
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        
        }
    }
    
        public void deleteConta(Pessoa p){
        
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
