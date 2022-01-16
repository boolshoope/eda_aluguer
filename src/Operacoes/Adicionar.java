/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;
import java.util.*;
import Objectos.*;
import BaseDeDados.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
/**
 *
 * @author isacl
 */
public class Adicionar {
    
    private Validar va;
    private Cliente c;
    private Automovel a;
    private Aluguer al;
    private Random r;
    private BD bd;
    
    public Adicionar(){
     
        r = new Random();
        va = new Validar();
        bd = new BD();
        
       
    }
    
     public void addCliente(LinkedList<Cliente> cliente) throws IOException{
        c = new Cliente();
        c.setIdCliente(r.nextInt(999));
        c.setNome(va.validarString(3, 50, "Nome do Cliente: "));
        c.setBi(va.validarString(3, 15, "Numero de BI: "));
        c.setMorada(va.validarString(3, 50, "Morada/Endereco do Cliente: "));
        c.setCartaDeConducao(va.validarString(3, 50, "Carta de Conducao: "));
        cliente.add(c);
        bd.addCliente(c);
        
        System.out.println("\nAluguer Registado. ");
    
    }
    
    public void addAutomovel(LinkedList<Automovel> automovel) throws IOException{
        a = new Automovel();
        a.setIdAutomovel(r.nextInt(999));
        a.setMarca(va.validarString(3, 20, "Marca do Automovel: " ));
        a.setMatricula(va.validarString(3, 20, "Matricula do Automovel: "));
        a.setModelo(va.validarString(3, 50, "Modelo do Automovel: "));
        a.setAnoAquisicao(va.validarInt(1900, 2022,"Ano de Aquisicao: "));
        a.setCilindrada(va.validarString(3, 50, "Clindrada do Automovel: "));
        a.setCor(va.validarString(3, 20, "Cor do Automovel: "));
        a.setValorDia(va.validarDouble(1.0, 10000.0, "Valor do Aluguer Por Dia"));
        automovel.add(a);  
        bd.addAutomovel(a);
        System.out.println("\nAutomovel Registado.  ");
        
        
    }
     
    public void addAluguer(LinkedList <Aluguer> aluguer, LinkedList<Automovel> automovel, LinkedList<Cliente> cliente) throws IOException, ParseException{
              
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); 
        Date inicio, fim;
        String dFim, dInicio; boolean alugado = false;
           
        al = new Aluguer();
        al.setIdAutomovel(r.nextInt(999));
     
        int idAut = 0;
        //l.setIdAutomovel(va.validarID(automovel, "a"));
        do{
            
            idAut = va.validarID(automovel, "a");
            for(int i=0;i<aluguer.size();i++){
                if(aluguer.get(i).getIdAutomovel()== idAut){
                    System.out.println("Automovel ja Alugado. Introduza novamente o Id do Automovel a ser alugado\n");                
                    alugado = true;
                    break;
                }else{
                    alugado = false;
                }
            }
            
           if(alugado == false){
                al.setIdAutomovel(idAut);
           }
        
        }while(alugado);
        
        
        al.setIdCliente(va.validarID(cliente, "c"));
        do{
            inicio = va.validarData("Data de Inicio de Aluguer:");
            fim = va.validarData("\nData de Fim de Aluguer:");
        
            if(fim.after(inicio) == false)
                    System.out.println("Data de Inicio e Fim de Aluguer Invalida. Introduza Novamente.");
            else{
                
                dInicio = sdf.format(inicio);
                dFim = sdf.format(fim);
                
                al.setDataInicio(dInicio);
                al.setDataFim(dFim);
            }
        }while(fim.after(inicio) == false);
        al.setValor(calculoValor());
        System.out.println("\nAluguer Registado.\nValor Total a Pagar Pelo Aluguer: "+al.getValor());
        aluguer.add(al);
        bd.addAluguer(al);
    }
    
    public double calculoValor() throws IOException{
        double valor = va.validarDouble(100, 10000, "\nIntroduza o Valor de Aluguer do Automovel Por Dia: ");
        
        LocalDate inicio = LocalDate.parse((al.getDataInicio()));
        LocalDate fim = LocalDate.parse((al.getDataFim()));
        long dias = DAYS.between(inicio, fim);
    
        return valor * dias;
    }
}
