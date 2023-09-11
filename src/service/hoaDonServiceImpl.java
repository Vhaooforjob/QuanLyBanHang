/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.hoaDonDao;
import dao.hoaDonImpl;
import java.util.List;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class hoaDonServiceImpl implements hoaDonService{
    private hoaDonDao hdDao= null;
    public hoaDonServiceImpl(){
       hdDao =new hoaDonImpl();
    }
    @Override
    public List<HoaDon> getList() {
        return hdDao.getList();
    }
}
