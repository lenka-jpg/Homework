<%--
  Created by IntelliJ IDEA.
  User: milena
  Date: 26.07.18
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="draft">
    <form:input path="title" placeholder="title"/>
    <form:input path="content" placeholder="content"/>
    <input type="submit">
</form:form>
</body>
</html>
