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
import java.util.ArrayList;

/**
 * uma série de métodos de manipulação de dados do Produto no banco de dados
 * @author Icaro
 */
public class ProdutoDAO {
    
    /**
     * método para cadastrar um novo produto no banco de dados
     * @param pro dados relacionados ao produto
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
    public static boolean salvar(Produto pro){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        int en=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Estoque (Nome_Produto,Marca,Modelo,Descricao,Valor_venda,Valor_compra,QTD_estoque,CNPJ,Contato,Email,Fornecedor,Data_aquisicao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            
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

    /**
     * método para pegar os dados da tabela produto no banco de dados
     * @return ArrayList se houver um erro <b>null</b>
     */
    public static ArrayList<Produto> setProdutos(){
    
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque;");
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {
                Produto p = new Produto();
                p.setID(rs.getInt("cod_E"));
                p.setNome_Produto(rs.getString("Nome_Produto"));
                p.setMarca(rs.getString("Marca"));
                p.setModelo(rs.getString("Modelo"));
                p.setDescricao(rs.getString("Descricao"));
                p.setValor_venda(rs.getDouble("Valor_venda"));
                p.setValor_compra(rs.getDouble("Valor_compra"));
                p.setQuantidade(rs.getInt("QTD_estoque"));
                p.setCNPJ(rs.getString("CNPJ"));
                p.setContato(rs.getString("Contato"));
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
    
    /**
     * método para buscar um elemento em determinada coluna na tabela produto no banco de dados
     * @param coluna String identifique a coluna da tabela
     * @param Busca String elemento a ser buscado
     * @return ArrayList se houver um erro <b>null</b>
     */
    public static ArrayList<Produto> Busca(String coluna, String Busca){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            switch(coluna){
                case "ID":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Cod_e LIKE ? ");
                    instrucaoSQL.setInt(1, Integer.parseInt(Busca));
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Nome do Produto":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Nome_Produto LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Marca":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Marca LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Modelo":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Modelo LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Especificaçoes":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Descricao LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Nome do Fornecedor":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Fornecedor LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "CNPJ":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE CNPJ LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Contato":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Contato LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "E-mail":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Email LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Quantidade":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE QTD_estoque LIKE ? ");
                    instrucaoSQL.setInt(1, Integer.parseInt(Busca));
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Valor de Compra":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Valor_compra LIKE ? ");
                    instrucaoSQL.setDouble(1, Double.parseDouble(Busca.replace(",", ".")));
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Valor de Venda":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Estoque WHERE Valor_venda LIKE ? ");
                    instrucaoSQL.setDouble(1, Double.parseDouble(Busca.replace(",", ".")));
                    rs = instrucaoSQL.executeQuery();
                break;
//                case "Data de Aquisição":
//                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM estoque WHERE Data_aquisicao LIKE ? ");
//                    instrucaoSQL.setInt(1, Integer.parseInt(Busca));
//                    rs = instrucaoSQL.executeQuery();
//                break;
            }
            
            while (rs.next()) {                
                Produto p = new Produto();
                p.setID(rs.getInt("cod_E"));
                p.setNome_Produto(rs.getString("Nome_Produto"));
                p.setMarca(rs.getString("Marca"));
                p.setModelo(rs.getString("Modelo"));
                p.setDescricao(rs.getString("Descricao"));
                p.setValor_venda(rs.getDouble("Valor_venda"));
                p.setValor_compra(rs.getDouble("Valor_compra"));
                p.setQuantidade(rs.getInt("QTD_estoque"));
                p.setCNPJ(rs.getString("CNPJ"));
                p.setContato(rs.getString("Contato"));
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
    
    /**
     * método para atualizar os dados do Produto no banco de dados
     * @param p dados relacionados ao produto
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
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
            instrucaoSQL = conexao.prepareStatement("UPDATE Estoque SET Nome_Produto = ?, Marca = ?, Modelo = ?, Descricao = ?, Valor_venda = ?, Valor_compra = ?, QTD_estoque = ?, CNPJ = ?, Contato = ?, Email = ?, Fornecedor = ?, Data_aquisicao = ? WHERE cod_E =? ");
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
            
            //retorno false | trur
            retorno = linhaAlterada>0;
            
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
    
    /**
     * método para excluir um Produto
     * @param p dados relacionados ao produto
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
    public static boolean exclusao(Produto p){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        int en=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Estoque WHERE cod_E = ?");
            
            instrucaoSQL.setInt(1, p.getID());
            
            en++;
            //Error 2
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            en++;
            //Error 3
            if(linhaAfetadas>0){
                System.out.println("exclusao de Produto");
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
    
}
