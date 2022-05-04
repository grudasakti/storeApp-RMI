/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gruda
 */
public interface crudInterface extends Remote{
    //mendefinisikan method yang akan dilempar ke RemoteException
    public barang insert(barang brg) throws RemoteException;
    public barang update(barang brg) throws RemoteException;
    public barang delete(int id) throws RemoteException;
    public barang getBarang(int id) throws RemoteException;
    public List<barang> getAll() throws RemoteException;
}
