/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.sanPhamDao;
import dao.sanPhamImpl;
import java.util.List;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class sanPhamServiceImpl implements sanPhamService{
    private sanPhamDao spDao= null;
    public sanPhamServiceImpl(){
        spDao =new sanPhamImpl();
    }
    public List<SanPham> getList() {
        return spDao.getList();
    }
}
