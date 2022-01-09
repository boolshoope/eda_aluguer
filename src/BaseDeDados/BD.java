/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDados;

import Objectos.*;
import java.util.LinkedList;
import java.sql.*;

/**
 *
 * @author isacl
 */
public class BD {

    private Connection conexao;

    public BD() {
        try {
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/eda_aluguer", "root", "");
        } catch (SQLException ex) {
            System.out.println("Erro de conexao: " + ex.getMessage());
        }
    }

    //get/selects
    public LinkedList<Cliente> getCiente() {
        LinkedList<Cliente> lstCli = new LinkedList<>();
        Cliente cli;
        ResultSet rs;

        try {
            String query = "select * from cliente";
            PreparedStatement stmt = conexao.prepareStatement(query);

            rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto do banco
                cli = new Cliente(rs.getInt("idCliente"), rs.getString("nome"), rs.getString("morada"),
                        rs.getString("bi"), rs.getString("cartaDeConducao"));
                lstCli.add(cli);
            }

            rs.close();
            stmt.close();
            return lstCli;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Aluguer> getAluguer() {
        LinkedList<Aluguer> lstAlug = new LinkedList<>();
        Aluguer alug;
        ResultSet rs;

        try {
            String query = "select * from aluguer";
            PreparedStatement stmt = conexao.prepareStatement(query);

            rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto do banco
                alug = new Aluguer(rs.getInt("idAluguer"),rs.getInt("idCliente"), rs.getInt("idAutomovel"), rs.getDate("dataInicio"), rs.getDate("dataFim"));
                lstAlug.add(alug);
            }

            rs.close();
            stmt.close();
            return lstAlug;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Automovel> getAutomovel() {
        LinkedList<Automovel> lstAut = new LinkedList<>();
        Automovel aut;
        ResultSet rs;

        try {
            String query = "select * from automovel";
            PreparedStatement stmt = conexao.prepareStatement(query);

            rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto do banco
                aut = new Automovel(rs.getInt("idCliente"), rs.getString("cor"), rs.getString("marca"), rs.getString("modelo"),
                        rs.getString("cilindrada"), rs.getDouble("valorDia"), rs.getString("matricula"), rs.getInt("anoAquisicao"));
                lstAut.add(aut);
            }

            rs.close();
            stmt.close();
            return lstAut;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //add
    public void addCliente(Cliente c) {
        String query = "INSERT INTO cliente(nome,morada,bi,cartaDeConducao) VALUES(?,?,?,?);";
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getMorada());
            stmt.setString(3, c.getBi());
            stmt.setString(4, c.getCartaDeConducao());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: " + ex.getMessage());
        }
    }
    
    public void addAluguer(Aluguer a) {
        String query = "INSERT INTO aluguer(idCliente,idAutomovel,dataInicio,dataFim) VALUES(?,?,?,?);";
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, a.getIdCliente());
            stmt.setInt(2, a.getIdAutomovel());
            stmt.setDate(3, a.getDataInicio());
            stmt.setDate(4, a.getDataFim());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: " + ex.getMessage());
        }
    }
    
    public void addAutomovel(Automovel a) {
        String query = "INSERT INTO automovel(cor,marca,modelo,cilindrada,valorDia,matricula,anoAquisicao) VALUES(?,?,?,?,?,?,?);";
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, a.getCor());
            stmt.setString(2, a.getMarca());
            stmt.setString(3, a.getModelo());
            stmt.setString(4, a.getCilindrada());
            stmt.setDouble(5, a.getValorDia());
            stmt.setString(6, a.getMatricula());
            stmt.setInt(7, a.getAnoAquisicao());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro de insercao da base de dados:: " + ex.getMessage());
        }
    }

    //update
    public void updCliente(Cliente c) {
        String query = "update cliente set nome=?,morada=?,bi=?,cartaDeConducao=? where idCliente=" + c.getIdCliente();
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getMorada());
            stmt.setString(3, c.getBi());
            stmt.setString(4, c.getCartaDeConducao());
            stmt.execute();

            System.out.println("Cliente actualizado com sucesso ");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de acualizacao de dados:: " + e.getMessage());
        }
    }
    
    public void updAluguer(Aluguer a) {
        String query = "update aluguer set idCliente=?,idAutomovel=?,dataInicio=?,dataFim=? where idAluguer=" + a.getIdAluguer();
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);

            stmt.setInt(1, a.getIdCliente());
            stmt.setInt(2, a.getIdAutomovel());
            stmt.setDate(3, a.getDataInicio());
            stmt.setDate(4, a.getDataFim());
            stmt.execute();

            System.out.println("Aluguer actualizado com sucesso ");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de acualizacao de dados:: " + e.getMessage());
        }
    }
    
    public void updAutomovel(Automovel a) {
        String query = "update automovel set cor=?,marca=?,modelo=?,cilindrada=?,valorDia=?"
                + ",matricula=?,anoAquisicao=? where idAutomovel=" + a.getIdAutomovel();
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);

            stmt.setString(1, a.getCor());
            stmt.setString(2, a.getMarca());
            stmt.setString(3, a.getModelo());
            stmt.setString(4, a.getCilindrada());
            stmt.setDouble(5, a.getValorDia());
            stmt.setString(6, a.getMatricula());
            stmt.setInt(7, a.getAnoAquisicao());
            stmt.execute();

            System.out.println("Automovel actualizado com sucesso ");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro de acualizacao de dados:: " + e.getMessage());
        }
    }

    //delete
    public void delCliente(Cliente c) {
        try {
            String query = "delete from cliente where idCliente=?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, c.getIdCliente());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delAluguer(Aluguer a) {
        try {
            String query = "delete from aluguer where idAluguer=?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, a.getIdAluguer());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delAutomovel(Automovel a) {
        try {
            String query = "delete from automovel where idAutomovel=?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, a.getIdAutomovel());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
