/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.duanmau.services;

import com.poly.duanmau.dao.BillDAO;
import com.poly.duanmau.dao.BillDetailDAO;
import com.poly.duanmau.dao.CardDAO;
import com.poly.duanmau.dao.DrinkDAO;
import com.poly.duanmau.dao.UserDAO;
import com.poly.duanmau.dao.impl.BillDAOImpl;
import com.poly.duanmau.dao.impl.BillDetailDAOImpl;
import com.poly.duanmau.dao.impl.CardDAOImpl;
import com.poly.duanmau.dao.impl.DrinkDAOImpl;
import com.poly.duanmau.dao.impl.UserDAOImpl;
import com.poly.duanmau.entities.Bill;
import com.poly.duanmau.entities.Card;
import com.poly.duanmau.entities.Drink;
import com.poly.duanmau.entities.User;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author macbookprom1
 */
// Trang thái đơn hàng
// 1: Chờ thanh toán
// 2: Đã thanh toán
// 3: Đã hoàn thành
// 4: Huỷ đơn

// Trạng thái card 
// 1: Trống
// 2: Bận
// 3: Thất lạc

// Đối tượng dùng để xử lý nghiệp vụ bán hàng
// Các chức năng sẽ xây dựng:
// - Khởi tạo 1 đơn hàng gắn với 1 card được chọn và trang thái đơn là 1
// - Thêm sản phẩm
// - Cập nhật số lượng sản phẩm
// - Xoá sản phẩm
// - Xác nhận thanh toán
// - Hoàn thành đơn hàng
// - Huỷ đơn
public class POSServices {
    private CardDAO cardDAO = new CardDAOImpl();
    private BillDAO billDAO = new BillDAOImpl();
    private BillDetailDAO billDetailDAO = new BillDetailDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private DrinkDAO dinkDAO = new DrinkDAOImpl();
    private JFrame frame;
    
    public POSServices(JFrame frame){
        this.frame = frame;
    }
    
    private User checkUser(int userId){
       User user = this.userDAO.getById(userId);
       if(user == null){
//           User không tồn tại => Logout
            return null;
       }
       if(!user.isEnable()){
//           Tài khoản đã bị khoá => Logout
           return null;
       }
       
       return user;
    }
    
    public void createBill(int cardId, int userId){
       User user = this.checkUser(userId);
       if(user == null) return;
        
//     Đổi trạng thái của card từ trống sang bận
//     Chỗ này các em sẽ thực hiện đổi luôn theo card id hay cần kiểm tra lại?
       Card card = this.cardDAO.getById(cardId);
       if(card == null){
//         Thẻ không tồn tại
           return;
       }
       if(card.getStatus() != 1){
//         Thẻ không có sẵn
            return;
       }
       
//     biến card có giá trị từ db 
       card.setStatus(2);
       this.cardDAO.update(card); // Đổi trạng thái card ở DB
//     Tạo đơn hàng
        Bill bill = new Bill();
        bill.setCard(card);
        bill.setUser(user);
        bill.setCheckIn(new Date());
        bill.setCheckOut(new Date());
        bill.setStatus(1);
        this.billDAO.create(bill);
    }
    
    public void addDrink(int userId, int billId, int drinkId){
       User user = this.checkUser(userId);
       if(user == null) return;
//      Đơn hàng đang tương tác có thuộc của user hiện tại không?
       Bill bill = this.billDAO.getById(billId);
       if(bill == null){
//           Thông báo lỗi
            return;
       }
       if(bill.getUser().getId() != userId){
//          Đơn hàng không thuộc sở hữu của user
           return;
       }
        
//      Trạng thái đơn hàng có phải là chờ thanh toán không?
       if(bill.getStatus() != 1){
//         Đơn hàng không được sửa
           return;
       }
//      Kiểm tra sản phẩm còn hàng hay không?
        Drink drink = this.dinkDAO.getById(billId);
        if(!drink.isAvailable()){
//          Sản phẩm hết hàng
            return;
        }
       
       
//      Sản phẩm muốn thêm có tồn tại trong đơn hàng hiện tại hay không?
//      - Nếu không tồn tại thì tạo 1 billDetail với số lượng là 1
//      - Nếu đã tồn tại thì lấy số lượng hiện tại + 1
    }
}
