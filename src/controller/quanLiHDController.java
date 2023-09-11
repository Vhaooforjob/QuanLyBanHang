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
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.HoaDon;
import service.hoaDonService;
import service.hoaDonServiceImpl;
import ublity.classTableModel;
import webbanhang.hoaDonJFrame;

/**
 *
 * @author Admin
 */
public class quanLiHDController {
     private JPanel jpnView3;
  private JButton btnAdd3;
  private JTextField jtfSearch3;
  private hoaDonService hdService= null;
  private String []listColumn={"Mã hóa đơn","Tổng tiền","Ngày","Tình trạng","Mã khách hàng"};
  private TableRowSorter<TableModel> rowSorter=null;

    public quanLiHDController(JPanel jpnView3, JButton btnAdd3, JTextField jtfSearch3) {
        this.jpnView3 = jpnView3;
        this.btnAdd3 = btnAdd3;
        this.jtfSearch3 = jtfSearch3;
        this.hdService=new hoaDonServiceImpl();
    }
    
  public void setDataToModel(){
      List<HoaDon> listItem=hdService.getList();
      DefaultTableModel model =new classTableModel().setTableHoaDon(listItem, listColumn);
      JTable table=new JTable(model);
      rowSorter=new TableRowSorter<>(table.getModel());
      table.setRowSorter(rowSorter);
      
      jtfSearch3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch3.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0)); // 0 là chỉ số cột của trường "MaSP"
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch3.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0)); // 0 là chỉ số cột của trường "MaSP"
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
                  HoaDon hd=new HoaDon();                    
                hd.setMaHD((int) model.getValueAt(selectedRowIndex, 1));
                 hd.setTongTien((int) model.getValueAt(selectedRowIndex, 2));
                hd.setNgayMua((Date)model.getValueAt(selectedRowIndex, 3));
                hd.setTinhTrang((boolean) model.getValueAt(selectedRowIndex, 4));
                 hd.setMaKH((int) model.getValueAt(selectedRowIndex, 5));
                
                hoaDonJFrame frame=new hoaDonJFrame(hd);
                frame.setTitle("Thông tin hoá đơn");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
              } 
          }
          
      });
      
      
      JScrollPane scrollPane=new JScrollPane();
      scrollPane.getViewport().add(table);
      scrollPane.setPreferredSize(new Dimension(1300,1400));
      jpnView3.removeAll();
      jpnView3.setLayout(new BorderLayout());
      jpnView3.add(scrollPane);
      jpnView3.validate();
      jpnView3.repaint();
       
  }
   public void setEvent(){
          btnAdd3.addMouseListener(new MouseAdapter(){
              @Override
              public void mouseClicked(MouseEvent e) {
                  hoaDonJFrame jFrame=new hoaDonJFrame(new HoaDon());
                  jFrame.setTitle("Them thong tin");
                  jFrame.setLocationRelativeTo(null);
                  jFrame.setResizable(false);
                  jFrame.setVisible(true);
              }

              @Override
              public void mouseEntered(MouseEvent e) {
                  btnAdd3.setBackground(new Color(0,200,83));
                  
              }

              @Override
              public void mouseExited(MouseEvent e) {
                    btnAdd3.setBackground(new Color(100,221,23));

              }
              
          });
      }
}
