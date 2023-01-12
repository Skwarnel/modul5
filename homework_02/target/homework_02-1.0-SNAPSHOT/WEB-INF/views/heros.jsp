<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 12.01.2023
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Hero name</th>
        <th>Hero age</th>
    </tr>
    <c:forEach items="${herosMap}" var="entrySet">
        <td>
            <c:out value="${entrySet.key}"/>
        </td>
        <td>
            <c:out value="${entrySet.value}"/>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
