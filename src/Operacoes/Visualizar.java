/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.*;
import static eda_aluguer.Menu.va;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isacl
 */
public class Visualizar {

    public void visClientes(LinkedList<Cliente> cliente) {
        System.out.println("\nLISTA DOS CLIENTES CADASTRADOS\n");
        if (cliente.isEmpty()) {
            System.out.print("\nNenhum Cliente cadastrado... \n");
        } else {
            System.out.println(String.format("|%-20S|", "Id do Cliente") + String.format("%-20S|", "Nome") + String.format("%-20S|", "Morada")
                    + String.format("%-20S|", "Numero de BI") + String.format("%-20S|", "Carta de Conducao"));
            for (int i = 0; i < cliente.size(); i++) {
                System.out.print(String.format("|%-20s|", cliente.get(i).getIdCliente()));
                System.out.print(String.format("%-20s|", cliente.get(i).getNome()));
                System.out.print(String.format("%-20s|", cliente.get(i).getMorada()));
                System.out.print(String.format("%-20s|", cliente.get(i).getBi()));
                System.out.print(String.format("%-20s|", cliente.get(i).getCartaDeConducao()) + "\n");

            }

        }
    }

    public void visAutomovel(LinkedList<Automovel> a) {
        System.out.println("\nLISTA DOS  AUTOMOVEIS CADASTRADOS\n");
        if (a.isEmpty()) {
            System.out.print("Nenhum Auotmovel cadastrado... \n");
        } else {
            System.out.println(String.format("|%-20S|", "Id do Automovel") + String.format("%-20S|", "Cor") + String.format("%-20S|", "Marca")
                    + String.format("%-20S|", "Modelo") + String.format("%-20S|", "Cilindrada") + String.format("%-20S|", "Valor por dia")
                    + String.format("%-20S|", "Ano de Aquisicao"));

            for (int i = 0; i < a.size(); i++) {
                System.out.print(String.format("|%-20s|", a.get(i).getIdAutomovel()));
                System.out.print(String.format("%-20s|", a.get(i).getCor()));
                System.out.print(String.format("%-20s|", a.get(i).getMarca()));
                System.out.print(String.format("%-20s|", a.get(i).getModelo()));
                System.out.print(String.format("%-20s|", a.get(i).getCilindrada()));
                System.out.print(String.format("%-20s|", a.get(i).getValorDia()));
                System.out.print(String.format("%-20s|", a.get(i).getAnoAquisicao()) + "\n");

            }
        }

    }

    public void visAlugueres(LinkedList<Aluguer> al) {

        System.out.println("\nLISTA DOS  ALUGUERES FEITOS\n");
        if (al.isEmpty()) {
            System.out.print("\nNenhum Aluguer de Automovel Feito... \n");
        } else {
            System.out.println(String.format("|%-20S|", "Id do Aluguer") + String.format("%-20S|", "Id do Automovel") + String.format("%-20S|", "Id do Cliente")
                    + String.format("%-30S|", "Data do Inicio do Aluguer") + String.format("%-30S|", "Data do Fim do Aluguer") + String.format("%-20S|", "Valor a Pagar"));

            for (int i = 0; i < al.size(); i++) {
                System.out.print(String.format("|%-20s|", al.get(i).getIdAluguer()));
                System.out.print(String.format("%-20s|", al.get(i).getIdAutomovel()));
                System.out.print(String.format("%-20s|", al.get(i).getIdCliente()));
                System.out.print(String.format("%-30s|", al.get(i).getDataInicio()));
                System.out.print(String.format("%-30s|", al.get(i).getDataFim()));
                System.out.print(String.format("%-20s|", al.get(i).getValor()) + "\n");

            }
        }
    }

    public void pesqClientes(LinkedList<Cliente> cliente) {
        boolean found = false;
        System.out.println("\nPESQUISA DOS CLIENTES CADASTRADOS\n");
        if (cliente.isEmpty()) {
            System.out.print("\nNenhum Cliente cadastrado... \n");
        } else {
            int idCli = 0;
            try {
                idCli = va.validarID(cliente, "c");
            } catch (IOException ex) {
                Logger.getLogger(Visualizar.class.getName()).log(Level.SEVERE, null, ex);

                for (int i = 0; i < cliente.size(); i++) {
                    if (cliente.get(i).getIdCliente() == idCli) {
                        System.out.println(String.format("|%-20S|", "Id do Cliente") + String.format("%-20S|", "Nome") + String.format("%-20S|", "Morada")
                                + String.format("%-20S|", "Numero de BI") + String.format("%-20S|", "Carta de Conducao"));
                        System.out.print(String.format("|%-20s|", cliente.get(i).getIdCliente()));
                        System.out.print(String.format("%-20s|", cliente.get(i).getNome()));
                        System.out.print(String.format("%-20s|", cliente.get(i).getMorada()));
                        System.out.print(String.format("%-20s|", cliente.get(i).getBi()));
                        System.out.print(String.format("%-20s|", cliente.get(i).getCartaDeConducao()) + "\n");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.print("\nCliente nao encontrado... \n");
                }
            }
        }
    }

    public void pesqAutomovel(LinkedList<Automovel> a) {
        boolean found = false;
        System.out.println("\nPESQUISA DOS AUTOMOVEIS CADASTRADOS\n");
        if (a.isEmpty()) {
            System.out.print("\nNenhum Automovel cadastrado... \n");
        } else {
            int idCli = 0;
            try {
                idCli = va.validarID(a, "a");
            } catch (IOException ex) {
                Logger.getLogger(Visualizar.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).getIdAutomovel() == idCli) {
                    System.out.println(String.format("|%-20S|", "Id do Automovel") + String.format("%-20S|", "Cor") + String.format("%-20S|", "Marca")
                            + String.format("%-20S|", "Modelo") + String.format("%-20S|", "Cilindrada") + String.format("%-20S|", "Valor por dia")
                            + String.format("%-20S|", "Ano de Aquisicao"));

                    System.out.print(String.format("|%-20s|", a.get(i).getIdAutomovel()));
                    System.out.print(String.format("%-20s|", a.get(i).getCor()));
                    System.out.print(String.format("%-20s|", a.get(i).getMarca()));
                    System.out.print(String.format("%-20s|", a.get(i).getModelo()));
                    System.out.print(String.format("%-20s|", a.get(i).getCilindrada()));
                    System.out.print(String.format("%-20s|", a.get(i).getValorDia()));
                    System.out.print(String.format("%-20s|", a.get(i).getAnoAquisicao()) + "\n");
                    found = true;
                }
            }
            if (!found) {
                System.out.print("\nAutomovel nao encontrado... \n");
            }
        }
    }

    public void pesqAluguer(LinkedList<Aluguer> al) {
        boolean found = false;
        System.out.println("\nPESQUISA DOS CLIENTES CADASTRADOS\n");
        if (al.isEmpty()) {
            System.out.print("\nNenhum Cliente cadastrado... \n");
        } else {
            int idCli = 0;
            Date dt = null;
            try {
                idCli = va.validarID(al, "c");
                dt = va.validarData("Introduza a data: ");
            } catch (IOException ex) {
                Logger.getLogger(Visualizar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Visualizar.class.getName()).log(Level.SEVERE, null, ex);
            }

            /*for (int i = 0; i < al.size(); i++) {
                if (al.get(i).getDataFim()== idCli) {
                    System.out.println(String.format("|%-20S|", "Id do Aluguer") + String.format("%-20S|", "Id do Automovel") + String.format("%-20S|", "Id do Cliente")
                            + String.format("%-30S|", "Data do Inicio do Aluguer") + String.format("%-30S|", "Data do Fim do Aluguer") + String.format("%-20S|", "Valor a Pagar"));

                    System.out.print(String.format("|%-20s|", al.get(i).getIdAluguer()));
                    System.out.print(String.format("%-20s|", al.get(i).getIdAutomovel()));
                    System.out.print(String.format("%-20s|", al.get(i).getIdCliente()));
                    System.out.print(String.format("%-30s|", al.get(i).getDataInicio()));
                    System.out.print(String.format("%-30s|", al.get(i).getDataFim()));
                    System.out.print(String.format("%-20s|", al.get(i).getValor()) + "\n");
                    found = true;
                }
            }*/
            if (!found) {
                System.out.print("\nCliente nao encontrado... \n");
            }
        }
    }
}
