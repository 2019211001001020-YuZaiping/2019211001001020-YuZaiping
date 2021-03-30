package com.yuzaiping.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
//use @webservlet -no web.xml code
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams={
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;databaseName=userdb"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="123456789"),

        },loadOnStartup=1

)//end of webervlet

public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;//class variable
    @Override

    public void init() throws ServletException {
        //only  one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;databaseName=userdb";
        //String username="sa";
        //String password="123456789";
        //code like this is bad way --because change in not easy
        //for example change password of db-change in java code
        //get servlet config-->gerInitParameters  --no change

        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");// <param-name>driver</param-name>
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
           con= DriverManager.getConnection(url,username,password);
            System.out.println("init()--> "+con);//ok(use config-in web.xml)--ok -use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doGet()");//ok
        //we need to use con within doget
        String sql="select * from usertable";
        try {
            ResultSet rs =con.createStatement().executeQuery(sql);
            while(rs.next()){
                //get from rs-print-write into response
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //connection within do get--many times -bad way
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();//when tomcat stop
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
