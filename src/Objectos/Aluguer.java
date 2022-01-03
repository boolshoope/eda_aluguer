/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;

import java.util.Date;

/**
 *
 * @author isacl
 */
public class Aluguer {
    private int idCliente;
    private int idAutomovel;
    private Date dataInicio;
    private Date dataFim;

    public Aluguer(int idCliente, int idAutomovel, Date dataInicio, Date dataFim) {
        this.idCliente = idCliente;
        this.idAutomovel = idAutomovel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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
    
    
}
