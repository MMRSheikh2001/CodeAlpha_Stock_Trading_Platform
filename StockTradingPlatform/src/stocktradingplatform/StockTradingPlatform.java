/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stocktradingplatform;

import stocktradingplatform.db.DataBase;
import stocktradingplatform.db.StockDao;
import stocktradingplatform.db.UserDao;
import stocktradingplatform.models.User;

/**
 *
 * @author Administrator
 */
public class StockTradingPlatform {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        UserDao userDao = new UserDao();

//        User user = new User();
//        user.setUserName("admin");
//        user.setPassword("1234");
//
//        user.setIsAdmin(true);
//
//        userDao.createTable();
//        userDao.save(user);
//        StockDao stockDao = new StockDao();
//        stockDao.createTable();
//
//        System.out.println("Total stocks : " + stockDao.countStocks());

        User admin = userDao.findByUserName("admin");

        System.out.println("Name : " + admin.getUserName() + " Balance : " + admin.getCashBalance()
                + "\n password : " + admin.getPassword());

    }

}
