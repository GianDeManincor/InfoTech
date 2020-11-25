/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infotech.controller;

import com.mycompany.infotech.models.Cliente;
import com.mycompany.infotech.DAO.ClienteDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Icaro
 */
public class ClienteController {

    public static ArrayList<String[]> setClientes(){
        
        ArrayList<Cliente> listaClienteDAO = ClienteDAO.setClientes();
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
        
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        
        for(Cliente c : listaClienteDAO){
            listaRetono.add(new String[]{String.valueOf(c.getID()),
            c.getNome(),String.valueOf(form.format(c.getDatanaci())),
            c.getSexo(),c.getEmail(),c.getCPF(),c.getCidade(),c.getEstado(),
            c.getEndereco()});
        }
        
        return listaRetono;
        
    }
    
    public static ArrayList<String[]> Busca(String coluna, String Busca){
        
        ArrayList<Cliente> listaClienteDAO = ClienteDAO.Busca(coluna, Busca);
        
        ArrayList<String[]> listaRetono = new ArrayList<String[]>();
        
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        
        for(Cliente c : listaClienteDAO){
            listaRetono.add(new String[]{String.valueOf(c.getID()),
            c.getNome(),String.valueOf(form.format(c.getDatanaci())),
            c.getSexo(),c.getEmail(),c.getCPF(),c.getCidade(),c.getEstado(),
            c.getEndereco()});
        }
        
        return listaRetono;
    }
    
    public static  boolean exclusao(int ID){
        Cliente c = new Cliente();
        c.setID(ID);
        
        return ClienteDAO.exclusao(c);
    }
}
