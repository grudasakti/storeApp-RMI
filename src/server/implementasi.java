/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import crud.barang;
import crud.crudInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gruda
 */
public class implementasi extends UnicastRemoteObject implements crudInterface {
    //abstract
    public implementasi() throws RemoteException {
    }

    //implementasi semua method yang ada di crudInterface
    @Override
    public barang insert(barang brg) throws RemoteException {
        //notice
        System.out.println("Client memanggil fungsi insert");

        //manipulasi database menggunakan query dinamis dengan parameter
        PreparedStatement statement = null;

        try {
            statement = dbConnection.getConnection().prepareStatement(
                    "INSERT INTO data_barang (id, nama, stok, harga)" + " VALUES (null,'" + brg.getNama() + "', '" + brg.getStok() + "', '" + brg.getHarga() + "')", Statement.RETURN_GENERATED_KEYS);

            //mengeksekusi query
            statement.executeUpdate();

            //mengontrol letak kursor terhadap suatu baris didalam database
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                brg.setId(resultSet.getInt(1));
            }
            resultSet.close();
            return brg;

        } catch (SQLException e) {
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public barang update(barang brg) throws RemoteException {
        //notice
        System.out.println("Client memanggil fungsi update");

        //manipulasi database menggunakan query dinamis dengan parameter
        PreparedStatement statement = null;

        try {
            statement = dbConnection.getConnection().prepareStatement(
                    "UPDATE data_barang SET nama=?, stok=?, harga=? WHERE id=?");

            //memasukan nilai dari setiap parameter
            statement.setString(1, brg.getNama());
            statement.setInt(2, brg.getStok());
            statement.setInt(3, brg.getHarga());
            statement.setInt(4, brg.getId());

            //mengeksekusi query
            statement.executeUpdate();

        } catch (SQLException e) {

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }

    @Override
    public barang delete(int id) throws RemoteException {
        //notice
        System.out.println("Client memanggil fungsi delete");

        //manipulasi database menggunakan query dinamis dengan parameter
        PreparedStatement statement = null;

        try {
            statement = dbConnection.getConnection().prepareStatement(
                    "DELETE FROM data_barang WHERE id=?");

            statement.setInt(1, id);

            //mengeksekusi query
            statement.executeUpdate();

        } catch (SQLException e) {
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }

    @Override
    public barang getBarang(int id) throws RemoteException {
        //manipulasi database menggunakan query dinamis dengan parameter
        PreparedStatement statement = null;

        try {
            statement = dbConnection.getConnection().prepareStatement(
                    "SELECT * FROM data_barang WHERE id=?");

            //mengeksekusi query
            ResultSet resultSet = statement.executeQuery();

            barang barang = null;
            if (resultSet.next()) {
                barang = new barang();

                barang.setId(id);
                barang.setNama(resultSet.getString("nama"));
                barang.setStok(resultSet.getInt("stok"));
                barang.setHarga(resultSet.getInt("harga"));
            }

            return barang;

        } catch (SQLException e) {
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<barang> getAll() throws RemoteException {
        Statement statement = null;
        try {
            statement = dbConnection.getConnection().createStatement();

            //mengeksekusi query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM data_barang");

            //Membuat Objek ArrayList
            List<barang> list = new ArrayList<>();
            while (resultSet.next()) {
                barang barang = new barang();

                barang.setId(resultSet.getInt("id"));
                barang.setNama(resultSet.getString("nama"));
                barang.setStok(resultSet.getInt("stok"));
                barang.setHarga(resultSet.getInt("harga"));
                list.add(barang);
            }

            return list;

        } catch (SQLException e) {
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
