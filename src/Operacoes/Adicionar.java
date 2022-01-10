/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;
import java.util.*;
import Objectos.*;
import java.io.*;
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
    
    public Adicionar(){
     
        r = new Random();
        c = new Cliente();
        a = new Automovel();
        al = new Aluguer();
        va = new Validar();
       
    }
    
     public void addCliente(LinkedList<Cliente> cliente) throws IOException{
        
        c.setIdCliente(r.nextInt(999));
        c.setNome(va.validarString(3, 50, "Nome do Cliente: "));
        c.setBi(va.validarString(3, 15, "Numero de BI: "));
        c.setMorada(va.validarString(3, 50, "Morada/Endereco do Cliente: "));
        c.setCartaDeConducao(va.validarString(3, 50, "Carta de Conducao: "));
        cliente.add(c);
        System.out.println("CLIENTE CADASTRADO COM SUCESSO");
    
    }
    
    public void addAutomovel(LinkedList<Automovel> automovel) throws IOException{
        
        a.setIdAutomovel(r.nextInt(999));
        a.setMarca(va.validarString(3, 20, "Marca do Automovel: " ));
        a.setMatricula(va.validarString(3, 20, "Matricula do Automovel: "));
        a.setModelo(va.validarString(3, 50, "Modelo do Automovel: "));
        a.setAnoAquisicao(va.validarInt(1900, 2022,"Ano de Aquisicao: "));
        a.setCilindrada(va.validarString(3, 50, "Clindrada do Automovel: "));
        a.setCor(va.validarString(3, 20, "Cor do Automovel: "));
        a.setValorDia(va.validarDouble(1.0, 10000.0, "Valor do Aluguer Por Dia"));
        automovel.add(a);    
        System.out.println("INFORMACOES DO CARRO REGISTADAS.");
        
    }
     
}
