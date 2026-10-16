/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stocktradingplatform.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
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
    
  final  String databaseSetup="create table if not exists users"+
          " id integer primary key autoincrement,"+
          " userName text not null unique , "+
          " password text not null ,"+
          " cashBalance "

    @Override
    public User save(User e) {

        sql="insert into users ()";


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
    public User update(User e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
