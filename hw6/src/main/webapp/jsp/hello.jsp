<%--
  Created by IntelliJ IDEA.
  User: Liia
  Date: 27.09.2016
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:choose>
    <c:when test="${isLogged == true}">
        <h2><c:out value="${message}"/></h2>
    </c:when>
    <c:otherwise>
        Error
    </c:otherwise>
</c:choose>

</body>
</html>
