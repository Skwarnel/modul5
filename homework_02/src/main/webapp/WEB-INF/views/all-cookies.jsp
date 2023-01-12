<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 12.01.2023
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookies show</title>
</head>
<body>
<table>
    <tr>
        <th>Cookie name</th>
        <th>Cookie value</th>
    </tr>
    <tr>
        <td>
            <c:out value="${item1.name}"/>
        </td>
        <td>
            <c:out value="${item1.value}"/>
        </td>
    </tr>
    <tr>
        <td>
            <c:out value="${item2.name}"/>
        </td>
        <td>
            <c:out value="${item2.value}"/>
        </td>
    </tr>
    <tr>
        <td>
            <c:out value="${item3.name}"/>
        </td>
        <td>
            <c:out value="${item3.value}"/>
        </td>
    </tr>
</table>
</body>
</html>
