/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gruda
 */
public class dbConnection {
    //membuat koneksi ke database
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                //jdbc sebagai perantara antara java dengan database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_toko", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
}
