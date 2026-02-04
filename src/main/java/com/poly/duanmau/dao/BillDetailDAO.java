/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.duanmau.dao;

import com.poly.duanmau.entities.BillDetail;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
public interface BillDetailDAO extends CrudDAO<BillDetail, Integer>{
    List<BillDetail> findByBillId(int billId);
}
