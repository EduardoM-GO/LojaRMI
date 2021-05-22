/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Produto;
import Modelo.ProdutoDAO;
import java.util.ArrayList;

/**
 *
 * @author Eduardo M
 */
public class Controle_Produto {
    public Controle_Produto() {
    }

    public void Inserir(Produto objeto) {
        ProdutoDAO.getInstance().create(objeto);
    }

    public void update(Produto objeto) {
        ProdutoDAO.getInstance().update(objeto);
    }

    public void delete(Produto objeto) {
        ProdutoDAO.getInstance().delete(objeto);
    }

    public Produto find(int id) {
        return ProdutoDAO.getInstance().find(id);
    }

    public int findId(Produto objeto) {
        return ProdutoDAO.getInstance().findId(objeto);
    }

    public Boolean isExist(int id) {
        return ProdutoDAO.getInstance().isExist(id);
    }

    public ArrayList<Produto> lista() {
        return ProdutoDAO.getInstance().findAll();
    }
}
