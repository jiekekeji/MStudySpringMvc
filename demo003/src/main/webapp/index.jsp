<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<a href="/demo003/sayhello?userid=123465">@RequestParam1</a>
<a href="/demo003/register?gender=man">@RequestParam2</a>

<a href="/demo003/login">@RequestHeader</a>

<a href="/demo003/info">@CookieValue</a>

<form action="/demo003/update" method="post">
    <input name="userid" type="text" placeholder="userid">
    <input name="age" type="text" placeholder="age">
    <%--user里有个address,address里有city,需要这么写--%>
    <input name="address.city" type="text" placeholder="city">
    <input name="address.road" type="text" placeholder="road">
    <input type="submit" value="提交">
</form>

<a href="/demo003/add">Servlet API</a>
</body>
</html>
