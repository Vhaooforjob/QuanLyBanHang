/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ublity;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.KhachHang;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class classTableModel {
    public DefaultTableModel setTableKhachHang(List<KhachHang> listItem,String[] listColumn){
        DefaultTableModel dtm=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns=listColumn.length;
        Object[]obj=null;
        int rows=listItem.size();
        if(rows>0){
            for(int i=0;i<rows;i++){
                KhachHang kh=listItem.get(i);
                obj =new Object[columns];
                obj[0]=(i+1);
                obj[1]=kh.getMaKH();
                obj[2]=kh.getTenKH();
                obj[3]=kh.getDiaChi();
                obj[4]=kh.getSodienthoai();
                obj[5]=kh.isTinhTrang();
                dtm.addRow(obj);
                
            }
        }
        return dtm;
    }
    public DefaultTableModel setTableSanPham(List<SanPham> listItem2,String[] listColumn2){
        DefaultTableModel dtm=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn2);
        int columns=listColumn2.length;
        Object[]obj=null;
        int rows=listItem2.size();
        if(rows>0){
            for(int i=0;i<rows;i++){
                SanPham sp=listItem2.get(i);
                obj =new Object[columns];
                obj[0]=(i+1);
                obj[1]=sp.getMaSP();
                obj[2]=sp.getTenSP();
                obj[3]=sp.getGia();
                obj[4]=sp.getSoLuong();
                obj[5]=sp.isTrangThai();
                obj[6]=sp.getImage();
                dtm.addRow(obj);                
            }
        }
        return dtm;
    }
    public DefaultTableModel setTableHoaDon(List<HoaDon> listItem3,String[] listColumn3){
        DefaultTableModel dtm=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn3);
        int columns=listColumn3.length;
        Object[]obj=null;
        int rows=listItem3.size();
        if(rows>0){
            for(int i=0;i<rows;i++){
                HoaDon hd=listItem3.get(i);
                obj =new Object[columns];
                obj[0]=hd.getMaHD();
                obj[1]=hd.getTongTien();
                obj[2]=hd.getNgayMua();
                obj[3]=hd.isTinhTrang();
                obj[4]=hd.getMaKH();
                dtm.addRow(obj);                
            }
        }
        return dtm;
    }
}
