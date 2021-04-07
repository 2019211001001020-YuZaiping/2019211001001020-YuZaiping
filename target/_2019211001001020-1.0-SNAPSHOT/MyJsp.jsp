<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/15 0015
  Time: 下午 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<a href="http://www.ecjtu.jx.cn/">go to ecjtu</a><!--method is GET-->
<form method="post"><!--what is method when we use form?--><!-- its GET,why? default is,form data is added in the URL,U can see  -->
    <!--better to use POST in form,add in not added in the URL-->
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    <input type="submit" value="Send data to server"/>
</form>

<%@include file="footer.jsp"%>