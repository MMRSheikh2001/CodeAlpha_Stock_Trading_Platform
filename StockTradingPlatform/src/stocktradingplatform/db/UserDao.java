/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stocktradingplatform.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stocktradingplatform.models.User;

/**
 *
 * @author Administrator
 */
public class UserDao implements DaoService<User> {

    DataBase db = new DataBase();

    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
  private static final String CREATE_TABLE
            = "create table if not exists users ("
            + " id integer primary key autoincrement,"
            + " userName text not null unique,"
            + " password text not null,"
            + " cashBalance real not null default 0,"
            + " isAdmin integer not null default 0)";
  
    public void createTable() {
      
        try {
            ps = db.getCon().prepareStatement(CREATE_TABLE);
             ps.execute();
             ps.close();
             db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
    }

    @Override
    public void save(User e) {

           sql = "insert into users (userName, password, cashBalance, isAdmin) values (?, ?, ?, ?)";
           
        try {
            ps=db.getCon().prepareStatement(sql);
               ps.setString(1, e.getUserName());
            ps.setString(2, e.getPassword());
            ps.setDouble(3, e.getCashBalance() == null ? 0.0 : e.getCashBalance());
            ps.setInt(4, Boolean.TRUE.equals(e.getIsAdmin()) ? 1 : 0);
            ps.executeUpdate();
            
            ps.close();
            db.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public User findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(User e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
