/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.danhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import webbanhang.SanPhamJPanel;
import webbanhang.hoaDonJPanel;
import webbanhang.khachHangJPanel;
import webbanhang.thongKeJPanel;

/**
 *
 * @author Admin
 */
public class chuyenMHController {
    private JPanel root ;
    private String kinSelected="";
    private List<danhMucBean> listItem=null;
    public chuyenMHController(JPanel jpnRoot){
        this.root=jpnRoot;
    }
    public void setView(JPanel jpnItem,JLabel jlbItem){
        kinSelected="thongKe";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new thongKeJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<danhMucBean> listItem){
        this.listItem=listItem;
        for(danhMucBean item:listItem){
            item.getJlb().addMouseListener(new labelEvent(item.getKind(),item.getJpn(),item.getJlb()));
            
        }
    }
    class labelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public labelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "thongKe":
                    node=new thongKeJPanel();
                    break;
                case "sanPham":
                    node=new SanPhamJPanel();
                    break;
                case "hoaDon":
                    node=new hoaDonJPanel();
                    break;
                case "khachHang":
                    node=new khachHangJPanel();
                    break;
                default:
                    node=new thongKeJPanel();
                    break;
            }
            root.removeAll();
             root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kinSelected =kind;
            jpnItem.setBackground(new Color(96,100,191));
             jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
             jlbItem.setBackground(new Color(96,100,191));      
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kinSelected.equalsIgnoreCase(kind)){
                 jpnItem.setBackground(new Color(76,175,80));
                jlbItem.setBackground(new Color(76,175,80));
            }
        }
        private void setChangeBackground(String kind){
           for(danhMucBean item:listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJlb().setBackground(new Color(96,100,191));             
                item.getJpn().setBackground(new Color(96,100,191));     
            }
            else{
                item.getJlb().setBackground(new Color(76,175,80));             
                item.getJpn().setBackground(new Color(76,175,80));   
            }
            
        } 
        }
    }
}
