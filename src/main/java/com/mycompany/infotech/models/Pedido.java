/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gian
 */
public class Pedido {
    
    private int id;
    private int idCliente;
    private double valor;
    private ArrayList<Item> listItem = new ArrayList<>();
    private Date dataPedido;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
}
