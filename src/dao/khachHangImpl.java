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
import model.KhachHang;
public class khachHangImpl implements khachHangDao{

    @Override
    public List<KhachHang> getList() {
        try {
            Connection cons=DBConnect.getConnection();
            String sql ="Select * from KHACHHANG";
            List<KhachHang> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
               KhachHang kh=new KhachHang();
                kh.setMaKH(rs.getInt("MAKH"));
                kh.setTenKH(rs.getString("TENKH"));
                kh.setDiaChi(rs.getString("DIACHI"));
                kh.setSodienthoai(rs.getString("SDT"));
                kh.setTinhTrang(rs.getBoolean("TT"));
                list.add(kh);
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
        khachHangDao khDao=new khachHangImpl();
        System.out.println(khDao.getList());
    }
}
