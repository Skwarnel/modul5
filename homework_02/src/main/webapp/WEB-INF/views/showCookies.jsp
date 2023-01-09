<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 09.01.2023
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookies</title>
</head>
<body>
    <h2>
        My Cookies are:
    </h2>

    <p>
        <c:forEach items="${cookies}" var="item">
            <p>
                <c:out value="${item.name}"/>
            </p>

            <p>
                <c:out value="${item.value}"/>
                <div>
                    =========================
                </div>
            </p>
        </c:forEach>
    </p>
</body>
</html>