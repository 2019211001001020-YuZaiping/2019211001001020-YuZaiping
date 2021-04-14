package com.yuzaiping.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirect  -same server-  Relative URL
        //1.start without/
        //url
        //http://localhost:8081/2019211001001020_war_exploded/redirect
        //http://localhost:8081/2019211001001020_war_exploded/index.jsp
        //see the url-only last part of url changed (redirect -->index.jsp)
        //System.out.println("after redirect");
        //2.start with /
        //response.sendRedirect("/2019211001001020_war_exploded/index.jsp");//-???
        //redirect  -another server-Absolute URL
        response.sendRedirect("https://www.baidu.com/");
        //https://www.baidu.com/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
