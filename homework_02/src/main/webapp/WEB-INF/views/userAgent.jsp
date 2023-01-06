<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 06.01.2023
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>I'm the best</title>
</head>
<body>
    <p>Here is what works.</p>
    <p><c:out value="${userAgent}" default="guest"/></p>
    <p><c:out value="${value}" default="guest"/></p>
</body>
</html>
