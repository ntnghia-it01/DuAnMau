/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.dao.impl;

import com.poly.duanmau.dao.BillDAO;
import com.poly.duanmau.entities.Bill;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
public class BillDAOImpl implements BillDAO{

    @Override
    public List<Bill> findByUserId(int userId) {
        String sql = "SELECT * FROM bills WHERE user_id=?";
        return null;
    }

    @Override
    public List<Bill> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bill getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bill create(Bill entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Bill entity) {
//        Không dùng
    }

    @Override
    public void delete(Bill entity) {
//        Không dùng 
    }

    @Override
    public void updateStatus(int status, int billId, int userId) {
        try{
//          Có được thông tin đơn hàng ở DB 
            Bill bill = this.getById(billId);
            if(bill.getUser().getId() != userId){
//              Lỗi đơn hàng không phải của bạn không được sửa
                return;
            }
            
            if(status > bill.getStatus() && status == bill.getStatus() + 1){
//              Update status 
                String update = "UPDATE FROM bills SET status=? WHERE id=?";
                return;
            }
            
//          Lỗi không thể cập nhật trạng thái 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

// 1: Chờ thanh toán
// 2: Đã thanh toán
// 3: Đã hoàn thành
// 4: Huỷ đơn
