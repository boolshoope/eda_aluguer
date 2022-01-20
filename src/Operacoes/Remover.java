/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.*;
import java.io.*;

/**
 *
 * @author isacl
 */

public class Remover {
    
    private final Validar va;
  
    public Remover(){
        va = new Validar();
    }
    
    public void RemoverCliente(listaLigada<Cliente> cliente) throws IOException{
        
       int idC;
       boolean existe = false;
       idC = va.validarInt(0, 999, "ID do cliente que pretende eliminar suas informacoes: ");
       for(int i=0;i<cliente.getSize();i++){
           Cliente c = cliente.getElemento(i).getInfo();
           if(c.getIdCliente() == idC){
                existe = true;           
                cliente.remover(c); 
               System.out.print("Dados do(a) Cliente "+cliente.getElemento(i).getInfo().getNome()+" Removidos.\n");
           }
       }
       if(existe == false){
            System.out.println("O CLIENTE QUE PRETENDE ELIMINAR NAO ESTA CADASTRADO..\n");
       }
    
    }
    
    public void RemoverAutomovel(listaLigada<Automovel> automovel) throws IOException{
        
        int idA;
        boolean existe =  false;
       idA = va.validarInt(0, 999, "ID do Automovel que pretende eliminar suas informacoes: ");
       for(int i=0;i<automovel.getSize();i++){
           if(automovel.getElemento(i).getInfo().getIdAutomovel() == idA){
               existe = true;
               automovel.remover(automovel.getElemento(i).getInfo());
               System.out.print("Dados Do Automovel Removidos.\n");
           }
           
           if(existe == false){
            System.out.println("O AUTOMOVEL QUE PRETENDE ELIMINAR NAO ESTA CADASTRADO.\n");
       }
       }
    
    }
    
    public void removerAluguer(listaLigada<Aluguer> aluguer) throws IOException{
        boolean ex = false;
        
        int idAl = va.validarID(aluguer, "al");
        for (int i = 0; i < aluguer.getSize(); i++){
            if(aluguer.getElemento(i).getInfo().getIdAluguer() == idAl){
                    aluguer.remover(aluguer.getElemento(i).getInfo());
                    System.out.println("Aluguer Eliminado.");
                    ex = true;
                    break;
                }
        }   
            if(ex == false)
                System.out.println("Aluguer Nao Identificado.");
       
    }
    
}

