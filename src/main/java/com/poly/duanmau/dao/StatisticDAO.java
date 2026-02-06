/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.duanmau.dao;

import com.poly.duanmau.entities.Drink;
import com.poly.duanmau.entities.User;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
public interface StatisticDAO {
//  Thống kế số tiền của đơn hàng hoàn thành (doanh thu)
    double statisticBillFinish(String startTime, String endTime);
//  5 Sản phẩm có số lượng bán ra cao nhất
    List<Drink> statisticTop5Drink(String startTime, String endTime);
//  5 Nhân viên có số lượng đơn hàng nhiều nhất
    List<User> statisticTopUserBill(String startTime, String endTime);
}
