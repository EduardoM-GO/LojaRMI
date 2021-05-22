/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eduardo M
 */
public class ProdutoDAO {

    private static ProdutoDAO instance;
    private final String Tabela = "produto";

    private ProdutoDAO() {
        MySQLDAO.getConnection();
    }

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }
        return instance;
    }

    public long create(Produto objeto) {
        String query = "INSERT INTO " + Tabela + " (Nome, tipo, quantidade, venda,QuantidadeM) VALUES (?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, objeto.getNome(), objeto.getTipo(), objeto.getQuantidade(), objeto.getVenda(),objeto.getQuantidadeM());
    }

    public void update(Produto objeto) {
        String query = "UPDATE " + Tabela + " SET Nome=?, tipo=?, quantidade=?, venda = ?,QuantidadeM = ? WHERE id = ?";
        MySQLDAO.executeQuery(query, objeto.getNome(), objeto.getTipo(),
                objeto.getQuantidade(), objeto.getVenda(),objeto.getQuantidadeM() ,objeto.getId());

    }

    public void delete(Produto objeto) {
        MySQLDAO.executeQuery("DELETE FROM " + Tabela + " WHERE id = ?", objeto.getId());
    }

    public ArrayList<Produto> findAll() {
        return lista("SELECT * FROM " + Tabela + " ORDER BY venda");
    }

    public ArrayList<Produto> lista(String query) {
        ArrayList<Produto> lista = new ArrayList<Produto>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);

        try {
            while (rs.next()) {
                Produto c = new Produto();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("Nome"));
                c.setTipo(rs.getInt("tipo"));
                c.setQuantidade(rs.getInt("quantidade"));
                c.setQuantidadeM(rs.getInt("QuantidadeM"));
                c.setVenda(rs.getDouble("venda"));
                lista.add(c);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Produto find(int id) {
        Produto result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM " + Tabela + " WHERE id=?", id);
        try {
            if (rs.next()) {
                Produto c = new Produto();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("Nome"));
                c.setTipo(rs.getInt("tipo"));
                c.setQuantidade(rs.getInt("quantidade"));
                c.setQuantidadeM(rs.getInt("QuantidadeM"));
                c.setVenda(rs.getDouble("venda"));
                result = c;

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int findId(Produto objeto) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM " + Tabela + " WHERE Nome= ? and tipo= ? "
                + "and quantidade =  ? and venda = ? and QuantidadeM = ? ", objeto.getNome(), objeto.getTipo(),
                objeto.getQuantidade(), objeto.getVenda(),objeto.getQuantidadeM());
        try {
            if (rs.next()) {
                result = rs.getInt("id");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int id) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM " + Tabela + " WHERE id= ?", id);
        try {
            if (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
