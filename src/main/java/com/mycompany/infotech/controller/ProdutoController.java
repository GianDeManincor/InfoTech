/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.controller;

import com.mycompany.infotech.DAO.ProdutoDAO;
import com.mycompany.infotech.models.Produto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Icaro
 */
public class ProdutoController {
    
    public static boolean salvar(String[] newP, Date data) throws ParseException{
        
        Produto pro = new Produto();
        
        pro.setProduto(newP,data);
        
        return ProdutoDAO.salvar(pro);
    }
    
    public static boolean Alterar(String[] newP, Date data) throws ParseException{
        
        Produto pro = new Produto();
        
        pro.setProduto(newP,data);
        
        return ProdutoDAO.Atualizar(pro);
    }
    
    public static boolean exclusao(int ID){
        
        Produto pro = new Produto();
        
        pro.setID(ID);
        
        return ProdutoDAO.exclusao(pro);
    }
    
    public static ArrayList<String[]> selecionar(){
        
        ArrayList<Produto> listaProdutoDAO = ProdutoDAO.setProdutos();
        
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
