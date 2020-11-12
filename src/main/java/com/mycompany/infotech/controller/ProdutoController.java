/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.controller;

import com.mycompany.infotech.DAO.ProdutoDAO;
import com.mycompany.infotech.models.Produto;
import java.text.ParseException;

/**
 *
 * @author Icaro
 */
public class ProdutoController {
    public static boolean salvar(String[] v) throws ParseException{
        
        Produto pro = new Produto();
        pro.setProduto(v);
        
        return ProdutoDAO.salvar(pro);
    }
}
