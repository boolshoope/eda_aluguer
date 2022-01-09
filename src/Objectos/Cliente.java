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
public class Cliente {
    private int idCliente;
    private String nome;
    private String morada;
    private String bi;
    private String cartaDeConducao;

    public Cliente(int idCliente, String nome, String morada, String bi, String cartaDeConducao) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.morada = morada;
        this.bi = bi;
        this.cartaDeConducao = cartaDeConducao;
    }

    public Cliente() {
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getCartaDeConducao() {
        return cartaDeConducao;
    }

    public void setCartaDeConducao(String cartaDeConducao) {
        this.cartaDeConducao = cartaDeConducao;
    }
    
    @Override
    public String toString(){
        return "nome: " + nome + " morada: " + morada;
    }
    
}
