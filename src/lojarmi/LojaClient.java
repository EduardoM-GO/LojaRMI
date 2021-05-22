/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojarmi;

import Modelo.Produto;
import Modelo.Usuario;
import java.rmi.Naming;
import java.util.List;

/**
 *
 * @author Eduardo M
 */
public class LojaClient {
    
    public boolean Validar_Login(Usuario u) {
        try {
            Loja c = (Loja) Naming.lookup("//192.168.100.71/LojaService");
            return c.Login(u);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }        
    }
    
    public List<Produto> CarregarProduto() {
        try {
            Loja c = (Loja) Naming.lookup("//192.168.100.71/LojaService");
            return c.CarregarProduto();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }        
    }

    public Produto PesquisaProduto(int id) {
        try {
            Loja c = (Loja) Naming.lookup("//192.168.100.71/LojaService");
            return c.PesquisaProduto(id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }        
    }
    
    public void VendaProduto(Produto p) {
        try {
            Loja c = (Loja) Naming.lookup("//192.168.100.71/LojaService");
            c.VendaProduto(p);
        } catch (Exception e) {
            System.out.println(e);
        }        
    }
}
