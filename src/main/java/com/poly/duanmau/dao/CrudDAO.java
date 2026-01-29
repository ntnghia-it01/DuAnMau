/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.duanmau.dao;

import java.util.List;

/**
 *
 * @author macbookprom1
 */
// Tất cả phương thức và biến đều là public 
// Tất cả biến đều là hằng số (final) và là biến tĩnh (static)
// Generics Interface có quy định 2 dữ liệu động là
// - Kiểu Entity
// - Kiểu ID
// Cấu trúc chung cho tất cả các entity sẽ xử lý 
public interface CrudDAO<Entity, ID> {
//  Danh sách entity 
    List<Entity> getAll();
//  Lấy thông tin entity bằng ID 
    Entity getById(ID id);
//  Thêm entity
    Entity create(Entity entity);
//  Sửa entity
    void update(Entity entity);
//  Xoá entity
    void delete(Entity entity);
}

