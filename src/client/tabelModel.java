/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import crud.barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gruda
 */
public class tabelModel extends AbstractTableModel{
    private List<barang> list = new ArrayList<>();
    
    public tabelModel(){
    }
    
    //untuk mendapatkan data
    public barang get(int row){
        return list.get(row);
    }
    
    //menambahkan data
    public void insert(barang b){
        list.add(b);
        fireTableDataChanged();
    }
    
    //mengupdate data
    public void update(int row, barang b){
        list.set(row, b);
        fireTableDataChanged();
    }
    
    //menghapus data
    public void delete(int row){
        list.remove(row);
        fireTableDataChanged();
    }
    
    //menampilkan data setelah terjadi perubahan
    public void setData(List<barang> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    //menentukan jumlah baris pada table
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    //menentukan jumlah kolom pada table
    @Override
    public int getColumnCount() {
        return 4;
    }

    //mengambil dan menampilkan data ke dalam kolom yang ditentukan
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getStok();
            case 3:
                return list.get(rowIndex).getHarga();
            
            default:
                return null;
        }
    }
    
    //pemberian nama kolom
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Stok";
            case 3:
                return "Harga";
            
            default:
                return null;
        }
    }
}
