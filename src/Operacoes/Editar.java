/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes;

import Objectos.*;
import static eda_aluguer.Menu.lstAluguer;
import static eda_aluguer.Menu.lstAutomovel;
import static eda_aluguer.Menu.lstCliente;
import Objectos.Automovel;
import Objectos.Cliente;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author isacl
 */
public class Editar {

    private Validar va;
    private Cliente c;
    private Automovel a;

    public Editar() {
        va = new Validar();
        c = new Cliente();
        a = new Automovel();
    }

    public void alterarCliente(LinkedList<Cliente> cliente) throws IOException {
        int idC;
        boolean existe = true;

        idC = va.validarInt(0, 999, "ID do cliente que pretende alterar suas informacoes: ");
        for (int i = 0; i < cliente.size(); i++) {
            if (cliente.get(i).getIdCliente() == idC) {
                existe = true;

                c.setNome(va.validarString(3, 50, "Nome do Cliente: "));
                c.setBi(va.validarString(3, 15, "Numero de BI: "));
                c.setMorada(va.validarString(3, 50, "Morada/Endereco do Cliente: "));
                c.setCartaDeConducao(va.validarString(3, 50, "Carta de Conducao: "));
                cliente.set(i, c);
                System.out.print("Dados do(a) Cliente " + cliente.get(i).getIdCliente() + " Alteraos Com Sucesso ");
            }
        }
        if (existe == false) {
            System.out.println("CLIENTE NAO CADASTRADO");
        }

    }

    public void alterarAutomovel(LinkedList<Automovel> automovel) throws IOException {
        int idAutomovel;
        boolean existe = true;

        idAutomovel = va.validarInt(0, 999, "ID do Automovel que pretende alterar suas informacoes: ");
        for (int i = 0; i < automovel.size(); i++) {
            if (automovel.get(i).getIdAutomovel() == idAutomovel) {
                existe = true;
                a.setMarca(va.validarString(3, 20, "Marca do Automovel: "));
                a.setMatricula(va.validarString(3, 20, "Matricula do Automovel: "));
                a.setModelo(va.validarString(3, 50, "Modelo do Automovel: "));
                a.setAnoAquisicao(va.validarInt(1900, 2022, "Ano de Aquisicao: "));
                a.setCilindrada(va.validarString(3, 50, "Clindrada do Automovel: "));
                a.setCor(va.validarString(3, 20, "Cor do Automovel: "));
                a.setValorDia(va.validarDouble(1.0, 10000.0, "Valor do Aluguer Por Dia"));
                automovel.set(i, a);
                System.out.print("Dados Do Automovel Alterados ");
            }

            if (existe == false) {
                System.out.println("AUTOMOVEL NAO CADASTRADO..");
            }
        }
    }

}
