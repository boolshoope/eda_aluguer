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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isacl
 */
public class Editar {

    Validar v = new Validar();

    public void EditCliente() {
        try {
            Cliente tmp;
            int id, pos;
            id = (int) v.validarInt(1, 9999, "ID(disciplina): ");

            pos = -1;
            for (int i = 0; i < lstCliente.size(); i++) {
                tmp = (Cliente) lstCliente.get(i);
                if (tmp.getIdCliente() == id) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                System.out.println("Cliente nao registrado.");
                return;
            }

            tmp = (Cliente) lstCliente.get(pos);

            String nome = v.validarString(1, 999, "Nome: ");

            tmp.setNome(nome);

            lstCliente.set(pos, tmp);
        } catch (IOException ex) {
            System.out.println("" + ex.toString());
        }
    }

}
