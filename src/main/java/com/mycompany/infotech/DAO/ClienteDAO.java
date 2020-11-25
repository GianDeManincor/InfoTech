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
 *
 * @author Icaro
 */
public class ClienteDAO {
    
    public static ArrayList<Cliente> setClientes(){
    
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente;");
            
            rs = instrucaoSQL.executeQuery();
            
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
    
    public static ArrayList<Cliente> Busca(String coluna, String Busca){
    
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
        try {
            conexao = GerenciadorConexao.abrirConexao();
            
            switch(coluna){
                case "ID":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cod_C LIKE ? ");
                    instrucaoSQL.setInt(1, Integer.parseInt(Busca));
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Nome":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? ");
                    instrucaoSQL.setString(1, "%"+Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Data de nascimento ":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE datanaci LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Sexo":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE Sexo LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "CPF":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE CPF LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Email":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE email LIKE ? ");
                    instrucaoSQL.setString(1, Busca+"%");
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Cidade":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cidade LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Estado":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE estado LIKE ? ");
                    instrucaoSQL.setString(1, Busca);
                    rs = instrucaoSQL.executeQuery();
                break;
                case "Endereso":
                    instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE esdereso LIKE ? ");
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
    
    public static boolean exclusao(Cliente c){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int en=1;
        
        try {
            //Error 1
            conexao = GerenciadorConexao.abrirConexao();
            
            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cod_C = ?");
            
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
    
}
