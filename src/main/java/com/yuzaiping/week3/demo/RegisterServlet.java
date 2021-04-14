package com.yuzaiping.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;




//automatic -new --> servlet
public class RegisterServlet extends HttpServlet {
    Connection con=null; //class variable
    @Override
    public void init() throws ServletException{
        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        //String username="sa";
        //String password="123456789";
        //code like this is bad way --because change in not easy
        //for example change password of db = change in java code

        //get servlet config --> getInitParameters --no change
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request come here
        //get parameter from request.
        PrintWriter writer = response.getWriter();
        String sql="insert into usertable(username,password,email,gender,birthday)  values(?,?,?,?,?) ";
        String username =request.getParameter("username");//name of input type -<input type="text" name = "username"/><br/>
        String password =request.getParameter("password");
        String email =request.getParameter("email");
        String gender =request.getParameter("gender");
        String birthday =request.getParameter("birthday");
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.setString(4,gender);
            pstmt.setString(5,birthday);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String sql_1="select * from usertable";
        writer.print("<html>");
        writer.print("<table border='1'>");
        writer.print("<tr>");
        writer.print("<td>ID</td>");
        writer.print("<td>UserName</td>");
        writer.print("<td>Password</td>");
        writer.print("<td>Email</td>");
        writer.print("<td>gender</td>");
        writer.print("<td>BirthDay</td>");
        writer.print("</tr>");
        try {
            ResultSet rs=con.createStatement().executeQuery(sql_1);
            while(rs.next()){
                //get from rs - print - write into response
                writer.print("<tr>");
                writer.print("<td>"+rs.getString(1));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(2));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(3));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(4));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(5));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(6));
                writer.print("</td>");
                writer.print("</tr>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        writer.print("</table>");
        writer.print("</html>");
        response.sendRedirect("login.jsp");
        //print - write into response
    }
    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close(); //when tomcat stop
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}