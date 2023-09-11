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
import java.sql.SQLException;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class sanPhamImpl implements sanPhamDao{
    public List<SanPham> getList() {
        try {
            Connection cons=DBConnect.getConnection();
            String sql ="Select * from SANPHAM";
            List<SanPham> list=new ArrayList<>();
            PreparedStatement ps=cons.prepareCall(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
               SanPham sp=new SanPham();
                sp.setMaSP(rs.getInt("MASP"));
                sp.setTenSP(rs.getString("TENSP"));
                sp.setGia(rs.getInt("GIA"));
                sp.setSoLuong(rs.getInt("SOLUONG"));
                sp.setTrangThai(rs.getBoolean("TT"));
                sp.setImage(rs.getString("IMG"));
                list.add(sp);
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
        sanPhamDao spDao=new sanPhamImpl();
        System.out.println(spDao.getList());
    }
}
