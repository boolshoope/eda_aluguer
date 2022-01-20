/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;
import java.util.*;
import Objectos.*;
import eda_aluguer.Menu;
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
    
    private final Validar va;
    private Cliente c;
    private Automovel a;
    private Aluguer al;
    private final Random r;
    
    public Adicionar(){
     
        r = new Random();
        va = new Validar();
        
       
    }
    
     public void addCliente(listaLigada<Cliente> cliente) throws IOException{
        c = new Cliente();
        c.setIdCliente(r.nextInt(999));
        c.setNome(va.validarString(3, 50, "Nome do Cliente: "));
        c.setBi(va.validarString(3, 15, "Numero de BI: "));
        c.setMorada(va.validarString(3, 50, "Morada/Endereco do Cliente: "));
        c.setCartaDeConducao(va.validarString(3, 50, "Carta de Conducao: "));
        cliente.addElemento(c);

        System.out.println("\nCliente Registado com identificacao:  "+c.getIdCliente());
    }
     
    
    public void addAutomovel(listaLigada<Automovel> automovel) throws IOException{
        a = new Automovel();
        a.setIdAutomovel(r.nextInt(999));
        a.setMarca(va.validarString(3, 20, "Marca do Automovel: " ));
        a.setMatricula(va.validarString(3, 20, "Matricula do Automovel: "));
        a.setModelo(va.validarString(3, 50, "Modelo do Automovel: "));
        a.setAnoAquisicao(va.validarInt(1900, 2022,"Ano de Aquisicao: "));
        a.setCilindrada(va.validarString(3, 50, "Clindrada do Automovel: "));
        a.setCor(va.validarString(3, 20, "Cor do Automovel: "));
        a.setValorDia(va.validarDouble(1.0, 10000.0, "Valor do Aluguer Por Dia: "));
        automovel.addElemento(a);  
        System.out.println("\nAutomovel Registado com identificacao:   "+a.getIdAutomovel());
        
        
    }
    
     
    public void addAluguer(listaLigada<Aluguer> aluguer, listaLigada<Automovel> automovel, listaLigada<Cliente> cliente) throws IOException, ParseException{
          
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        Date inicio, fim;
        String dFim, dInicio; boolean alugado = false; byte opcao;
        int posicao;
           
        al = new Aluguer();
        int idAut = 0;
        al.setIdAluguer(r.nextInt(999));
        do{
            
            idAut = va.validarID(automovel, "a");
            if (idAut == 0)
                Menu.MainCase1();
            
            for(int i = 0; i < aluguer.getSize(); i++){
                Aluguer a = (Aluguer) aluguer.getElemento(i).getInfo();
                if((a.getIdAutomovel() == idAut)){
                    System.out.println("\n"); 
                    opcao = va.validarByte((byte)0, (byte)1,"Automovel Ja Alugado."+
                                                                  "\n1. Introduzir Novamente"+
                                                                  "\n0. Cancelar Procedimento");
                            if (opcao == 0){
                                Menu.MainCase1();
                                break;
                            }else{
                                alugado = true;
                                break;
                            }
                }
                else
                    alugado = false; 
            }
            
           if(alugado == false){
                al.setIdAutomovel(idAut);
           }
        
        }while(alugado);
        
        if (alugado == false){
            al.setIdCliente(va.validarID(cliente, "c"));
            do{
                inicio = va.validarData("Data de Inicio de Aluguer:");
                fim = va.validarData("\nData de Fim de Aluguer:");

                if(fim.after(inicio) == false){
                        
                        opcao = va.validarByte((byte)0, (byte)1,"Data Invalida."+
                                                                      "\n1. Introduzir Novamente"+
                                                                      "\n0. Cancelar Procedimento");
                        if (opcao == 0)
                            Menu.MainCase1();
                }
                else{

                    dInicio = sdf.format(inicio);
                    dFim = sdf.format(fim);

                    al.setDataInicio(dInicio);
                    al.setDataFim(dFim);
                }
            }while(fim.after(inicio) == false);
            
            posicao = posicaoAluguer(aluguer);
            
            for (int i = 0; i < automovel.getSize(); i++){
                a = (Automovel) automovel.getElemento(i).getInfo();
                    if (a.getIdAutomovel() == idAut){
                        al.setValor(calculoValor(a.getValorDia()));
                        System.out.println("\nAluguer Registado com identificacao:  "+al.getIdAluguer()+"\nValor de Aluguer do Automovel Por Dia: " + a.getValorDia()
                                +"\nValor Total a Pagar Pelo Aluguer: "+al.getValor());
                        aluguer.addOrdenado(posicao, al);
                    }
            }
                        
        }
    }
    
    public double calculoValor (double valorDia) throws IOException{
        LocalDate inicio = LocalDate.parse((al.getDataInicio()));
        LocalDate fim = LocalDate.parse((al.getDataFim()));
        long dias = DAYS.between(inicio, fim);
    
        return valorDia * dias;
    }
    
    public int posicaoAluguer (listaLigada<Aluguer> aluguer){
        LocalDate  dataPosActual, dataAluguerNovo = LocalDate.parse(al.getDataInicio());
        int pos = 0;
        for (int i = 0; i < aluguer.getSize(); i++){
             dataPosActual = LocalDate.parse(aluguer.getElemento(i).getInfo().getDataInicio());
             if (dataPosActual.isAfter(dataAluguerNovo) || dataPosActual.isEqual(dataAluguerNovo))
                 return i;    
        }
        return pos;
    }
}
