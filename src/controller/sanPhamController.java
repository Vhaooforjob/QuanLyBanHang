/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.KhachHang;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class sanPhamController {

    private JButton btnAdd2;
    private JButton btnBack;
    private JTextField jtfMaSP;
    private JTextField jtfTenSP;
    private JTextField jtfGia;
    private JTextField jtfSoLuong;
    private JCheckBox jcbTT;
    private JLabel jlbImg;

    public sanPhamController(JButton btnAdd2, JButton btnBack, JTextField jtfMaSP, JTextField jtfTenSP, JTextField jtfGia, JTextField jtfSoLuong, JCheckBox jcbTT, JLabel jlbImg) {
        this.btnAdd2 = btnAdd2;
        this.btnBack = btnBack;
        this.jtfMaSP = jtfMaSP;
        this.jtfTenSP = jtfTenSP;
        this.jtfGia = jtfGia;
        this.jtfSoLuong = jtfSoLuong;
        this.jcbTT = jcbTT;
        this.jlbImg = jlbImg;
    }

    public void setView(SanPham sp) {
        jtfMaSP.setText("#" + sp.getMaSP());
        jtfTenSP.setText(sp.getTenSP());
        int gia = sp.getGia();
        jtfGia.setText(String.valueOf(gia));
        int sl = sp.getSoLuong();
        jtfSoLuong.setText(String.valueOf(sl));
        jcbTT.setSelected(sp.isTrangThai());
        jlbImg.setText(sp.getImage());
    }
}
