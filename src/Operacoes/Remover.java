/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.Aluguer;
import Objectos.Automovel;
import Objectos.Cliente;
import java.util.*;
import java.io.*;

/**
 *
 * @author isacl
 */

public class Remover {
    
    private Validar va;
  
    public Remover(){
        va = new Validar();
    }
    
    public void RemoverCliente(LinkedList<Cliente> cliente) throws IOException{
        
       int idC;
       boolean existe = false;
       idC = va.validarInt(0, 999, "ID do cliente que pretende eliminar suas informacoes: ");
       for(int i=0;i<cliente.size();i++){
           if(cliente.get(i).getIdCliente() == idC){
                existe = true;
                cliente.remove(i);             
               System.out.print("Dados do(a) Cliente "+cliente.get(i).getNome()+" Removidos. ");
           }
       }
       if(existe == false){
            System.out.println("O CLIENTE QUE PRETENDE ELIMINAR NAO ESTA CADASTRADO..");
       }
    
    }
    
    public void RemoverAutomovel(LinkedList<Automovel> automovel) throws IOException{
        
        int idA;
        boolean existe =  false;
       idA = va.validarInt(0, 999, "ID do Atomovel que pretende eliminar suas informacoes: ");
       for(int i=0;i<automovel.size();i++){
           if(automovel.get(i).getIdAutomovel() == idA){
               existe = true;
               automovel.remove(i);
               System.out.print("Dados Do Automovel Removidos. ");
           }
           
           if(existe == false){
            System.out.println("O AUTOMOVEL QUE PRETENDE ELIMINAR NAO ESTA CADASTRADO..");
       }
       }
    
    }
    
}

