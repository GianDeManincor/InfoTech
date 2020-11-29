/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.models;

import java.util.Date;

/**
 *
 * @author Icaro
 */
public class Relatorio {
    
    private Date Data_inicio;
    private Date Data_fim;
    private Date Data_criacao;
    private int IDC;
    private int IDP;
    private int QTDI;
    private String NomeC;
    private String CPF;
    private String NomeP;
    private String Marca;
    private String Modelo;
    private double ValorTotal;
    private double ValorItemVenda;
    private double ValorItemCompra;

    public Date getData_inicio() {
        return Data_inicio;
    }

    public void setData_inicio(Date Data_inicio) {
        this.Data_inicio = Data_inicio;
    }

    public Date getData_fim() {
        return Data_fim;
    }

    public void setData_fim(Date Data_fim) {
        this.Data_fim = Data_fim;
    }

    public Date getData_criacao() {
        return Data_criacao;
    }

    public void setData_criacao(Date Data_criacao) {
        this.Data_criacao = Data_criacao;
    }

    public int getIDC() {
        return IDC;
    }

    public void setIDC(int IDC) {
        this.IDC = IDC;
    }

    public int getIDP() {
        return IDP;
    }

    public void setIDP(int IDP) {
        this.IDP = IDP;
    }

    public int getQTDI() {
        return QTDI;
    }

    public void setQTDI(int QTDI) {
        this.QTDI = QTDI;
    }

    public String getNomeC() {
        return NomeC;
    }

    public void setNomeC(String NomeC) {
        this.NomeC = NomeC;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeP() {
        return NomeP;
    }

    public void setNomeP(String NomeP) {
        this.NomeP = NomeP;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public double getValorItemVenda() {
        return ValorItemVenda;
    }

    public void setValorItemVenda(double ValorItemVenda) {
        this.ValorItemVenda = ValorItemVenda;
    }

    public double getValorItemCompra() {
        return ValorItemCompra;
    }

    public void setValorItemCompra(double ValorItemCompra) {
        this.ValorItemCompra = ValorItemCompra;
    }
    
}
