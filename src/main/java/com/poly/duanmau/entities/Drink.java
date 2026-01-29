/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author macbookprom1
 */

@AllArgsConstructor // Hàm xây dựng đầy đủ tham số 
@NoArgsConstructor // Hàm xây dựng không tham số
@Data // Tạo getter/setter
public class Drink {
    private int id;
    private String name;
    private int unitPrice;
    private int discount;
    private String image;
    private boolean available;
//  Thể hiện mối quan hệ n - 1
//  Từ thức uống đến danh mục
    private Category category;
}
