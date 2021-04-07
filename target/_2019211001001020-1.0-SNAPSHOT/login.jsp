<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/6 0006
  Time: 下午 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<h1 style="color: black;font-family: 'Arial Black';font-size: 40px">Login</h1>
<form method="post" action="${pageContext.request.contextPath}/login">
    <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    UserName: <input type="text" name="username"  style="width: 200px;height: 20px;margin-top: 2px"><br/>
    PassWord: <input type="password" name="password"  style="width: 200px;height: 20px;margin-top: 4px"><br/>
    &nbsp;<input type="submit" value="Login" style="background-color:gray;color: black;width: 70px;height: 20px;text-align: center;font-size: 15px"/>
</form>


