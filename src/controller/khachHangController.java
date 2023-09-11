/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public class khachHangController {
    private JButton  btnAdd;
    private JButton btnBack;
    private JTextField jtfMaKH;
    private JTextField jtfTenKH;
    private JTextField jtfDiaChi;
    private JTextField jtfSDT;
    private JCheckBox jcbTinhTrang;

    public khachHangController(JButton btnAdd,JButton btnBack, JTextField jtfMaKH, JTextField jtfTenKH, JTextField jtfDiaChi, JTextField jtfSDT, JCheckBox jcbTinhTrang) {
        this.btnAdd = btnAdd;
         this.btnBack = btnBack;
        this.jtfMaKH = jtfMaKH;
        this.jtfTenKH = jtfTenKH;
        this.jtfDiaChi = jtfDiaChi;
        this.jtfSDT = jtfSDT;
        this.jcbTinhTrang = jcbTinhTrang;
    }
    public void setView(KhachHang kh){
        jtfMaKH.setText("#"+kh.getMaKH());
        jtfTenKH.setText(kh.getTenKH());
        jtfDiaChi.setText(kh.getDiaChi());
        jtfSDT.setText(kh.getSodienthoai());
        jcbTinhTrang.setSelected(kh.isTinhTrang());
    }
}
