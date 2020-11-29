/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.controller;

import com.mycompany.infotech.DAO.VendaDAO;
import com.mycompany.infotech.models.Item;
import com.mycompany.infotech.models.Pedido;
import com.mycompany.infotech.models.Produto;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Icaro
 * @author Gian
 */

public class VendasController {
    
    VendaDAO vendaDao = new VendaDAO();
    public ArrayList<Produto> pesquisarProduto(String produto){
        return vendaDao.pesquisarProduto(produto);
    }

    public static ArrayList<String[]> BuscaProdutos(String Nome){
        Produto P = new Produto();
        ArrayList<Produto> listaProduto = VendaDAO.BuscaProduto(P);
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
        
        for (Produto p: listaProduto) {
            listaRetono.add(new String[]{String.valueOf(p.getID()),
                p.getNome_Produto(),String.valueOf(p.getValor_venda()),String.valueOf(p.getQuantidade())});
            break;
        }
        
        return listaRetono;
    }
    
    public static boolean ADDPedido(int IDP, Date data) {
        
        System.out.println(VendaDAO.getIDP());
        
        Pedido P = new Pedido();
        
        P.setIDC(IDP);
        P.setDataPedido(data);
                
        return VendaDAO.AddPedido(P);
    }
    
    public static boolean ADDItem(int IDP, int IDE, int QTD, double ValorItem){
        
        Item I = new Item();
        
        I.setIDE(IDE);
        I.setIDP(IDP);
        I.setQTD(QTD);
        I.setValorItem(ValorItem);
        
        return VendaDAO.AddItem(I);
    }
    
    public static int getPedido(){
        ArrayList<Pedido> listaPedido = VendaDAO.getIDP();
        
        int IDP = -1;
        
        for(Pedido p : listaPedido){
            if (p.getIDP()>IDP) {
                IDP=p.getIDP();
            }
        }
        
        return IDP;
    }
    
}
