/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.khachHangDao;
import dao.khachHangImpl;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author Admin
 */
    public class khachHangServiceImpl implements khachHangService{
    private khachHangDao khDao= null;
    public khachHangServiceImpl(){
        khDao =new khachHangImpl();
    }
    @Override
    public List<KhachHang> getList() {
        return khDao.getList();
    }
    
}
