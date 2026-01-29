/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.dao.impl;

import com.poly.duanmau.dao.DrinkDAO;
import com.poly.duanmau.entities.Category;
import com.poly.duanmau.entities.Drink;
import com.poly.duanmau.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
public class DrinkDAOImpl implements DrinkDAO{

    @Override
    public List<Drink> getDrinksByCategoryId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Drink> getAll() {
//      Hàm này sẽ sử dụng cho chức năng hiển thị danh sách thức uống lên UI
//      Hiển thị lên JTable 

//      Nội dung muốn hiển thị: Tất cả thông tin của thức uống và TÊN DANH MỤC của thức uống 

//      Lấy danh sách drink có category id
//      duyệt qua danh sách tại từng item lấy tên danh mục theo id 
        
        List<Drink> drinks = new ArrayList();
        try{
            String sql = "SELECT d.* ,c.name as cat_name FROM drinks d JOIN categories c ON d.category_id=c.id";
            
            ResultSet resultSet = XJdbc.executeQuery(sql);
            
            while(resultSet.next()){
                Drink drink = new Drink();
                drink.setId(resultSet.getInt("id"));
                drink.setName(resultSet.getString("name"));
                drink.setUnitPrice(resultSet.getInt("unit_price"));
                drink.setDiscount(resultSet.getInt("discount"));
                drink.setImage(resultSet.getString("image"));
                drink.setAvailable(resultSet.getBoolean("available"));
                
                Category category = new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("cat_name"));
                
                drink.setCategory(category);
                
                drinks.add(drink);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return drinks;
    }

    @Override
    public Drink getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Drink create(Drink entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Drink entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Drink entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
