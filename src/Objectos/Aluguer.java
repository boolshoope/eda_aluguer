/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectos;


/**
 *
 * @author isacl
 */
public class Aluguer {
    private int idAluguer;
    private int idCliente;
    private int idAutomovel;
    private String dataInicio;
    private String dataFim;
    private double valor;

    public Aluguer(int idAluguer, int idCliente, int idAutomovel, String dataInicio, String dataFim, double valor) {
        this.idAluguer = idAluguer;
        this.idCliente = idCliente;
        this.idAutomovel = idAutomovel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Aluguer{" + "idAluguer=" + idAluguer + ", idCliente=" + idCliente + ", idAutomovel=" + idAutomovel + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", valor="+valor;
    }

    
}
