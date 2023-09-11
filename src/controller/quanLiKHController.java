/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;
import model.KhachHang;
import service.khachHangService;
import service.khachHangServiceImpl;
import ublity.classTableModel;
import webbanhang.khachHangJFrame;

/**
 *
 * @author Admin
 */
public class quanLiKHController {
   private JPanel jpnView;
  private JButton btnAdd;
  private JTextField jtfSearch;
  private khachHangService khService= null;
  private String []listColumn={"STT","Mã khách hàng","Tên khách hàng","Địa chỉ","Số điện thoại","Tình trạng"};
  private TableRowSorter<TableModel> rowSorter=null;

    public quanLiKHController(JPanel jpnView, JButton btnAdd1, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd1;
        this.jtfSearch = jtfSearch;
        this.khService=new khachHangServiceImpl();
    }
    
  public void setDataToModel(){
      List<KhachHang> listItem=khService.getList();
      DefaultTableModel model =new classTableModel().setTableKhachHang(listItem, listColumn);
      JTable table=new JTable(model);
      rowSorter=new TableRowSorter<>(table.getModel());
      table.setRowSorter(rowSorter);
      
      jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1)); // 0 là chỉ số cột của trường "MaSP"
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1)); // 0 là chỉ số cột của trường "MaSP"
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });
      table.getTableHeader().setFont(new Font("Arial",Font.BOLD,15));
      table.getTableHeader().setPreferredSize(new Dimension(100,50));
      table.setRowHeight(50);
      table.validate();
      table.repaint();
      
      
      table.addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked(MouseEvent e) {
              if(e.getClickCount()==2&&table.getSelectedRow()!=1){
                  DefaultTableModel model=(DefaultTableModel) table.getModel();
                  int selectedRowIndex=table.getSelectedRow();
                       selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                  KhachHang kh=new KhachHang();                    
                kh.setMaKH((int) model.getValueAt(selectedRowIndex, 1));
                kh.setTenKH(model.getValueAt(selectedRowIndex, 2).toString());
                kh.setDiaChi(model.getValueAt(selectedRowIndex, 3).toString());
                kh.setSodienthoai(model.getValueAt(selectedRowIndex, 4).toString());
                kh.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 5));
                
                
                khachHangJFrame frame=new khachHangJFrame(kh);
                frame.setTitle("Thông tin khách hàng");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
              } 
          }
          
      });
      
      
      JScrollPane scrollPane=new JScrollPane();
      scrollPane.getViewport().add(table);
      scrollPane.setPreferredSize(new Dimension(1300,1400));
      jpnView.removeAll();
      jpnView.setLayout(new BorderLayout());
      jpnView.add(scrollPane);
      jpnView.validate();
      jpnView.repaint();
       
  }
   public void setEvent(){
          btnAdd.addMouseListener(new MouseAdapter(){
              @Override
              public void mouseClicked(MouseEvent e) {
                  khachHangJFrame jFrame=new khachHangJFrame(new KhachHang());
                  jFrame.setTitle("Them thong tin");
                  jFrame.setLocationRelativeTo(null);
                  jFrame.setResizable(false);
                  jFrame.setVisible(true);
              }

              @Override
              public void mouseEntered(MouseEvent e) {
                  btnAdd.setBackground(new Color(0,200,83));
                  
              }

              @Override
              public void mouseExited(MouseEvent e) {
                    btnAdd.setBackground(new Color(100,221,23));

              }
              
          });
      }
  
}
