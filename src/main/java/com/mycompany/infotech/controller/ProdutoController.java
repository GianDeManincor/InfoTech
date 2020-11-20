/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.controller;

import com.mycompany.infotech.DAO.ProdutoDAO;
import com.mycompany.infotech.models.Produto;
import java.text.ParseException;
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
    
    public static boolean  Alterar(String[] newP, Date data) throws ParseException{
        
        Produto pro = new Produto();
        
        pro.setProduto(newP,data);
        
        return ProdutoDAO.Atualizar(pro);
    }
}
