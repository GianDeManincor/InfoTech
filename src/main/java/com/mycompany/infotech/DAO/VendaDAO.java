/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.DAO;


import com.mycompany.infotech.models.Produto;
import com.mycompany.infotech.models.Venda;
import com.mycompany.infotech.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gian
 */
public class VendaDAO {
    
    GerenciadorConexao conexao = new GerenciadorConexao();
    
    
    public boolean salvar(Venda venda){
        return false;
    }
    
    public Produto pesquisarProduto(String nomeProduto){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        Produto produto = new Produto();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM estoque WHERE Nome_Produto LIKE ?" );
            instrucaoSQL.setString(1, nomeProduto + "%");
            
            ResultSet rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                rs.getString("nome");
                //PEGAR OS DADOS DO BANCO
            }
      
            
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                GerenciadorConexao.fecharConexao();
                System.out.println("conexão finalizada");
            } catch(SQLException ex){
                System.out.println("erro" + ex);
            }
            
        }
        return produto;
    }
    
}
