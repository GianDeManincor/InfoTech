/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.controller;

import com.mycompany.infotech.DAO.RelatorioDAO;
import com.mycompany.infotech.models.Relatorio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Controller de solicitações Relatorios analíticos e sintéticos ao banco de dados
 * @author Icaro
 */
public class RelatorioController {
    
    /**
     * método solicitações relatório sintético dos pedidos dos cliente
     * @param inicio Date parâmetro de início da busca
     * @param fim Date parâmetro de fim da busca
     * @return ArrayList e se houver um erro <b>null</b>
     */
    public static ArrayList<String[]> RSC(Date inicio, Date fim){
        
        Relatorio R = new Relatorio();
        
        R.setData_inicio(inicio);
        R.setData_fim(fim);
        
        ArrayList<Relatorio> listaRelatorioDAO = RelatorioDAO.RelatorioSintéticoCliente(R);
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
        
        
        for (Relatorio r : listaRelatorioDAO) {
            listaRetono.add(new String[]{String.valueOf(r.getIDC()),
                r.getNomeC(),r.getCPF(),String.valueOf(r.getValorTotal())});
        }
        
        return listaRetono;
    }
    
    /**
     * método solicitações relatório analítico dos pedidos dos cliente
     * @param inicio Date parâmetro de início da busca
     * @param fim Date parâmetro de fim da busca
     * @return ArrayList e se houver um erro <b>null</b>
     */
    public static ArrayList<String[]> RAC(Date inicio, Date fim){
    
        Relatorio R = new Relatorio();
        
        R.setData_inicio(inicio);
        R.setData_fim(fim);
        
        ArrayList<Relatorio> listaRelatorioDAO = RelatorioDAO.RelatorioAnaliticoCliente(R);
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
        
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Relatorio r : listaRelatorioDAO) {
            listaRetono.add(new String[]{String.valueOf(r.getIDC()),
                r.getNomeC(),r.getCPF(),String.valueOf(r.getIDP()),String.valueOf(r.getQTDI()),String.valueOf(r.getValorTotal()),
                String.valueOf(form.format(r.getData_criacao()))});
        }
        
        return listaRetono;
    }
    
    /***
     * método solicitações relatório sintético dos itens do pedido
     * @param IDC int código do cliente
     * @return ArrayList e se houver um erro <b>null</b>
     */
    public static ArrayList<String[]> RSP(int IDC, Date inicio, Date fim){
    
        Relatorio R = new Relatorio();
        
        R.setIDC(IDC);
        R.setData_inicio(inicio);
        R.setData_fim(fim);
        
        ArrayList<Relatorio> listaRelatorioDAO = RelatorioDAO.RelatorioSintéticoPedido(R);
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
        
        for (Relatorio r : listaRelatorioDAO) {
            listaRetono.add(new String[]{r.getNomeP(),String.valueOf(r.getQTDI()),String.valueOf(r.getValorItemVenda())});
        }
        
        return listaRetono;
    }
    
    /**
     * método solicitações relatório analítico dos itens do pedido
     * @param IDP int código do pedido
     * @return ArrayList e se houver um erro <b>null</b>
     */
    public static ArrayList<String[]> RAP(int IDP){
    
        Relatorio R = new Relatorio();
        
        R.setIDP(IDP);
        
        ArrayList<Relatorio> listaRelatorioDAO = RelatorioDAO.RelatorioAnaliticoPedido(R);
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
        
        for (Relatorio r : listaRelatorioDAO) {
            listaRetono.add(new String[]{r.getNomeP(),r.getMarca(),r.getModelo(),String.valueOf(r.getQTDI()),
                String.valueOf(r.getValorItemVenda()),String.valueOf(r.getValorItemCompra())});
        }
        
        return listaRetono;
    }
    
}
