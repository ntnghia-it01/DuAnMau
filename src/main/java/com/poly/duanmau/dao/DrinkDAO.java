/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.dao;

import com.poly.duanmau.entities.Drink;
import java.util.List;

/**
 *
 * @author macbookprom1
 */
public interface DrinkDAO extends CrudDAO<Drink, Integer>{
//  Lấy danh sách thức uống theo id danh mục 
    List<Drink> getDrinksByCategoryId(int id);
}
