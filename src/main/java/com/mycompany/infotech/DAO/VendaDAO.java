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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Icaro
 * @author Gian
 */
public class VendaDAO {
    
    
    public static boolean AddPedido(Pedido P){
        
        boolean retorno = false;
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        int en=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            en++;
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO pedido (fk_codC,Valor_Total,Data_Criacao) VALUE (?,?,?)");
            
            instrucaoSQL.setInt(1,P.getIDC());
            instrucaoSQL.setDouble(2, P.getValor());
            instrucaoSQL.setDate(3, new java.sql.Date(P.getDataPedido().getTime()));
            
            //
            
            //Error 2
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            en++;
            
            //Error 3
            if(linhaAfetadas>0){
                en++;
                System.out.println("operação salvar no banco de dado com sucesso");
                
                //Error 4
                retorno = true;
            }
           
        } catch (ClassNotFoundException ex) {
            
            System.err.println("Erro ao carregar o driver! \nError "+en+" \n"+ex);
            
        } catch (SQLException ex) {
            
            System.err.println("Erro ao abrir a conexão! \nError "+en+" \n"+ex);
            
        }finally{
            try {
                if(conexao!= null)
                    conexao.close();

                GerenciadorConexao.fecharConexao();
                System.out.println("conexão finalizada");
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    
    public static boolean AddItem(Item I){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        int en=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO item (fk_codP,fk_codE,QTD_Item,Valor_Item) VALUE (?,?,?,?)");
            
            instrucaoSQL.setInt(1, I.getIDP());
            instrucaoSQL.setInt(2, I.getIDE());
            instrucaoSQL.setInt(3, I.getQTD());
            instrucaoSQL.setDouble(4, I.getValorItem());
            
            en++;
            //Error 2
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            en++;
            //Error 3
            if(linhaAfetadas>0){
                System.out.println("operação salvar no banco de dado com sucesso");
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            
            System.err.println("Erro ao carregar o driver! \nError "+en+" \n"+ex);
            retorno = false;
            
        } catch (SQLException ex) {
            
            System.err.println("Erro ao abrir a conexão! \nError "+en+" \n"+ex);
            retorno = false;
            
        }finally{
            try {
                if(conexao!= null)
                    conexao.close();

                GerenciadorConexao.fecharConexao();
                System.out.println("conexão finalizada");
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    
    public static ArrayList<Pedido> getIDP(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT cod_P FROM pedido");
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {                
                Pedido p = new Pedido();
                p.setIDP(rs.getInt("cod_P"));
                listaPedidos.add(p);
            }
            
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaPedidos = null;
        }finally{
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                conexao.close();
                GerenciadorConexao.fecharConexao();
                System.out.println("conexão finalizada");
            } catch (SQLException ex) {
            }
        }
        return listaPedidos;
    }
    
    public static ArrayList<Produto> BuscaProduto(Produto P){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            
            instrucaoSQL = conexao.prepareStatement("SELECT cod_E,Nome_Produto,QTD_estoque,Valor_venda FROM Estoque WHERE Nome_Produto LIKE ?");
            instrucaoSQL.setString(1, P.getNome_Produto()+"%");
            rs = instrucaoSQL.executeQuery();
            
            
            while (rs.next()) {                
                Produto p = new Produto();
                p.setID(rs.getInt("cod_E"));
                p.setNome_Produto(rs.getString("Nome_Produto"));
                p.setValor_venda(rs.getDouble("Valor_venda"));
                p.setQuantidade(rs.getInt("QTD_estoque"));
                
                listaProdutos.add(p);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
        }finally{
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                conexao.close();
                GerenciadorConexao.fecharConexao();
                System.out.println("conexão finalizada");
            } catch (SQLException ex) {
            }
        }
        return listaProdutos;
    }
    
    GerenciadorConexao conexao = new GerenciadorConexao();
     
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
