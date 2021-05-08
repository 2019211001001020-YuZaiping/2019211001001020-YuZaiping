package com.yuzaiping.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//2 way of mapping filter to servlet
//way 1 -use web.xml
//way 2-use webFilter
@WebFilter(filterName = "HelloFilter",
          urlPatterns = {"/hello"})
//test 1 :url /hello-filter is only for one Servlet -HelloServlet
//test 2:url /*-this filter is for all servlet
//test 3:3 url -this filter for there 3 url only
public class HelloFilter implements Filter {  //remember
    public void init(FilterConfig config) throws ServletException {
    System.out.println("i am HelloFilter -->init()");//when called? --start tomcat
    }

    public void destroy() {
        System.out.println("i am HelloFilter -->destroy()");//when called? --stop tomcat
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request come here - before go to servlet -doGet() or doPost()
        System.out.println("i am HelloFilter -->doFilter()- before servlet -(request come here)");//when called?
        chain.doFilter(request, response);//call next filter - if no next filter - if no next filter - then go to servlet
        //response after servlet come back here
        System.out.println("i am HelloFilter -->doFilter()- after servlet -(response come here)");//when called?
    }
}
