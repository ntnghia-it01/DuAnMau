/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.dao.impl;

import com.poly.duanmau.dao.CategoryDAO;
import com.poly.duanmau.entities.Category;
import com.poly.duanmau.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
// CategoryDAOImpl kế thừa CategoryDAO
public class CategoryDAOImpl implements CategoryDAO{

    @Override
    public List<Category> searchByName(String name) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        try{
            String sql = "SELECT * FROM categories";
            ResultSet resultSet = XJdbc.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                
                Category category = new Category();
                category.setId(id);
                category.setName(name);
                
                categories.add(category);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return categories;
    }

    @Override
    public Category getById(Integer id) {
        return null;
    }

    @Override
    public Category create(Category entity) {
        return null;
    }

    @Override
    public void update(Category entity) {
        
    }

    @Override
    public void delete(Category entity) {
        
    }

}
