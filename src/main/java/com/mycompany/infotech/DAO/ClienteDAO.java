package com.mycompany.infotech.DAO;

import com.mycompany.infotech.models.Cliente;
import com.mycompany.infotech.utils.GerenciadorConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * uma série de métodos de manipulação de dados do cliente no banco de dados
 * @author lucas vinicius
 * @author Icaro
 */
public class ClienteDAO {
    
    /**
     * método para pegar os dados da tabela cliente no banco de dados
     * @return ArrayList se houver um erro <b>null</b>
     */
    public static ArrayList<Cliente> setClientes(){
    
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente;");
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {                
                Cliente c = new Cliente();
                c.setID(rs.getInt("cod_C"));
                c.setNome(rs.getString("Nome"));
                c.setDatanaci(rs.getDate("Datanaci"));
                c.setSexo(rs.getString("Sexo"));
                c.setEmail(rs.getString("Email"));
                c.setCPF(rs.getString("CPF"));
                c.setCidade(rs.getString("Cidade"));
                c.setEstado(rs.getString("Estado"));
                c.setEndereco(rs.getString("Esdereso"));
                
                listaClientes.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
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
        return listaClientes;
    }
    
    /**
     * método para buscar um elemento em determinada coluna na tabela Cliente no banco de dados
     * @param coluna String identifique a coluna da tabela
     * @param Busca String elemento a ser buscado
     * @return ArrayList se houver um erro <b>null</b>
     */
    public static ArrayList<Cliente> Busca(String coluna, String Busca){
    
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            switch(coluna){
                case "ID":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE cod_C LIKE ? ");
                    instrucaoSQL.setInt(1, Integer.parseInt(Busca));
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Nome":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE Nome LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Data de nascimento ":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE Datanaci LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Sexo":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE Sexo LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "CPF":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE CPF LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Email":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE Email LIKE ? ");
                    instrucaoSQL.setString(1, Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Cidade":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE Cidade LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Estado":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE Estado LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Endereso":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE Esdereso LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
            }
            
            while (rs.next()) {                
                Cliente c = new Cliente();
                c.setID(rs.getInt("cod_C"));
                c.setNome(rs.getString("nome"));
                c.setDatanaci(rs.getDate("datanaci"));
                c.setSexo(rs.getString("Sexo"));
                c.setEmail(rs.getString("email"));
                c.setCPF(rs.getString("CPF"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                c.setEndereco(rs.getString("esdereso"));
                
                listaClientes.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
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
        return listaClientes;
    }
    
    /**
     * método para excluir um cliente
     * @param c dados necessários para excluir o cliente do banco de dados
     * @return boolean <b>true</b> se a exclusão foi bem sucedida <b>false</b> se não for
     */
    public static boolean exclusao(Cliente c){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int en=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM Cliente WHERE cod_C = ?");
            
            instrucaoSQL.setInt(1, c.getID());
            
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
    
    /**
     * método para salvar os dados do cliente no banco de dados
     * @param cli dados necessários para cadastrar um cliente
     * @return boolean <b>true</b> se o cadastro foi bem sucedida <b>false</b> se não for
     */
    public static boolean salvar(Cliente cli){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        int en=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            en++;
            
            //Error 2
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Cliente (Nome,Datanaci,Sexo,Email,CPF,Cidade,Estado,Esdereso) VALUES (?,?,?,?,?,?,?,?)");
            
            instrucaoSQL.setString(1, cli.getNome());
            instrucaoSQL.setDate(2, new java.sql.Date(cli.getDatanaci().getTime()));
            instrucaoSQL.setString(3, cli.getSexo());
            System.out.println(cli.getEmail());
            instrucaoSQL.setString(4, cli.getEmail());
            instrucaoSQL.setString(5, cli.getCPF());
            instrucaoSQL.setString(6, cli.getCidade());
            instrucaoSQL.setString(7, cli.getEstado());
            instrucaoSQL.setString(8, cli.getEndereco());
            
            en++;
            //Error 3
            System.out.println(instrucaoSQL);
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            en++;
            //Error 4
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
     * método para atualizar os dados do cliente no banco de dados
     * @param c dados necessários para atualizar os dados do cliente no banco de dados
     * @return boolean <b>true</b> se a atualização foi bem sucedida <b>false</b> se não for
     */
    public static boolean Atualizar(Cliente c){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int er=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            er++;
            //Error 2
            instrucaoSQL = conexao.prepareStatement("UPDATE Cliente SET Nome = ?, Datanaci = ?, Sexo = ?, Email = ?, Cidade = ?, Estado = ?, Esdereso = ? WHERE cod_C = ?");
            er++;
            //Error 3
            instrucaoSQL.setString(1, c.getNome());
            instrucaoSQL.setDate(2, new java.sql.Date(c.getDatanaci().getTime()));
            instrucaoSQL.setString(3, c.getSexo());
            instrucaoSQL.setString(4, c.getEmail());
            instrucaoSQL.setString(5, c.getCidade());
            instrucaoSQL.setString(6, c.getEstado());
            instrucaoSQL.setString(7, c.getEndereco());
            instrucaoSQL.setInt(8, c.getID());
            er++;
            //Error 4
            int linhaAlterada = instrucaoSQL.executeUpdate();
            System.out.println(instrucaoSQL);
            if (linhaAlterada>0) {
                retorno = true;
                //System.out.println("S");
            }else{
                retorno = false;
                //System.out.println("F");
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
    
    /**
     * método usado para pegar todos os CPF da tabela cliente no banco de dados
     * @return ArrayList se houver um erro <b>null</b>
     */
    public static ArrayList<Cliente> getCPFS(){
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT CPF FROM Cliente ORDER BY 1");
            
            rs = instrucaoSQL.executeQuery();
            
            while (rs.next()) {                
                Cliente c = new Cliente();
                
                c.setCPF(rs.getString("CPF"));
                
                listaClientes.add(c);
            }
            
        }catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
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
        return listaClientes;
    }
    
}
