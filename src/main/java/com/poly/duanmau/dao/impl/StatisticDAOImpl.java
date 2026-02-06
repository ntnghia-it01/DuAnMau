/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.duanmau.dao.impl;

import com.poly.duanmau.dao.StatisticDAO;
import com.poly.duanmau.entities.Drink;
import com.poly.duanmau.entities.User;
import com.poly.duanmau.utils.XJdbc;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
public class StatisticDAOImpl implements StatisticDAO{

    @Override
    public double statisticBillFinish(String startTime, String endTime) {
        try{
            String sql = "SELECT SUM(total_price) as bill_total FROM bills b JOIN " +
            "(SELECT SUM((unit_price * (100 - discount)/100) * quantity) as total_price, bill_id " +
            "FROM bill_details GROUP BY bill_id) AS sum_detail " +
            "ON id = bill_id " +
            "WHERE status = 3 ";
        
//            "AND (check_in BETWEEN '2026-01-01' AND '2026-02-01')";

            if(startTime != null && endTime != null){
                sql += "AND check_in BETWEEN '"+ startTime +"' AND '"+ endTime +"'";
            }else if(startTime != null){
                sql += "AND check_in >= '"+ startTime +"'";
            }else if(endTime != null){
                sql += "AND check_in <= '"+ endTime +"'";
            }

            ResultSet resultSet = XJdbc.executeQuery(sql);
            while(resultSet.next()){
                double totalPrice = resultSet.getDouble("bill_total");
                return totalPrice;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public List<Drink> statisticTop5Drink(String startTime, String endTime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> statisticTopUserBill(String startTime, String endTime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
