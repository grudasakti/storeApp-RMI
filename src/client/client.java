/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import crud.crudInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.SwingUtilities;

/**
 *
 * @author Gruda
 */
public class client {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //URL API
        crudInterface crud = (crudInterface) Naming.lookup("rmi://127.0.0.1:212/barang");

        //menjalankan JFrame
        SwingUtilities.invokeLater(() -> {
            tampilan tampilan = new tampilan(crud);
            tampilan.setVisible(true);
        });

        //notice
        System.out.println("Client Telah Berjalan");
    }
}
