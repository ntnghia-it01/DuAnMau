/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau;

import com.poly.duanmau.dao.UserDAO;
import com.poly.duanmau.dao.impl.UserDAOImpl;
import com.poly.duanmau.ui.MainFrame;

/**
 *
 * @author macbookprom1
 */
public class Main {
    public static void main(String[] args){
//      Trong hệ thống chỉ có 1 tài khoản với vai trò là admin?

//      Ktra xem trong hệ thống có tồn tại tài khoản với vai trò là admin không?
//      Nếu không tồn tại => Thêm tài khoản admin

        UserDAO userDAO = new UserDAOImpl();
        if(!userDAO.checkAdminExist()){
            userDAO.createAdmin();
        }
        
       
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        
//      Start JFrameLoading 
    }
}
