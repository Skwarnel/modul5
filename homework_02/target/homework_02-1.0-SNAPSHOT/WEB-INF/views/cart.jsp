<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 09.01.2023
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>I am real genius</title>
</head>
<body>
    <form action="/addToCart" method="GET">
        <labe><input type="number" name="id"></labe>
        <labe><input type="number" name="quantity"></labe>
        <button type="submit">Wyślij</button>
    </form>

    <p>W koszyku jest: ${cartSize} pozycji</p>
    <p>W koszyku jest: ${totalQnt} sztuk  </p>
    <p>Wartość koszyka to: ${amountToPay} </p>
</body>
</html>
