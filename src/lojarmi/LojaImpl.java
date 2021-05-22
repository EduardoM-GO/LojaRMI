/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojarmi;

import Controle.Controle_Produto;
import Controle.Controle_Usuario;
import Modelo.Produto;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Eduardo M
 */
public class LojaImpl
        extends java.rmi.server.UnicastRemoteObject
        implements Loja {

    public LojaImpl()
            throws java.rmi.RemoteException {
        super();
    }

    public boolean Login(Usuario u)
            throws java.rmi.RemoteException {
        Controle_Usuario crud = new Controle_Usuario();
        return crud.isExist(crud.findId(u));

    }

    public List<Produto> CarregarProduto(){
        Controle_Produto crud = new Controle_Produto();
        return crud.lista();
    }
    public Produto PesquisaProduto(int id){
        Controle_Produto crud = new Controle_Produto();
        return crud.find(id);
    }
    public void VendaProduto(Produto p){
        Controle_Produto crud = new Controle_Produto();
        crud.update(p);
    }
}
