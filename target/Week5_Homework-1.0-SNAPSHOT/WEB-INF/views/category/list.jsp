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

<p><a href="${pageContext.request.contextPath}/category/form" >Add Category</a></p>
<p><a href="${pageContext.request.contextPath}/category/form" >Delete Category</a></p>
<p><a href="${pageContext.request.contextPath}/category/form" >Edit Category</a></p>

<ul>
    <c:forEach items="${category}" var="category">
        <li>${category.name} (${category.description}) <p><a href="${pageContext.request.contextPath}/category/form/${category.id}" >Delete Category</a></p>
            <p><a href="${pageContext.request.contextPath}/category/form/${category.id}" >Edit Category</a></p>
        </li>
    </c:forEach>
</ul>
</body>
</html>