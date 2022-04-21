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
    
    public void insertPessoa(Pessoa p){
        
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
    
    // Pegar ID para passar no método  de inserir uma conta. Em andamento
    public static int getID_Pessoa(String rg){
        
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT ID_Pessoa FROM Pessoa WHERE RG = %s";
        
        try (Statement stmt = con.createStatement()) {

            //ResultSet rs = stmt.executeQuery(query);
            ResultSet rs = stmt.executeQuery(String.format(query, rg));

            if (rs.next()) {
            
                System.out.println(rs.getInt("ID_Pessoa"));
                return 2;
                
            } else {

                throw new RuntimeException("Erro de autenticacao");
            }
            
            
            //return rs.getInt("ID_Pessoa");
            //return 1;
            //https://pt.stackoverflow.com/questions/134134/problemas-para-pegar-valor-do-resultset
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao consultar ID_Pessoa: " + ex);
            return 0;

        }
    }
    
    public void readPessoa() {

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
    
    public void deletePessoa(Pessoa p){
        
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
