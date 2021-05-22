/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lojarmi;

import java.rmi.Naming;

/**
 *
 * @author Eduardo M
 */
public class LojaServer {
     public LojaServer() {
        try { //Fazer o registo para o porto desejado
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
            e.printStackTrace();
        }
        try {
            LojaImpl c = new LojaImpl();
            Naming.rebind("LojaService", c);
        } catch (Exception e) {
            System.out.println("Trouble:" + e);
        }
    }

    public static void main(String args[]) {
        new LojaServer();
    }
}
