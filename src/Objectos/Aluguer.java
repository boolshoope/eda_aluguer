/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;

import java.sql.Date;

/**
 *
 * @author isacl
 */
public class Aluguer {
    private int idAluguer;
    private int idCliente;
    private int idAutomovel;
    private Date dataInicio;
    private Date dataFim;

    public Aluguer(int idAluguer, int idCliente, int idAutomovel, Date dataInicio, Date dataFim) {
        this.idAluguer = idAluguer;
        this.idCliente = idCliente;
        this.idAutomovel = idAutomovel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Aluguer() {
    }
    
    

    public int getIdAluguer() {
        return idAluguer;
    }

    public void setIdAluguer(int idAluguer) {
        this.idAluguer = idAluguer;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(int idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Aluguer{" + "idAluguer=" + idAluguer + ", idCliente=" + idCliente + ", idAutomovel=" + idAutomovel + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + '}';
    }

    
}
