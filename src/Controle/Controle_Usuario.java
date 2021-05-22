/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Eduardo M
 */
public class Controle_Usuario {

    public Controle_Usuario() {
    }

    public void Inserir(Usuario objeto) {
        UsuarioDAO.getInstance().create(objeto);
    }

    public void update(Usuario objeto) {
        UsuarioDAO.getInstance().update(objeto);
    }

    public void delete(Usuario objeto) {
        UsuarioDAO.getInstance().delete(objeto);
    }

    public Usuario find(int id) {
        return UsuarioDAO.getInstance().find(id);
    }

    public int findId(Usuario objeto) {
        return UsuarioDAO.getInstance().findId(objeto);
    }

    public Boolean isExist(int id) {
        return UsuarioDAO.getInstance().isExist(id);
    }

    public ArrayList<Usuario> lista() {
        return UsuarioDAO.getInstance().findAll();
    }
}
