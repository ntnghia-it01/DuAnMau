/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.duanmau.dao;

import com.poly.duanmau.entities.Category;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
// CategoryDAO sẽ kế thừa CrudDAO
// CategoryDAO sẽ có tất cả các func ở CrudDAO
// Sẽ bổ sung thêm các func xử lý riêng cho Category Entity 
public interface CategoryDAO extends CrudDAO<Category, Integer>{
    List<Category> searchByName(String name);
}


// CrudDAO.getAll() => Entity????

// CategoryDAO.getAll() => List<Category>