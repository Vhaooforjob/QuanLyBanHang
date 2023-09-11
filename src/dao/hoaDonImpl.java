/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;

public class hoaDonImpl implements hoaDonDao{
    public List<HoaDon> getList() {
        try {
            Connection cons=DBConnect.getConnection();
            String sql ="Select * from HOADON";
            List<HoaDon> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
               HoaDon hd=new HoaDon();
                hd.setMaHD(rs.getInt("MAHD"));
                hd.setTongTien(rs.getInt("TONGGIA"));
                hd.setNgayMua(rs.getDate("NGAY"));
                hd.setTinhTrang(rs.getBoolean("TT"));
                hd.setMaKH(rs.getInt("MAKH"));
                list.add(hd);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        hoaDonDao hdDao=new hoaDonImpl();
        System.out.println(hdDao.getList());
    }
}
