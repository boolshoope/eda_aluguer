/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda_aluguer;

import BaseDeDados.BD;
import Objectos.*;
import java.util.LinkedList;

/**
 *
 * @author isacl
 */
public class Menu {

    public static LinkedList<Aluguer> lstAluguer;
    public static LinkedList<Automovel> lstAutomovel;
    public static LinkedList<Cliente> lstCliente;

    private static int opEsc;

    static void MainMenu() {
        InicializarLista();

        int opEsc = 0;
        System.out.println("|*********** Sistema do Aluguer de uma Frota de Automóveis ***********|");

        do {
            System.out.println("|*********** MENU PRINCIPAL ***********|");
            System.out.println("Selecione a opção:");
            System.out.println("1. Inserir");
            System.out.println("2. Alterar");
            System.out.println("3. Listagem");
            System.out.println("4. Eliminar");
            System.out.println("5. Sair");

            //opEsc = (int) Validar.numero("-> ", 1, 5);
            switch (opEsc) {
                case 1:
                    System.out.println("|**** Inserir ****|");
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
                    System.out.println("\n|**** Eliminar ****|");
                    MainCase4();
                    break;
                case 5:
                    //GravarVectores();
                    System.out.println("Obrigado.");
                    System.exit(0);
                    break;
            }
            System.out.println("");
        } while (opEsc != 5);
    }

    static void InicializarLista() {
        BD bd = new BD();
        lstAluguer = bd.getAluguer();
        lstAutomovel = bd.getAutomovel();
        lstCliente = bd.getCiente();
    }

    static void MainCase1() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Alugueres");
        System.out.println("2. Clientes");
        System.out.println("3. Automóveis");
        System.out.println("4. Voltar");

        //opEsc = (int) Validar.numero("-> ", 1, 4);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Adicionar Alugueres ****|");

                break;
            case 2:
                System.out.println("\n|**** Adicionar Clientes ****|");
                break;
            case 3:
                System.out.println("\n|**** Adicionar Automóveis ****|");
                break;
        }
    }

    static void MainCase2() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Alugueres");
        System.out.println("2. Clientes");
        System.out.println("3. Automóveis");
        System.out.println("4. Voltar");

        //opEsc = (int) Validar.numero("-> ", 1, 4);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Alterar Alugueres ****|");

                break;
            case 2:
                System.out.println("\n|**** Alterar Clientes ****|");
                break;
            case 3:
                System.out.println("\n|**** Alterar Automóveis ****|");
                break;
        }
    }

    static void MainCase3() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Alugueres");
        System.out.println("2. Clientes");
        System.out.println("3. Automóveis");
        System.out.println("4. Voltar");

        //opEsc = (int) Validar.numero("-> ", 1, 4);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Listar Alugueres ****|");

                break;
            case 2:
                System.out.println("\n|**** Listar Clientes ****|");
                break;
            case 3:
                System.out.println("\n|**** Listar Automóveis ****|");
                break;
        }
    }

    static void MainCase4() {
        System.out.println("Selecione a opção:");
        System.out.println("1. Alugueres");
        System.out.println("2. Clientes");
        System.out.println("3. Automóveis");
        System.out.println("4. Voltar");

        //opEsc = (int) Validar.numero("-> ", 1, 4);
        switch (opEsc) {
            case 1:
                System.out.println("|**** Eliminar Alugueres ****|");

                break;
            case 2:
                System.out.println("\n|**** Eliminar Clientes ****|");
                break;
            case 3:
                System.out.println("\n|**** Eliminar Automóveis ****|");
                break;
        }
    }
}
