/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.DAO;

import com.mycompany.infotech.models.Produto;
import com.mycompany.infotech.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Icaro
 */
public class ProdutoDAO {
    
    public static boolean salvar(Produto pro) throws ParseException{
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        int en=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO estoque (Nome_Produto,marca,modelo,descricao,Valor_venda,Valor_compra,Quantidade,CNPJ,Contato,Email,Fornecedor,Data_aquisicao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            
            instrucaoSQL.setString(1,pro.getNome_Produto());
            instrucaoSQL.setString(2,pro.getMarca());
            instrucaoSQL.setString(3,pro.getModelo());
            instrucaoSQL.setString(4,pro.getDescricao());
            instrucaoSQL.setDouble(5,pro.getValor_venda());
            instrucaoSQL.setDouble(6,pro.getValor_compra());
            instrucaoSQL.setInt(7,pro.getQuantidade());
            instrucaoSQL.setString(8,pro.getCNPJ());
            instrucaoSQL.setString(9,pro.getContato());
            instrucaoSQL.setString(10,pro.getEmail());
            instrucaoSQL.setString(11,pro.getFornecedor());
            instrucaoSQL.setDate(12, new java.sql.Date(pro.getData_aquisicao().getTime()));
            
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

    public static ArrayList<Produto> setProdutos(){
    
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM estoque;");
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {                
                Produto p = new Produto();
                p.setID(rs.getInt("cod_E"));
                p.setNome_Produto(rs.getString("Nome_Produto"));
                p.setMarca(rs.getString("marca"));
                p.setModelo(rs.getString("modelo"));
                p.setDescricao(rs.getString("descricao"));
                p.setValor_venda(rs.getDouble("Valor_venda"));
                p.setValor_compra(rs.getDouble("Valor_compra"));
                p.setQuantidade(rs.getInt("Quantidade"));
                p.setCNPJ(rs.getString("CNPJ"));
                p.setContato(rs.getString("contato"));
                p.setEmail(rs.getString("Email"));
                p.setFornecedor(rs.getString("Fornecedor"));
                p.setData_aquisicao(rs.getDate("Data_aquisicao"));
                
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
    
    public static boolean Atualizar(Produto p){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int er=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            er++;
            //Error 2
            instrucaoSQL = conexao.prepareStatement("UPDATE estoque SET Nome_Produto = ?, marca = ?, modelo = ?, descricao = ?, Valor_venda = ?, Valor_compra = ?, Quantidade = ?, CNPJ = ?, Contato = ?, Email = ?, Fornecedor = ?, Data_aquisicao = ? WHERE cod_E =? ");
            er++;
            //Error 3
            instrucaoSQL.setString(1, p.getNome_Produto());
            instrucaoSQL.setString(2, p.getMarca());
            instrucaoSQL.setString(3, p.getModelo());
            instrucaoSQL.setString(4, p.getDescricao());
            instrucaoSQL.setDouble(5, p.getValor_venda());
            instrucaoSQL.setDouble(6, p.getValor_compra());
            instrucaoSQL.setInt(7, p.getQuantidade());
            instrucaoSQL.setString(8, p.getCNPJ());
            instrucaoSQL.setString(9, p.getContato());
            instrucaoSQL.setString(10, p.getEmail());
            instrucaoSQL.setString(11, p.getFornecedor());
            instrucaoSQL.setDate(12, new java.sql.Date(p.getData_aquisicao().getTime()));
            instrucaoSQL.setInt(13, p.getID());
            er++;
            //Error 4
            int linhaAlterada = instrucaoSQL.executeUpdate();
            System.out.println(instrucaoSQL);
            if (linhaAlterada>0) {
                retorno = true;
                System.out.println("S");
            }else{
                retorno = false;
                System.out.println("F");
            }
            er=0;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print(e.getMessage());
            retorno = false;
            System.out.println("Erro "+er);
        } catch (Exception e){
            System.out.println("Erro "+er+e);
        }finally{
            try{
                if (instrucaoSQL!=null) {
                    instrucaoSQL.close();
                }
                conexao.close();
                GerenciadorConexao.fecharConexao();
                System.out.println("conexão finalizada");
            } catch(SQLException ex){
                
            }
            System.out.println("erro"+er);
        }
        return retorno;
    }
    
}