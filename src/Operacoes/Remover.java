/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import BaseDeDados.BD;
import Objectos.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author isacl
 */

public class Remover {
    
    private Validar va;
    private BD bd;
  
    public Remover(){
        va = new Validar();
        bd = new BD();
    }
    
    public void RemoverCliente(LinkedList<Cliente> cliente) throws IOException{
        
       int idC;
       boolean existe = false;
       idC = va.validarInt(0, 999, "ID do cliente que pretende eliminar suas informacoes: ");
       for(int i=0;i<cliente.size();i++){
           if(cliente.get(i).getIdCliente() == idC){
                existe = true;
                bd.delCliente(cliente.get(i));
                cliente.remove(i);             
               System.out.print("Dados do(a) Cliente "+cliente.get(i).getNome()+" Removidos.\n");
           }
       }
       if(existe == false){
            System.out.println("O CLIENTE QUE PRETENDE ELIMINAR NAO ESTA CADASTRADO..\n");
       }
    
    }
    
    public void RemoverAutomovel(LinkedList<Automovel> automovel) throws IOException{
        
        int idA;
        boolean existe =  false;
       idA = va.validarInt(0, 999, "ID do Automovel que pretende eliminar suas informacoes: ");
       for(int i=0;i<automovel.size();i++){
           if(automovel.get(i).getIdAutomovel() == idA){
               existe = true;
               automovel.remove(i);
               bd.delAutomovel(automovel.get(i));
               System.out.print("Dados Do Automovel Removidos.\n");
           }
           
           if(existe == false){
            System.out.println("O AUTOMOVEL QUE PRETENDE ELIMINAR NAO ESTA CADASTRADO.\n");
       }
       }
    
    }
    
    public void removerAluguer(LinkedList <Aluguer> aluguer) throws IOException{
        boolean ex = false;
        
        int idAl = va.validarID(aluguer, "al");
        for (int i = 0; i < aluguer.size(); i++){
            if(aluguer.get(i).getIdAluguer() == idAl){
                    aluguer.remove(i);
                    bd.delAluguer(aluguer.get(i));
                    System.out.println("Aluguer Eliminado.");
                    ex = true;
                    break;
                }
            if((i == aluguer.size() - 1) && ex == false)
                System.out.println("Aluguer Nao Identificado.");
        }
    }
    
}

