/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.models;

import java.text.ParseException;
import java.util.Date;

/**
 * @author Gian
 * @author Icaro
 */
//teste

public class Produto {
    
    private int ID;
    private String Nome_Produto;
    private String marca;
    private String modelo;
    private String descricao;
    private double Valor_venda;
    private double Valor_compra;
    private int Quantidade;
    private String CNPJ;
    private String Contato;
    private String Email;
    private String Fornecedor;
    private Date Data_aquisicao;
    
    
    /**
     * @deprecated 
     * @param v
     * @param data
     * @throws ParseException 
     */
    public void setProduto(String [] v, Date data) throws ParseException{
        this.Nome_Produto = v[0];
        this.marca = v[1];
        this.modelo = v[2];
        this.descricao = v[3];
        this.Valor_venda = Double.parseDouble(v[4]);
        this.Valor_compra = Double.parseDouble(v[5]);
        this.Quantidade = Integer.parseInt(v[6]);
        this.CNPJ = v[7];
        this.Contato = v[8];
        this.Email = v[9];
        this.Fornecedor = v[10];
        this.Data_aquisicao = data;
        if (v[11]!=null) {
            this.ID = Integer.parseInt(v[11]); 
        }
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome_Produto() {
        return Nome_Produto;
    }

    public void setNome_Produto(String Nome_Produto) {
        this.Nome_Produto = Nome_Produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor_venda() {
        return Valor_venda;
    }

    public void setValor_venda(double Valor_venda) {
        this.Valor_venda = Valor_venda;
    }

    public double getValor_compra() {
        return Valor_compra;
    }

    public void setValor_compra(double Valor_compra) {
        this.Valor_compra = Valor_compra;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String Contato) {
        this.Contato = Contato;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String Fornecedor) {
        this.Fornecedor = Fornecedor;
    }
    
    public Date getData_aquisicao() {
        return Data_aquisicao;
    }

    public void setData_aquisicao(Date Data_aquisicao) {
        this.Data_aquisicao = Data_aquisicao;
    }
    
}
