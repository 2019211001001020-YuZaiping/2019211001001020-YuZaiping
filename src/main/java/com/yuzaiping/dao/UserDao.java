package com.yuzaiping.dao;

import com.yuzaiping.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert ..into usertable ---write code yourself
        String sql="insert into usertable(id,username,password,email,gender,birthday)  values(?,?,?,?,?,?) ";
        PreparedStatement st=con.prepareStatement(sql);
        st = con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.setString(2, user.getUsername());
        st.setString(3,user.getPassword());
        st.setString(4,user.getEmail());
        st.setString(5,user.getGender());
        st.setDate(6, (java.sql.Date) user.getBirthday());
        st.executeUpdate();
        if (st.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete ......where id=?
        String sql="delete from  usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.executeQuery();
        if (st.executeUpdate() > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update ....where id=?
        String sql="update usertable set username=?,password=?,email=?,gender=?,birthday=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setDate(5, (java.sql.Date) user.getBirthday());
        st.setInt(6,user.getId());
        st.executeQuery();
        if (st.executeUpdate() > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select ---where id=? ---write jdbc code yourself
        String sql="Select * from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs= st.executeQuery();
        User user=null;
        if(rs.next()){
            //get from rs and set into user model
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //use for login
        //select ---where username=? and password=?--- i will show you now
        String sql="Select * from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);

        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs= st.executeQuery();
        User user=null;
        if(rs.next()){
            //get from rs and set into user model
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //select ---where username=? --write jdbc code yourself
        List<User> userList = new ArrayList<User>();
        String sql = "select * from usertable where username=?";
        try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select ---where password=? --write jdbc code yourself
        List<User> userList = new ArrayList<User>();
        String sql = "select * from usertable where password=?";
        try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //select ---where email=? --write jdbc code yourself
        List<User> userList = new ArrayList<User>();
        String sql = "select * from usertable where email=?";
        try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //select ---where sex=? --write jdbc code yourself
        List<User> userList = new ArrayList<User>();
        String sql = "select * from usertable where gender=?";
        try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,gender);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public List<User> findByBirthday(Connection con, Date birthday) throws SQLException {
        //select ---where birthday=? --write jdbc code yourself
        List<User> userList = new ArrayList<User>();
        String sql = "select * from usertable where birthday=?";
        try {
            PreparedStatement st=con.prepareStatement(sql);
            st.setDate(1, (java.sql.Date) birthday);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //select ---where usertable=? --write jdbc code yourself
        List<User> userList = new ArrayList<User>();
        String sql = "select * from usertable";
        try {
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getDate("birthday"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userList;
    }
}