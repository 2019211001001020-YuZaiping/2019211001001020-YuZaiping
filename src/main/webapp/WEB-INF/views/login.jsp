<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/6 0006
  Time: 下午 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<h1 style="color: black;font-family: 'Arial Black';font-size: 40px">Login</h1>
<%
    if(request.getAttribute("message")!=null){
        //error
        out.println(request.getAttribute("message"));
    }
%>
<%
    //read cookies
    Cookie [] allCookies=request.getCookies();//give all cookies
    String username="",password="",rememberMeValue="";
    for(Cookie c:allCookies) {
        //get one by one
        if (c.getName().equals("cUsername")) {
            //get value of this cookies
            username = c.getValue();
        }
        if (c.getName().equals("cPassword")) {
            //get value of this cookies
            password = c.getValue();
        }
        if (c.getName().equals("cRememberMe")) {
            //get value of this cookies
            rememberMeValue = c.getValue();
        }
    }
%>
<form method="post" action="${pageContext.request.contextPath}/login"> <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    UserName: <input type="text" name="username" value="<%=username%>" style="width: 200px;height: 25px;margin-top: 2px"><br/>
    PassWord: <input type="password" name="password" value="<%=password%>" style="width: 200px;height: 25px;margin-top: 5px"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeValue.equals("1") ?"checked":""%> />RememberMe<br/>
    &nbsp;<input type="submit" value="submit" style="background-color:gray;color: black;width: 75px;height: 25px;text-align: center;font-size: 15px"/>
</form>

<%@include file="footer.jsp"%>