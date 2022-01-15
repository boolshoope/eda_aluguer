/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;
import Objectos.*;
import java.util.*;

/**
 *
 * @author isacl
 */
public class Visualizar {
    
    public void visClientes(LinkedList<Cliente> cliente){
       System.out.println("\nLISTA DOS CLIENTES CADASTRADOS\n");
       if(cliente.isEmpty()){
           System.out.print("\nNenhum Cliente cadastrado... \n");
       }else{
        System.out.println(String.format("|%-20S|", "Id do Cliente") +String.format("%-20S|", "Nome")+String.format("%-20S|", "Morada")+
                 String.format("%-20S|", "Numero de BI")+ String.format("%-20S|", "Carta de Conducao"));
         for(int i=0; i<cliente.size();i++){
                 System.out.print(String.format("|%-20s|", cliente.get(i).getIdCliente()));
                 System.out.print(String.format("%-20s|", cliente.get(i).getNome()));
                 System.out.print(String.format("%-20s|", cliente.get(i).getMorada()));
                 System.out.print(String.format("%-20s|", cliente.get(i).getBi()));
                 System.out.print(String.format("%-20s|", cliente.get(i).getCartaDeConducao())+"\n");

         }
         
       }  
    }
     
    
    public void visAutomovel( LinkedList<Automovel> a){
        System.out.println("\nLISTA DOS  AUTOMOVEIS CADASTRADOS\n");
        if(a.isEmpty()){
            System.out.print("Nenhum Auotmovel cadastrado... \n");
        }else{
            System.out.println(String.format("|%-20S|", "Id do Automovel") +String.format("%-20S|", "Cor")+String.format("%-20S|", "Marca")+
                    String.format("%-20S|", "Modelo")+ String.format("%-20S|", "Cilindrada")+String.format("%-20S|", "Valor por dia")
                      +String.format("%-20S|", "Ano de Aquisicao"));

           for(int i=0;i<a.size();i++){
                 System.out.print(String.format("|%-20s|", a.get(i).getIdAutomovel()));
                 System.out.print(String.format("%-20s|",a.get(i).getCor()));
                 System.out.print(String.format("%-20s|", a.get(i).getMarca()));
                 System.out.print(String.format("%-20s|", a.get(i).getModelo()));
                 System.out.print(String.format("%-20s|", a.get(i).getCilindrada()));
                 System.out.print(String.format("%-20s|", a.get(i).getValorDia()));
                 System.out.print(String.format("%-20s|", a.get(i).getAnoAquisicao())+"\n");

            }
        }
    
    }
    
    public void visAlugueres(LinkedList<Aluguer> al){
        
        System.out.println("\nLISTA DOS  AUTOMOVEIS CADASTRADOS\n");
        if(al.isEmpty()){
            System.out.print("\nNenhum Aluguer de Automovel Feito... \n");
        }else{
            System.out.println(String.format("|%-20S|", "Id do Aluguer") +String.format("%-20S|", "Id do Automovel")+String.format("%-20S|", "Id do Cliente")+
                    String.format("%-20S|", "Data do Inicio do Aluguer")+ String.format("%-20S|", "Data do Fim do Alufuer")+String.format("%-20S|", "Valor a Pagar")
                      +String.format("%-20S|", "Ano de Aquisicao"));

           for(int i=0;i<al.size();i++){
                  System.out.print(String.format("%-20s|",al.get(i).getIdAluguer()));
                 System.out.print(String.format("|%-20s|", al.get(i).getIdAutomovel()));
                 System.out.print(String.format("%-20s|", al.get(i).getIdCliente()));
                 System.out.print(String.format("%-20s|", al.get(i).getDataInicio()));
                 System.out.print(String.format("%-20s|", al.get(i).getDataFim()));
                 System.out.print(String.format("%-20s|", al.get(i).getValor())+"\n");

            }
        }
    
    }
}
