/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.DAO;

import com.mycompany.infotech.models.Produto;
import com.mycompany.infotech.views.CadastroProdutoView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Icaro
 */
public class ProdutoDAO {
    
    public static boolean salvar(Produto pro) throws ParseException{
        //System.out.println("comoso salvar no DAO");
        //porta do banco de dados
        String porta_database = "3308";
        //nome do banco de dados
        String database = "PI_InfoTech";
        String URL = "jdbc:mysql://localhost:"+porta_database+"/"+database+"?useTimezone=true&serverTimezone=UTC&useSSL=false";
        
        String LOGIN = "root";
        String SENHA = "";
        Connection conexao = null;
        PreparedStatement instrucaoSQL;
        
        //System.out.println("dados DAO");
        int en=1;
        
        try {
            //System.out.println("começo de salvamento no banco de dados");
            //Error 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            en++;
            //Error 2
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            en++;
            //Error 3
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
            
            //pegar data atual
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            instrucaoSQL.setDate(12, dataSql);
            en++;
            //Error 4
            int linhaAfetadas = instrucaoSQL.executeUpdate();
            en++;
            //Error 5
            if(linhaAfetadas>0){
                System.out.println("operação salvar no banco de dado com sucesso");
                return true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao carregar o driver! \nError "+en+" \n"+ex);
            return false;
        } catch (SQLException ex) {
            System.err.println("Erro ao abrir a conexão! \nError "+en+" \n"+ex);
            return false;
        }finally{
            if(conexao!= null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
