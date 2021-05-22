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
public class UsuarioDAO {

    private static UsuarioDAO instance;
    private final String Tabela = "usuario";

    private UsuarioDAO() {
        MySQLDAO.getConnection();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    public long create(Usuario objeto) {
        String query = "INSERT INTO " + Tabela + " (nome, senha) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, objeto.getNome(), objeto.getSenha());
    }

    public void update(Usuario objeto) {
        String query = "UPDATE " + Tabela + " SET Nome=?, senha=? WHERE id = ?";
        MySQLDAO.executeQuery(query, objeto.getNome(), objeto.getSenha(), objeto.getId());

    }

    public void delete(Usuario objeto) {
        MySQLDAO.executeQuery("DELETE FROM " + Tabela + " WHERE id = ?", objeto.getId());
    }

    public ArrayList<Usuario> findAll() {
        return lista("SELECT * FROM " + Tabela + " ORDER BY id");
    }

    public ArrayList<Usuario> lista(String query) {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);

        try {
            while (rs.next()) {
                Usuario c = new Usuario();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSenha(rs.getString("senha"));
                lista.add(c);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Usuario find(int id) {
        Usuario result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM " + Tabela + " WHERE id=?", id);
        try {
            if (rs.next()) {
                Usuario c = new Usuario();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSenha(rs.getString("senha"));
                result = c;

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int findId(Usuario objeto) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM " + Tabela + " WHERE nome= ? and senha= ? "
                , objeto.getNome(), objeto.getSenha());
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
