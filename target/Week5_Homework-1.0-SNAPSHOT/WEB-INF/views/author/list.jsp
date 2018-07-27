<%--
  Created by IntelliJ IDEA.
  User: milena
  Date: 24.07.18
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p><a href="${pageContext.request.contextPath}/author/form" >Add author</a></p>
<ul>
    <c:forEach items="${author}" var="author">
        <li>${author.firstName} ${author.lastName} <p><a href="${pageContext.request.contextPath}/author/form/${author.id}" >Delete author</a></p>
            <p><a href="${pageContext.request.contextPath}/author/form/${author.id}" >Edit author</a></p>
        </li>
    </c:forEach>
</ul>
</body>
</html>