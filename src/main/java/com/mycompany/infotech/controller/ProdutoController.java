/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.controller;

import com.mycompany.infotech.DAO.ProdutoDAO;
import com.mycompany.infotech.models.Produto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Controller de solicitações de manipulação de dados do Produto ao banco de dados
 * @author Icaro
 */
public class ProdutoController {
    
    /**
     * método de solicitação adicionar os dados de um novo Produto ao banco de dados
     * @param newP String[] demais dados do Produto
     * @param data Date data de aquisição de navo remessa
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
    public static boolean salvar(String[] newP, Date data){
        
        Produto pro = new Produto();
        
        pro.setNome_Produto(newP[0]);
        pro.setMarca(newP[1]);
        pro.setModelo(newP[2]);
        pro.setDescricao(newP[3]);
        pro.setValor_venda(Double.parseDouble(newP[4]));
        pro.setValor_compra(Double.parseDouble(newP[5]));
        pro.setQuantidade(Integer.parseInt(newP[6]));
        pro.setCNPJ(newP[7]);
        pro.setContato(newP[8]);
        pro.setEmail(newP[9]);
        pro.setFornecedor(newP[10]);
        pro.setData_aquisicao(data);
        
        return ProdutoDAO.salvar(pro);
    }
    
    /**
     * método de solicitação atualizar dos dados do Produto no banco de dados
     * @param newP String[] demais dados do Produto
     * @param data Date data de aquisição de navo remessa
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
    public static boolean Alterar(String[] newP, Date data){
        
        Produto pro = new Produto();
        
        pro.setNome_Produto(newP[0]);
        pro.setMarca(newP[1]);
        pro.setModelo(newP[2]);
        pro.setDescricao(newP[3]);
        pro.setValor_venda(Double.parseDouble(newP[4]));
        pro.setValor_compra(Double.parseDouble(newP[5]));
        pro.setQuantidade(Integer.parseInt(newP[6]));
        pro.setCNPJ(newP[7]);
        pro.setContato(newP[8]);
        pro.setEmail(newP[9]);
        pro.setFornecedor(newP[10]);
        pro.setID(Integer.parseInt(newP[11]));
        pro.setData_aquisicao(data);
        
        return ProdutoDAO.Atualizar(pro);
    }
    
    /**
     * método de solicitação excluir de um Produto do banco de dados
     * @param ID int codigo do Produto
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
    public static boolean exclusao(int ID){
        
        Produto pro = new Produto();
        
        pro.setID(ID);
        
        return ProdutoDAO.exclusao(pro);
    }
    
    /**
     * método de solicitação da tabela Produto ao banco de dados
     * @return ArrayList se houver um erro <b>null</b>
     */
    public static ArrayList<String[]> selecionar(){
        
        ArrayList<Produto> listaProdutoDAO = ProdutoDAO.setProdutos();
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
                
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Produto p : listaProdutoDAO) {
            listaRetono.add(new String[]{String.valueOf(p.getID()),
                p.getNome_Produto(),p.getMarca(),p.getModelo(),
                p.getDescricao(),String.valueOf(p.getQuantidade()),
                String.valueOf(p.getValor_venda()),String.valueOf(p.getValor_compra()),
                p.getFornecedor(),p.getCNPJ(),p.getContato(),
                p.getEmail(),
                String.valueOf(form.format(p.getData_aquisicao()))});
        }
        
        return listaRetono;
    }
    
    /**
     * método de solicitação de buscar um elemento em determinada colunada da tabela Produto ao banco de dados
     * @param coluna String identifique a coluna da tabela
     * @param Busca String elemento a ser buscado
     * @return ArrayList se houver um erro <b>null</b>
     */
    public static ArrayList<String[]> Busca(String coluna, String Busca){
        
        ArrayList<Produto> listaProdutoDAO = ProdutoDAO.Busca(coluna, Busca);
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
                
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Produto p : listaProdutoDAO) {
            listaRetono.add(new String[]{String.valueOf(p.getID()),
                p.getNome_Produto(),p.getMarca(),p.getModelo(),
                p.getDescricao(),String.valueOf(p.getQuantidade()),
                String.valueOf(p.getValor_compra()),String.valueOf(p.getValor_venda()),
                p.getFornecedor(),p.getCNPJ(),p.getContato(),
                p.getEmail(),
                String.valueOf(form.format(p.getData_aquisicao()))});
        }
        
        return listaRetono;
    }
    
}
