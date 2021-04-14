package com.yuzaiping.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//tell tomcat this class is a listener class -how ?
@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //like a main() method for this web app
        //called when tomcat start
        //use this method to create jdbc connection when tomcat start
        ServletContext context=sce.getServletContext();
        String driver=sce.getServletContext().getInitParameter("driver");
        String url=sce.getServletContext().getInitParameter("url");
        String username=sce.getServletContext().getInitParameter("username");
        String password=sce.getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("i am in contextInitialized()-->"+con);//when?
            //System.out.println("init()-->"+con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
            //set connection as a context attribute -- for all jsp and servlet
            context.setAttribute("con",con);//name = value
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("i am in contextInitialized");//when ?
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //end print of web app
        //this method called when tomcat stop
        System.out.println("i am in contextDestroyed");//when this line print
        //remove connection from context
        sce.getServletContext().removeAttribute("con");//name
    }
}
