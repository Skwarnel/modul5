<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 04.12.2022
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            color: ${color};
            background-color: ${backgroundColor};
        }
    </style>
</head>
<body>

<h1>Witaj w widoku</h1>
<h2>
    It is: <c:out value="${actualTimeString}"/>
</h2>

</body>
</html>
