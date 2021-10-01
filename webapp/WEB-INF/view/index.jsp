<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Java School</title>
  </head>
<body>
<c:url value="/home" var="home"/>
<c:url value="/users" var="user"/>

<button class="button" style="width: 75px; height: 50px"><a href="${home}">Домой</a></button>
<br/>
<br/>
<button class="button" style="width: 75px; height: 50px"><a href="${user}" class="button">Users</a></button>
</body>
</html>
