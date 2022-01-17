/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import BaseDeDados.BD;
import Objectos.*;
import static eda_aluguer.Menu.lstAluguer;
import static eda_aluguer.Menu.lstAutomovel;
import static eda_aluguer.Menu.lstCliente;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.*;

/**
 *
 * @author isacl
 */
public class Editar {
    
    private Validar va;
    private Cliente c;
    private Automovel a;
    
    public Editar(){
        va = new Validar();
        c = new Cliente();
        a = new Automovel();
    }
    
    
    public void alterarCliente(LinkedList<Cliente> cliente) throws IOException{
        
        int idC;
        boolean existe = false;       
        
        idC = va.validarInt(0, 999, "ID do cliente que pretende alterar suas informacoes: ");
         for(int i=0;i<cliente.size();i++){
           if(cliente.get(i).getIdCliente() == idC){
                existe = true;
                System.out.println("\nIntroduza os novos dados do cliente:");
                c.setNome(va.validarString(3, 50, "Nome do Cliente: "));
                c.setBi(va.validarString(3, 15, "Numero de BI: "));
                c.setMorada(va.validarString(3, 50, "Morada/Endereco do Cliente: "));
                c.setCartaDeConducao(va.validarString(3, 50, "Carta de Conducao: "));
                cliente.set(i, c); 
                System.out.print("\nDados do(a) Cliente "+idC+" Alterados Com Sucesso \n");
           }
       }
       if(existe == false){
            System.out.println("\nCliente Nao Identificado.");
       }
    
    
    }
    
    public void alterarAutomovel(LinkedList<Automovel> automovel) throws IOException{
        int idAutomovel;
        boolean existe = false;  
        
        idAutomovel = va.validarInt(0, 999, "ID do Automovel que pretende alterar suas informacoes: ");
        for(int i=0;i<automovel.size();i++){
           if(automovel.get(i).getIdAutomovel() == idAutomovel){
               existe = true;
                System.out.println("\nIntroduza os novos dados do automovel:");
                a.setMarca(va.validarString(3, 20, "Marca do Automovel: " ));
                a.setMatricula(va.validarString(3, 20, "Matricula do Automovel: "));
                a.setModelo(va.validarString(3, 50, "Modelo do Automovel: "));
                a.setAnoAquisicao(va.validarInt(1900, 2022,"Ano de Aquisicao: "));
                a.setCilindrada(va.validarString(3, 50, "Clindrada do Automovel: "));
                a.setCor(va.validarString(3, 20, "Cor do Automovel: "));
                a.setValorDia(va.validarDouble(1.0, 10000.0, "Valor do Aluguer Por Dia"));
                automovel.set(i, a);
         
                System.out.println("\nDados Do Automovel Alterados \n");
           }
           
           if(existe == false)
            System.out.println("Automovel Nao Identificado.");
       
       }
       
    }
    
     /*public void alterarAluguer(listaLigada <Aluguer> aluguer, lista<Automovel> automovel, LinkedList<Cliente> cliente, String tipo) throws IOException, ParseException{
        boolean ex = false;
        int idAl = va.validarID(aluguer, "al");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        
        for (int i = 0; i < aluguer.size(); i++){
            if(aluguer.get(i).getIdAluguer() == idAl){
                    switch (tipo){
                        case "automovel":
                            aluguer.get(i).setIdAutomovel(va.validarID(automovel, "a"));
                            bd.updAluguer(aluguer.get(i), idAl);
                            break;
                        case "cliente":
                            aluguer.get(i).setIdCliente(va.validarID(cliente, "c"));
                            break;
                        case "data":
                            Date inicio, fim;
                            String dFim, dInicio;
                            
                            inicio = va.validarData("Data de Inicio de Aluguer:");
                            fim = va.validarData("Data de Fim de Aluguer:");

                            if(fim.after(inicio) == false)
                                    System.out.println("Data de Inicio e Fim de Aluguer Invalida.");
                            else{
                                 dInicio = sdf.format(inicio);
                                  dFim = sdf.format(fim);
                                
                                aluguer.get(i).setDataInicio(dInicio);
                                aluguer.get(i).setDataFim(dFim);
                                bd.updAluguer(aluguer.get(i), idAl);
                            }
                            break;
                        case "valor":
                            double valor = va.validarDouble(100, 10000, "Introduza o Valor de Aluguer do Automovel Por Dia: ");
                            LocalDate dataInicio = LocalDate.parse((aluguer.get(i).getDataInicio()));
                            LocalDate dataFim = LocalDate.parse((aluguer.get(i).getDataFim()));
                            long dias = DAYS.between(dataInicio, dataFim);
                            aluguer.get(i).setValor(valor * dias);
                            bd.updAluguer(aluguer.get(i), idAl);
                            break;
                            
                    }
                    ex = true;
                    break;
                }
            if((i == aluguer.size() - 1) && ex == false)
                System.out.println("Aluguer Nao Identificado.");
        }       
    }*/
    
}
