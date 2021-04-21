<%@ page import="com.yuzaiping.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/14 0014
  Time: 上午 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user=(User) request.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Birthday:</td><td><%=user.getBirthday()%></td><br></tr>
</table>
<%@include file="footer.jsp"%>


