/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.duanmau.dao;

import com.poly.duanmau.entities.Bill;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
public interface BillDAO extends CrudDAO<Bill, Integer>{
//    findAll chỉ dùng với quyền quản trị có thể xem tất cả đơn hàng ở hệ thống
    List<Bill> findByUserId(int userId);
    void updateStatus(int status, int billId, int userId);
}
