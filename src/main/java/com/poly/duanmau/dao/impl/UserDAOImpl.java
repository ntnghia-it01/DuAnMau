/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.dao.impl;

import com.poly.duanmau.dao.UserDAO;
import com.poly.duanmau.entities.User;
import com.poly.duanmau.utils.XJdbc;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author macbookprom1
 */
public class UserDAOImpl implements UserDAO{
    
//    private JFrame frame;
//    
//    public UserDAOImpl(JFrame frame){
//        this.frame = frame;
//    }

    @Override
    public User login(String username, String password) {
//        String sql = "SELECT * FROM users WHERE username=? AND password=? AND enable=1";

//      username, password, enable

//      tất cả hệ password đều phải mã hoá lại 
        try{
            String sql = "SELECT * FROM users WHERE username=?";
            ResultSet resultSet = XJdbc.executeQuery(sql);
            User user = null;
            while(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
//                .....
//                Gán giá trị trong bảng select được vào user
            }
            if(user == null){
//                Tên tài khoản hoặc mật khẩu không đúng?
            }else if(!password.equals(user.getPassword())){
//                Tên tài khoản hoặc mật khẩu không đúng?
            }else if(!user.isEnable()){
//                Tài khoản đã bị khoá 
            }else{
//                Đăng nhập thành công
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean checkAdminExist() {
//        Nếu có tồn tại tài khoản với role là admin => true
//        Ngược lại => false
        try{
            String sql = "SELECT * FROM users WHERE manager=1";
            ResultSet resultSet = XJdbc.executeQuery(sql);
            return resultSet.next();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public void createAdmin() {
//        Insert tài khoản có vai trò là admin 

        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEnable(true);
        user.setFullName("Nguyen Van Admin");
        user.setPhoto("");
        user.setManager(true);
        
        this.create(user);
    }

    @Override
    public List<User> getAll() {
        try{
            String sql = "SELECT * FROM users WHERE manager != 1";
            ResultSet resultSet = XJdbc.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public User getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User create(User entity) {
        try{
    //      Trước khi tạo tài khoản
    //      Kiểm tra username có tồn tại không? => Nếu có thông báo lỗi
    //      Kiểm tra email có tồn tại không? => Nếu có thông báo lỗi

            String checkUsername = "SELECT * FROM users WHERE username=?";
            ResultSet resultSetUsername = XJdbc.executeQuery(checkUsername, entity.getUsername());
            if(resultSetUsername.next()){
    //            Username trùng;
                return null;
            }

            String checkEmail = "SELECT * FROM users WHERE email=?";
            ResultSet resultSetEmail = XJdbc.executeQuery(checkEmail, entity.getEmail());
            if(resultSetEmail.next()){
    //            Email trùng;
                return null;
            }

            String sql = "INSERT INTO user(username, password) VALUES(?,?)";

            String password = generateRandomString(10);
            int excute = XJdbc.executeUpdate(sql, entity.getUsername(), password);
            
            //      Send Email
            
        }catch(Exception e){
            
        }
        
        return null;
    }
    
    private static final String ALLOWED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARS.length());
            sb.append(ALLOWED_CHARS.charAt(randomIndex));
        }
        return sb.toString();
    }

    @Override
    public void update(User entity) {
//        Cập nhật thông tin của nhân viên
//      Không được cập nhật: username, password, manager 

        try{
            String checkEmail = "SELECT * FROM users WHERE email=? AND id!=?";
            ResultSet resultSetEmail = XJdbc.executeQuery(checkEmail, entity.getEmail(), entity.getId());
            if(resultSetEmail.next()){
    //            Email trùng;
                return;
            }
            
            
        }catch(Exception e){
            
        }
    }

    @Override
    public void delete(User entity) {
//      Có thể xoá tài khoản nhưng với điều kiện tài khoản chưa phát sinh đơn hàng
//      Nếu đã có đơn hàng thì chuyển trạng thái => khoá tài khoản

//      Làm sao để biết user có đơn hàng?

        try{
            String checkBill = "SELECT * FROM bills WHERE user_id=?";
            ResultSet resultSetBill = XJdbc.executeQuery(checkBill, entity.getId());
            if(resultSetBill.next()){
//                "UPDATE users SET enable=false WHERE id=?"
            }else{
//                "DELETE FROM users WHERE id=?"
            }
        }catch(Exception e){
            
        }
    }
    
}
