package com.yuzaiping.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get parameter -<input type="txt" size=30/> and
        //get parameter -<select name="search">
        //check is txt null
        String txt=request.getParameter("txt");
        String search=request.getParameter("search");
        System.out.println(search);
        System.out.println(txt);

        if (txt == ""){
            response.sendRedirect("index.jsp");
        }else{

            if (search.equals("baidu")){
                //redirect to baidu
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
                System.out.println("i am in baidu");
            }else if (search.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            }else if(search.equals("google")){
                response.sendRedirect("https://www.google.com/search?q="+txt);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
