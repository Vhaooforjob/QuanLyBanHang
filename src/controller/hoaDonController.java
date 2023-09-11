/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class hoaDonController {

    private JButton btnAdd3;
    private JButton btnBack3;
    private JTextField jtfMaKH;
    private JTextField jtfMaHD;
    private JTextField jtfTong;
    private JTextField jtfDate;
    private JCheckBox jcbTinhTrang;

    public hoaDonController(JButton btnAdd3, JButton btnBack3, JTextField jtfMaKH, JTextField jtfMaHD, JTextField jtfDate, JCheckBox jcbTinhTrang) {
        this.btnAdd3 = btnAdd3;
        this.btnBack3 = btnBack3;
        this.jtfMaKH = jtfMaKH;
        this.jtfMaHD = jtfMaHD;
        this.jtfDate = jtfDate;
        this.jcbTinhTrang = jcbTinhTrang;
    }

    public void setView(HoaDon hd) {
        jtfMaHD.setText("#" + hd.getMaHD());
        int tong = hd.getTongTien();
        jtfTong.setText(String.valueOf(tong));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(hd.getNgayMua());
        jtfDate.setText(formattedDate);
        jcbTinhTrang.setSelected(hd.isTinhTrang());
        int ma = hd.getMaKH();
        jtfMaKH.setText(String.valueOf(ma));
    }
}
