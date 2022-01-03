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
public class Automovel {
    private int idAutomovel;
    private String cor;
    private String marca;
    private String modelo;
    private String cilindrada;
    private double valorDia;
    private String matricula;
    private int anoAquisicao;

    public Automovel(int idAutomovel, String cor, String marca, String modelo, String cilindrada, double valorDia, String matricula, int anoAquisicao) {
        this.idAutomovel = idAutomovel;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.valorDia = valorDia;
        this.matricula = matricula;
        this.anoAquisicao = anoAquisicao;
    }

    public int getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(int idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoAquisicao() {
        return anoAquisicao;
    }

    public void setAnoAquisicao(int anoAquisicao) {
        this.anoAquisicao = anoAquisicao;
    }
    
    
}
