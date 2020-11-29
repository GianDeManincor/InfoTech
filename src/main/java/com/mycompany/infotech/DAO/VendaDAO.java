/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.DAO;

import com.mycompany.infotech.models.Item;
import com.mycompany.infotech.models.Pedido;
import com.mycompany.infotech.models.Produto;
import com.mycompany.infotech.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.Date;
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
    
    
    public boolean salvar(Pedido pedido){
        
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean retorno = false;
        int en=1;
        
        try {
            
            conexao = GerenciadorConexao.abrirConexao();
            en++;
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Pedido (fk_codC, Valor_Total, Data_Criacao) VALUES (?,?,?)" );
            
            instrucaoSQL.setInt(1, pedido.getIdCliente());
            instrucaoSQL.setDouble(2, pedido.getValor());
            instrucaoSQL.setDate(3, new java.sql.Date(pedido.getDataPedido().getTime()));
            en++;
            
            System.out.println(instrucaoSQL);
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            en++;
            
            if(linhasAfetadas > 0){
                retorno = true;
                instrucaoSQL = null;
            }
            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Pedido ORDER BY cod_P DESC LIMIT 1" );
            ResultSet rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                pedido.setId(rs.getInt("cod_P"));
            }
            instrucaoSQL = null;
            linhasAfetadas = 0;
            for(Item item : pedido.getListItem()){
                instrucaoSQL = conexao.prepareStatement("INSERT INTO item (fk_codP, fk_codE, QTD_Item, Valor_Item) VALUES (?,?,?,?)");
                instrucaoSQL.setInt(1, pedido.getId());
                instrucaoSQL.setInt(2, item.getId());
                instrucaoSQL.setInt(3, item.getQuantidade());
                instrucaoSQL.setDouble(4, item.getValor());
                
                linhasAfetadas += instrucaoSQL.executeUpdate();
                instrucaoSQL = null;
            }
            
            if(linhasAfetadas > 0){
                retorno = true;
                instrucaoSQL = null;
            }
            
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao carregar o driver! \nError "+en+" \n"+ex);
            retorno = false;
        } catch (SQLException ex) {
            System.err.println("Erro ao abrir a conexão! \nError "+en+" \n"+ex);
            retorno = false;
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
        
        return retorno;
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
