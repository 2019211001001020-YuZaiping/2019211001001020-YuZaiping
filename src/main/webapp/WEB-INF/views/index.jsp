<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>


<h1 style="font-family: 'Arial Black';font-size: 30px"><%= "Welcome to my homepage"%>
</h1>
<form method="get" target="_blank" action="search">
    <!-- <url-pattern>/search</url-pattern> -->
    <input type="text" name="txt" size=30/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>
<br/>
<br/>

<a href="hello-servlet">Hello Servlet</a><br/>
<a href="http://localhost:8080/2019211001001020_war_exploded/hello">Student Info Servlet-week2</a><br/>
<a href="http://localhost:8080/2019211001001020_war_exploded/life">Life Cycle Servlet-week3</a><br/>
<a href="http://localhost:8080/2019211001001020_war_exploded/register.jsp">Register-getParameter-week3</a><br/>
<a href="http://localhost:8080/2019211001001020_war_exploded/config">Config parameter-week4</a><br/>
<a href="http://localhost:8080/2019211001001020_war_exploded/register.jsp">Register JDBC-week4</a><br/>
<a href="http://localhost:8080/2019211001001020_war_exploded/index.jsp">include-week5</a><br/>
<a href="http://localhost:8080/2019211001001020_war_exploded/login.jsp">login-week5</a><br/>
</body>
</html>
<%@include file="footer.jsp"%>