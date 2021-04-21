package com.yuzaiping.controller;

import com.yuzaiping.dao.UserDao;
import com.yuzaiping.model.User;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //write code
        //ToDo 1:forward to WEB-INF/views/updateUser.jsp
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
        //ToDo 2:create one jsp page -update User
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code to update user info-can update password ,email,gender,birthday
        //TODO 1: get all (6) request parameter
        Connection con = null;
        String id =request.getParameter("id");
        String username =request.getParameter("username");//name of input type -<input type="text" name = "username"/><br/>
        String password =request.getParameter("password");
        String email =request.getParameter("mail");
        String gender =request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        //TODO 2: create an project of User Model
        User u=new User();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            dateTime = simpleDateFormat.parse(birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO 3: set all 6 request parameter values into User model - setXXX()
        java.sql.Date sqlDate = new java.sql.Date(dateTime.getTime());
        u.setId(Integer.parseInt(id));
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        u.setGender(gender);
        u.setBirthday(sqlDate);
        //TODO 4: create an object of UserDao
        UserDao userdao = new UserDao();
        //TODO 5: call updateUser() in UserDao
        con = (Connection) getServletContext().getAttribute("con");
        try {
            int i = userdao.updateUser(con,u);
            System.out.println(""+i);
            HttpSession session= request.getSession();
            session.setMaxInactiveInterval(60*60);
            session.setAttribute("user",u);
            if(i==1){
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //TODO 6: forward to WEB-INF/views/userInfo.jsp
    }
}