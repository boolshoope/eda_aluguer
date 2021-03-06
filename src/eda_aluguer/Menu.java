/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda_aluguer;

import Objectos.*;
import Operacoes.*;
import Operacoes.Validar;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author isacl
 */

public class Menu {
    public static listaLigada<Aluguer> lstAluguer = new listaLigada<>();
    public static listaLigada<Automovel> lstAutomovel = new listaLigada<>();
    public static listaLigada<Cliente> lstCliente = new listaLigada<>();
    public static Adicionar add  = new Adicionar();
    public static Editar edit  = new Editar();
    public static Remover remove  = new Remover();
    public static Visualizar visualizar  = new Visualizar();
    
    public static Validar va = new Validar();

    private static int opEsc;

   static void MainMenu() throws IOException, ParseException {

        int opEsc = 0;
        System.out.println("|*********** SISTEMA DE ALUGUER DE UMA FROTA DE AUTOMOVEIS ***********|");

        do {
            System.out.println("\n|*********** MENU PRINCIPAL ***********|\n");
            System.out.println("Selecione a opção:");
            System.out.println("1. Inserir");
            System.out.println("2. Alterar");
            System.out.println("3. Listagem");
            System.out.println("4. Pesquisa");
            System.out.println("5. Eliminar");
            System.out.println("6. Sair\n");

            opEsc = va.validarInt(0,6, ">> Sua Opcao:\t");
            switch (opEsc) {
                case 1:
                    System.out.println("\n|**** Inserir ****|");
                    MainCase1();
                    break;
                case 2:
                    System.out.println("\n|**** Alterar ****|");
                    MainCase2();
                    break;
                case 3:
                    System.out.println("\n|**** Listagem ****|");
                    MainCase3();
                    break;
                case 4:
                    System.out.println("\n|**** Pesquisa ****|");
                    MainCasePesq();
                    break;
                case 5:
                    System.out.println("\n|**** Eliminar ****|");
                    MainCase4();
                    break;
                case 6:
                    //GravarVectores();
                    System.out.println("Obrigado.");
                    System.exit(0);
                    break;
            }
            System.out.println("");
        } while (opEsc != 6);
    }


    public static void MainCase1() throws IOException, ParseException {
        
        do{
        System.out.println("\nSelecione a opção:");
        System.out.println("1. Adicionar Alugueres");
        System.out.println("2. Adicionar Clientes");
        System.out.println("3. Adicionar Automóveis");
        System.out.println("4. Voltar\n");

        opEsc = va.validarInt(0,4, ">> Sua Opcao:\t");
        
            switch (opEsc) {
                case 1:
                    System.out.println("|**** Adicionar Alugueres ****|\n");
                  add.addAluguer(lstAluguer, lstAutomovel, lstCliente);
                    break;
                case 2:
                    System.out.println("\n|**** Adicionar Clientes ****|\n");
                    add.addCliente(lstCliente);
                    break;
                case 3:
                    System.out.println("\n|**** Adicionar Automóveis ****|\n");
                     add.addAutomovel(lstAutomovel);
                    break;
               // case 4: break;    
            }
        }while(opEsc != 4);
        MainMenu();
    }

    static void MainCase2() throws IOException, ParseException {
        
        do{
        System.out.println("\nSelecione a opção:");
        System.out.println("1. Alterar Informacoes Sobre  Alugueres");
        System.out.println("2. Alterar Infomacoes Sobre  Clientes");
        System.out.println("3. Alterar Informacoes Sobre Automóveis");
        System.out.println("4. Voltar\n");

          opEsc = va.validarInt(0,4, ">> Sua Opcao:\t");
        
            switch (opEsc) {
                case 1:
                    System.out.println("|**** Alterar Alugueres ****|");
                    AlterarAluguer();
                    break;
                case 2:
                    System.out.println("\n|**** Alterar Clientes ****|");
                    edit.alterarCliente(lstCliente);
                    break;
                case 3:
                    System.out.println("\n|**** Alterar Automóveis ****|");
                    edit.alterarAutomovel(lstAutomovel);
                    break;
            }
        }while(opEsc != 4);
    }
    
    public static void AlterarAluguer() throws IOException, ParseException{
        do{
        System.out.println("\nSelecione a opção:");
        System.out.println("1. Alterar Data De Fim e Inicio Do Aluguer");
        System.out.println("2. Alterar o Valor A Pagar Pelo Aluguer Por Dia");
        System.out.println("3. Voltar\n");
        
        opEsc = va.validarInt(0,3, ">> Sua Opcao:\t");
        
        switch(opEsc){
            
            case 1: System.out.println("\nALTERAR AS DATAS DO ALUGUER:\n");
                edit.alterarAluguer(lstAluguer, lstAutomovel, lstCliente, "data");
                break;
             case 2:System.out.print("\nALTERAR O VALOR A PAGAR PELO ALGUGUER POR DIA:\n");
                edit.alterarAluguer(lstAluguer, lstAutomovel, lstCliente, "valor");
                break;   
        }
        
        
        }while(opEsc != 3);
    }
    

    static void MainCase3() throws IOException {
        
        do{
            System.out.println("\nSelecione a opção:");
            System.out.println("1. Listagem de Alugueres");
            System.out.println("2. Listagem de Clientes");
            System.out.println("3. Listagem de Automóveis");
            System.out.println("4. Voltar\n");

             opEsc = va.validarInt(0,4, ">> Sua Opcao:\t");
            switch (opEsc) {
                case 1:
                    System.out.println("|**** Listar Alugueres ****|");
                    visualizar.visAlugueres(lstAluguer);
                    break;
                case 2:
                    System.out.println("\n|**** Listar Clientes ****|");
                    visualizar.visClientes(lstCliente);
                    break;
                case 3:
                    System.out.println("\n|**** Listar Automóveis ****|");
                    visualizar.visAutomovel(lstAutomovel, lstAluguer);
                    break;
            }
        }while(opEsc != 4);
    }
    static void MainCasePesq() throws IOException {
        
        do{
            System.out.println("\nSelecione a opção:");
            System.out.println("1. Pesquisa de Alugueres");
            System.out.println("2. Pesquisa de Clientes");
            System.out.println("3. Pesquisa de Automóveis");
            System.out.println("4. Voltar\n");

             opEsc = va.validarInt(0,4, ">> Sua Opcao:\t");
            switch (opEsc) {
                case 1:
                    System.out.println("|**** Pesquisar Alugueres ****|");
                    visualizar.pesqAluguer(lstAluguer);
                    break;
                case 2:
                    System.out.println("\n|**** Pesquisar Clientes ****|");
                    visualizar.pesqClientes(lstCliente);
                    break;
                case 3:
                    System.out.println("\n|**** Pesquisar Automóveis ****|");
                    visualizar.pesqAutomovel(lstAutomovel);
                    break;
            }
        }while(opEsc != 4);
    }

    static void MainCase4() throws IOException {
        
        do{
            System.out.println("\nSelecione a opção:");
            System.out.println("1. Eliminar Alugueres");
            System.out.println("2. Eliminar Clientes");
            System.out.println("3. Eliminar Automóveis");
            System.out.println("4. Voltar\n");

          opEsc = va.validarInt(0,4, ">> Sua Opcao:\t");
            switch (opEsc) {
                case 1:
                    System.out.println("|**** Eliminar Alugueres ****|");
                    remove.removerAluguer(lstAluguer);
                    break;
                case 2:
                    System.out.println("\n|**** Eliminar Clientes ****|");
                    remove.RemoverCliente(lstCliente);
                    break;
                case 3:
                    System.out.println("\n|**** Eliminar Automóveis ****|");                 
                    remove.RemoverAutomovel(lstAutomovel);
                    break;
         }
        }while(opEsc != 4);
    }
}
    

