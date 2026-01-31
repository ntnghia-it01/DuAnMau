/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.entities;

import java.util.Date;
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
public class Bill {
    private int id;
    private User user;
    private Card card;
    private Date checkIn;
    private Date checkOut;
    private int status;
}


// String => Chờ thanh toán
// int => 
// 1: Chờ thanh toán
// 2: Đã thanh toán
// 3: Đã hoàn thành
// 4: Huỷ đơn
// 1 -> 3 false || 1 -> 2 true
// statusUpdate > status && statusUpdate == status + 1

// status.equals("Chờ thanh toán")

// tinyint < smallint < int 