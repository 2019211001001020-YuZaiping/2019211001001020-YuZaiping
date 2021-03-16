package com.yuzaiping.week2.demo;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//now its just a java class
//extend HttpServlet
public class HelloWordServlet  extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
       //when client request method is GET -here-inside doGet()
       //we want to send Hello to client
       //we need to write hello in response
        //get writer-java.io
       PrintWriter write= response.getWriter();
       write.println("Hello Client !!!");//that all
        //next we need to tell about this serlet to tomcat-how?-web.xml
    }
    public void  doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
