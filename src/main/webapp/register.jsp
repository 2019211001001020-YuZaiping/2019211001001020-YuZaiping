<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/24 0024
  Time: 上午 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1 style="color: gray">This is my register JSP page!</h1>

<form method="post" action="register"><!--within doPost()in servlet-->
    username<input type="text" name="username"/><br/>
    password<input type="password"name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender"value="Female">Female<br/>
    <!--if name is same it make array-->
    Date of Birth:<input type="text name" name="birthday"><br/>
    <input type="submit" value="Register"/>

</form>
<%@include file="footer.jsp"%>
