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
public class Category {
    private int id;
    private String name;
}