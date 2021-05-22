/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojarmi;

import Modelo.Produto;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Eduardo M
 */
public interface Loja extends java.rmi.Remote {

    public boolean Login(Usuario u)
            throws java.rmi.RemoteException;

    public List<Produto> CarregarProduto()
            throws java.rmi.RemoteException;

    public Produto PesquisaProduto(int id)
            throws java.rmi.RemoteException;

    public void VendaProduto(Produto p)
            throws java.rmi.RemoteException;
}
