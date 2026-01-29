/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.duanmau.dao;

import com.poly.duanmau.entities.User;

/**
 *
 * @author macbookprom1
 */
public interface UserDAO extends CrudDAO<User, Integer>{
    User login(String username, String password);
    boolean checkAdminExist();
    void createAdmin();
}
