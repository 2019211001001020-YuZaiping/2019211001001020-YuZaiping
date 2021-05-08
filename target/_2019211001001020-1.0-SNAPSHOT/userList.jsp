<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/13 0013
  Time: 下午 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>ID</td> <td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
        //get rs from request attribute
        ResultSet rs = (ResultSet) request.getAttribute("rsname");//name of attribute
        if(rs==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else {
        while (rs.next()) {
            //get from rs - print - write into response
            out.print("<tr>");
            out.print("<td>" + rs.getString("id"));
            out.print("</td>");
            out.print("<td>" + rs.getString("username"));
            out.print("</td>");
            out.print("<td>" + rs.getString("password"));
            out.print("</td>");
            out.print("<td>" + rs.getString("email"));
            out.print("</td>");
            out.print("<td>" + rs.getString("sex"));
            out.print("</td>");
            out.print("<td>" + rs.getString("birthday"));
            out.print("</td>");
            out.print("</tr>");
        }
    }
    %>
</table>
<%@include file="footer.jsp"%>