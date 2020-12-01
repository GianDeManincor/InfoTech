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
 * Controller da tela de vendas
 * @author Gian
 */

public class VendasController {
    
    VendaDAO vendaDao = new VendaDAO();
    
    /**
     * método para pesquisar produto
     * @param produto Produto que o usuário deseja pesquisar
     * @return ArrayList de Produto e se houver um erro <b>ArrayList vazio</b>
     */
    public ArrayList<Produto> pesquisarProduto(String produto){
        return vendaDao.pesquisarProduto(produto);
    }

    /**
     * método para cadastrar pedido
     * @param pedido Pedido que o vendedor está realizando
     * @return true de o pedido foi cadastrado e se houver um erro <b>false</b>
     */
    public boolean cadastrarCompra(Pedido pedido) {
       return vendaDao.salvar(pedido);
    }
    
}
