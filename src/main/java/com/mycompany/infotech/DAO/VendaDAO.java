/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.DAO;


import com.mycompany.infotech.models.Item;
import com.mycompany.infotech.models.Produto;
import com.mycompany.infotech.models.Venda;
import com.mycompany.infotech.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gian
 */
public class VendaDAO {
    
    GerenciadorConexao conexao = new GerenciadorConexao();
    
    
    public boolean salvar(Venda venda){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSET INTO " );
            
            ResultSet rs = instrucaoSQL.executeQuery();
            
            for(Item item : venda.getListItem()){
                
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
        
        return false;
    }
    
    public ArrayList<Produto> pesquisarProduto(String nomeProduto){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        Produto produto = new Produto();
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM estoque WHERE Nome_Produto LIKE ?" );
            instrucaoSQL.setString(1, nomeProduto + "%");
            
            ResultSet rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                produto.setID(rs.getInt("cod_E"));
                produto.setNome_Produto(rs.getString("Nome_Produto"));
                produto.setValor_venda(rs.getInt("Valor_venda"));
                produto.setQuantidade(rs.getInt("QTD_estoque"));
                listaProduto.add(produto);
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
        return listaProduto;
    }
    
}
