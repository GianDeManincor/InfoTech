/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.controller;

import com.mycompany.infotech.DAO.VendaDAO;
import com.mycompany.infotech.models.Pedido;
import com.mycompany.infotech.models.Produto;
import java.util.ArrayList;

/**
 *
 * @author Gian
 */

public class VendasController {
    
    VendaDAO vendaDao = new VendaDAO();
    
    public ArrayList<Produto> pesquisarProduto(String produto){
        return vendaDao.pesquisarProduto(produto);
    }

    public boolean cadastrarCompra(Pedido pedido) {
       vendaDao.salvar(pedido);
       return true;
    }
    
}
