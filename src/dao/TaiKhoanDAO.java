/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.TaiKhoan;

public interface TaiKhoanDAO {
    public TaiKhoan login(String tenDangNhap, String matKhau);
}