/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Gruda
 */
public class server {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        //mendefinisikan registry
        Registry reg = LocateRegistry.createRegistry(212);
        implementasi im = new implementasi();
        reg.rebind("barang", im);
        System.out.println("Server Telah Berjalan");
    }
}
