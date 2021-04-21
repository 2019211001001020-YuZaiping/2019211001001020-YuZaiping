package com.yuzaiping.dao;

import com.yuzaiping.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
//have all jdbc methods u need -select -update -delete-insert
public interface IUserDao {
    public boolean saveUser(Connection con, User user) throws SQLException;
    public int deleteUser(Connection con, User user) throws SQLException;
    public int updateUser(Connection con, User user) throws SQLException;

    //select
    public User findById(Connection con, Integer id) throws SQLException;
    public User findByUsernamePassword(Connection con, String username,String password) throws SQLException;
    public List<User> findByUsername(Connection con, String username) throws SQLException;
    public List<User> findByPassword(Connection con, String password) throws SQLException;
    public List<User> findByEmail(Connection con,String email) throws SQLException;
    public List<User> findByGender(Connection con,String gender) throws SQLException;
    public List<User> findByBirthday(Connection con, Date birthday) throws SQLException;
    public List<User> findAllUser(Connection con) throws SQLException;


}
