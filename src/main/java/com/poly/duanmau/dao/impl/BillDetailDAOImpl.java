/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.dao.impl;

import com.poly.duanmau.dao.BillDetailDAO;
import com.poly.duanmau.entities.BillDetail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
public class BillDetailDAOImpl implements BillDetailDAO{

    @Override
    public List<BillDetail> getAll() {
        return null;
    }

    @Override
    public BillDetail getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BillDetail create(BillDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(BillDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(BillDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BillDetail> findByBillId(int billId) {
        List<BillDetail> billDetails = new ArrayList();
        String sql = "SELECT * FROM bill_details WHERE bill_id=?";
        return billDetails;
    }
    
}
