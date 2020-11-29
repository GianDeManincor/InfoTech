/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.DAO;

import com.mycompany.infotech.models.Relatorio;
import com.mycompany.infotech.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * uma série de métodos para gerar relatórios sintéticos e analíticos de pedidos e itens
 * @author Icaro
 */
public class RelatorioDAO {
    
    /**
     * método para gerar relatório sintético dos pedidos dos cliente
     * @param R dados necessários para realizar a busca de Relatorio
     * @return ArrayList e se houver um erro <b>null</b>
     */
    public static ArrayList<Relatorio> RelatorioSintéticoCliente(Relatorio R){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Relatorio> RSC = new ArrayList<Relatorio>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT cliente.cod_C, cliente.Nome, cliente.CPF, SUM(Pedido.Valor_Total) FROM cliente "
                    + "INNER JOIN pedido ON cliente.cod_C = pedido.fk_codC "
                    + "WHERE Pedido.Data_criacao BETWEEN ? AND ? GROUP BY Cliente.cod_C;");
            
            instrucaoSQL.setDate(1, new java.sql.Date(R.getData_inicio().getTime()));
            instrucaoSQL.setDate(2, new java.sql.Date(R.getData_fim().getTime()));
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                Relatorio r = new Relatorio();
                r.setIDC(rs.getInt("cod_C"));
                r.setNomeC(rs.getString("Nome"));
                r.setCPF(rs.getString("CPF"));
                r.setValorTodal(rs.getDouble("SUM(Pedido.Valor_Total)"));
                
                RSC.add(r);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            RSC = null;
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
        return RSC;
    }
    
    /**
     * método para gerar relatório Analitico dos pedidos dos cliente
     * @param R dados necessários para realizar a busca de Relatorio
     * @return ArrayList e se houver um erro <b>null</b>
     */
    public static ArrayList<Relatorio> RelatorioAnaliticoCliente(Relatorio R){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Relatorio> RAC = new ArrayList<Relatorio>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT cliente.cod_C, cliente.Nome, cliente.CPF, Pedido.cod_P, SUM(Item.QTD_Item), Pedido.Valor_Total, Pedido.Data_Criacao FROM cliente "
                    + "INNER JOIN pedido on cliente.cod_C = pedido.fk_codC "
                    + "INNER JOIN Item on pedido.cod_P = Item.fk_codP "
                    + "WHERE Pedido.Data_criacao BETWEEN ? AND ? GROUP BY Pedido.cod_P;");
            
            instrucaoSQL.setDate(1, new java.sql.Date(R.getData_inicio().getTime()));
            instrucaoSQL.setDate(2, new java.sql.Date(R.getData_fim().getTime()));
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                Relatorio r = new Relatorio();
                r.setIDC(rs.getInt("cod_C"));
                r.setNomeC(rs.getString("Nome"));
                r.setCPF(rs.getString("CPF"));
                r.setIDP(rs.getInt("cod_P"));
                r.setQTDI(rs.getInt("sum(Item.QTD_Item)"));
                r.setValorTodal(rs.getDouble("Valor_Total"));
                r.setData_criacao(rs.getDate("Data_Criacao"));
                
                RAC.add(r);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            RAC = null;
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
        return RAC;
    }
    
    /**
     * método para gerar relatório sintético dos Itens dos pedidos
     * @param R dados necessários para realizar a busca de Relatorio
     * @return ArrayList e se houver um erro <b>null</b>
     */
    public static ArrayList<Relatorio> RelatorioSintéticoPedido(Relatorio R){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Relatorio> RSP = new ArrayList<Relatorio>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT Estoque.Nome_Produto, SUM(Item.QTD_Item), SUM(Item.Valor_Item) FROM pedido "
                    + "INNER JOIN Item ON pedido.cod_P = Item.fk_codP "
                    + "INNER JOIN Estoque ON Estoque.cod_E = Item.fk_codE "
                    + "WHERE pedido.fk_codC = ? AND Pedido.Data_criacao BETWEEN ? AND ? GROUP BY Item.fk_codE");
            
            instrucaoSQL.setInt(1,R.getIDC());
            instrucaoSQL.setDate(2, new java.sql.Date(R.getData_inicio().getTime()));
            instrucaoSQL.setDate(3, new java.sql.Date(R.getData_fim().getTime()));
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                Relatorio r = new Relatorio();
                r.setNomeP(rs.getString("Nome_Produto"));
                r.setQTDI(rs.getInt("SUM(Item.QTD_Item)"));
                r.setValorItemVenda(rs.getDouble("SUM(Item.Valor_Item)"));
                
                RSP.add(r);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            RSP = null;
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
        return RSP;
    }
    
    /**
     * método para gerar relatório Analitico dos Itens dos pedidos
     * @param R dados necessários para realizar a busca de Relatorio
     * @return ArrayList e se houver um erro <b>null</b>
     */
    public static ArrayList<Relatorio> RelatorioAnaliticoPedido(Relatorio R){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Relatorio> RAP = new ArrayList<Relatorio>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT Estoque.Nome_Produto, Estoque.Marca, Estoque.Modelo, Item.QTD_Item, Item.Valor_Item, Estoque.Valor_compra FROM pedido "
                    + "INNER JOIN Item ON pedido.cod_P = Item.fk_codP "
                    + "INNER JOIN Estoque ON Estoque.cod_E = Item.fk_codE "
                    + "WHERE pedido.cod_P = ?");
            
            instrucaoSQL.setInt(1,R.getIDP());
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                Relatorio r = new Relatorio();
                r.setNomeP(rs.getString("Nome_Produto"));
                r.setMarca(rs.getString("Marca"));
                r.setModelo(rs.getString("Modelo"));
                r.setQTDI(rs.getInt("QTD_Item"));
                r.setValorItemVenda(rs.getDouble("Valor_Item"));
                r.setValorItemCompra(rs.getDouble("Valor_compra"));
                
                RAP.add(r);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            RAP = null;
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
        return RAP;
    }
    
}
