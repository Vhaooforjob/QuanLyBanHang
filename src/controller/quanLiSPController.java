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
import model.KhachHang;
import model.SanPham;
import service.khachHangService;
import service.sanPhamService;
import service.sanPhamServiceImpl;
import ublity.classTableModel;
import webbanhang.khachHangJFrame;
import webbanhang.sanPhamJFrame;

/**
 *
 * @author Admin
 */
public class quanLiSPController {

    private JPanel jpnView2;
    private JButton btnAdd2;
    private JTextField jtfSearch2;
    private sanPhamService spService = null;
    private String[] listColumn = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Giá tiền", "Số lượng", "Tình trạng", "Hình ảnh"};
    private TableRowSorter<TableModel> rowSorter = null;

    public quanLiSPController(JPanel jpnView2, JButton btnAdd2, JTextField jtfSearch2) {
        this.jpnView2 = jpnView2;
        this.btnAdd2 = btnAdd2;
        this.jtfSearch2 = jtfSearch2;
        this.spService = new sanPhamServiceImpl();
    }

    public void setDataToModel() {
        List<SanPham> listItem2 = spService.getList();
        DefaultTableModel model = new classTableModel().setTableSanPham(listItem2, listColumn);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch2.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1)); // 1 là chỉ số cột của trường "MaSP"
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch2.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1)); // 1 là chỉ số cột của trường "MaSP"
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != 1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                    SanPham sp = new SanPham();
                    sp.setMaSP((int) model.getValueAt(selectedRowIndex, 1));
                    sp.setTenSP(model.getValueAt(selectedRowIndex, 2).toString());
                    sp.setGia((int) model.getValueAt(selectedRowIndex, 3));
                    sp.setSoLuong((int) model.getValueAt(selectedRowIndex, 4));
                    sp.setTrangThai((boolean) model.getValueAt(selectedRowIndex, 5));
                    sp.setImage(model.getValueAt(selectedRowIndex, 6).toString());

                    sanPhamJFrame frame = new sanPhamJFrame(sp);
                    frame.setTitle("Thông tin Sản phẩm");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                    frame.setImage(sp.getImage());
                    frame.setVisible(true);
                }
            }

        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 1400));
        jpnView2.removeAll();
        jpnView2.setLayout(new BorderLayout());
        jpnView2.add(scrollPane);
        jpnView2.validate();
        jpnView2.repaint();

    }

    public void setEvent() {
        btnAdd2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sanPhamJFrame jFrame = new sanPhamJFrame(new SanPham());
                jFrame.setTitle("Them thong tin");
                jFrame.setLocationRelativeTo(null);
                jFrame.setResizable(false);
                jFrame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd2.setBackground(new Color(0, 200, 83));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd2.setBackground(new Color(100, 221, 23));

            }

        });
    }
}
