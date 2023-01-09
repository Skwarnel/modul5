<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<p>W koszyku jest: ${totalQnt} sztuk </p>
<p>Wartość koszyka to: ${amountToPay} </p>

<p>W koszyku znajduje się:
    <c:forEach items="${cartItemList}" var="item">
    <c:out value="${item}" />
    </c:forEach>
</p>

<p>Chleb - id 1: ilość = ${id_1_qnt}</p>
<form action="addOne" method="get" name="1">
    <button type="submit" name="id" value="1">Dodaj 1</button>
</form>
<form action="removeOne" method="get" name="1">
    <button type="submit"name="id" value="1">Odejmij 1</button>
</form>
<p>Ser - id 2: ilość = ${id_2_qnt}</p>
<form action="addOne" method="get" name="2">
    <button type="submit"name="id" value="2">Dodaj 1</button>
</form>
<form action="removeOne" method="get" name="2">
    <button type="submit"name="id" value="2">Odejmij 1</button>
</form>
<p>Mleko - id 3: ilość = ${id_3_qnt}</p>
<form action="addOne" method="get" name="3">
    <button type="submit"name="id" value="3">Dodaj 1</button>
</form>
<form action="removeOne" method="get" name="3">
    <button type="submit"name="id" value="3">Odejmij 1</button>
</form>
</body>
</html>
