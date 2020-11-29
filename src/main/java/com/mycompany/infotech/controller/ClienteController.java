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
import java.util.Date;

/**
 * Controller de solicitações e manipulação de dados do Cliente ao banco de dados
 * @author lucas vinicius
 * @author Icaro
 */
public class ClienteController {

    /**
     * método de solicitação da tabela clientes ao banco de dados
     * @return ArrayList se houver um erro <b>null</b>
     */
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
    
    /**
     * método de solicitação de buscar um elemento em determinada colunada da tabela clientes ao banco de dados
     * @param coluna String identifique a coluna da tabela
     * @param Busca String elemento a ser buscado
     * @return ArrayList se houver um erro <b>null</b>
     */
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
    
    /**
     * método de solicitação excluir um cliente do banco de dados
     * @param ID int codigo do cliente
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
    public static boolean exclusao(int ID){
        Cliente c = new Cliente();
        c.setID(ID);
        
        return ClienteDAO.exclusao(c);
    }
    
    /**
     * método de solicitação adicionar os dados de um novo cliente ao banco de dados
     * @param DataNascimento Date data de nascimento do cliente
     * @param Sexo String sexo do cliente
     * @param text String[] demais dados do cliente
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
    public static boolean salvar(Date DataNascimento, String Sexo, String[] text){
        
        Cliente cli = new Cliente();
        
        cli.setNome(text[0]);
        cli.setDatanaci(DataNascimento);
        cli.setSexo(Sexo);
        cli.setEmail(text[1]);
        cli.setCPF(text[2]);
        cli.setCidade(text[3]);
        cli.setEstado(text[4]);
        cli.setEndereco(text[5]);
        
        return ClienteDAO.salvar(cli);
    }
    
    /**
     * método de solicitação atualizar dos dados do cliente no banco de dados
     * @param DataNascimento Date data de nascimento do cliente
     * @param Sexo String sexo do cliente
     * @param ID int codigo do cliente
     * @param text String[] demais dados do cliente
     * @return boolean <b>true</b> se o cadastrar foi bem sucedida <b>false</b> se não for
     */
    public static boolean Alterar(Date DataNascimento, String Sexo, int ID, String[] text) {
        
        Cliente cli = new Cliente();
        
        cli.setID(ID);
        cli.setNome(text[0]);
        cli.setDatanaci(DataNascimento);
        cli.setSexo(Sexo);
        cli.setEmail(text[1]);
        cli.setCPF(text[2]);
        cli.setCidade(text[3]);
        cli.setEstado(text[4]);
        cli.setEndereco(text[5]);
        
        return ClienteDAO.Atualizar(cli);
    }
    
    /**
     * método de verificação se o CPF existe no banco de dados
     * @param CPF String CPF do cliente
     * @return boolean <b>true</b> se não for encontrado o CPF no banco de dados. <b>false</b> se for.
     */
    public static boolean ValidarCPF(String CPF){
        
        ArrayList<Cliente> listaClienteDAO = ClienteDAO.getCPFS();
        
        for(Cliente c : listaClienteDAO){
            if (c.getCPF().equals(CPF)) {
                return false;
            }
        }
        
        return true;
    }
    
}
