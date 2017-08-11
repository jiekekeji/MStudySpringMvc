<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 17/8/8
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>ModelAndView:${requestScope.userid },userid=${requestScope.user.userid},username=${requestScope.user.userName}</p>

<p>TestMap:${requestScope.token },userid=${requestScope.user1.userid},username=${requestScope.user1.userName}</p>

<p>
    SessionAttributes:userid=${sessionScope.userid },token=${sessionScope.token },user=${sessionScope.user1 },user1=${sessionScope.user1 }</p>

</body>
</html>
