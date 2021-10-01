<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<p>User id: <c:out value="${user.id}"/> </p>
<p>User login: <c:out value="${user.login}"/> </p>
<p>User email: <c:out value="${user.email}"/> </p>
</body>
</html>
