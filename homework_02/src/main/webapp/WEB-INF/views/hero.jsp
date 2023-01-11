<%--
  Created by IntelliJ IDEA.
  User: griegoriens
  Date: 11.01.2023
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hero form</title>
</head>
<body>
<form method="POST" action="/add-hero">
    <label>
        Hero name
        <input name="heroName" type="text">
    </label>

    <label>
        Hero power
        <input name="heroPower" type="text">
    </label>

    <label>
        Hero day of birth
        <input name="dateOfBirth" type="text">
    </label>

    <label>
        Phone number
        <input name="phoneNumber" type="text">
    </label>
    <button type="submit">Send</button>
</form>

<p>Added hero is: </p>
<p>Name: ${heroName}</p>
<p>Power: ${heroPower}</p>
<p>Date: ${dateOfBirth}</p>
<p>Phone: ${phoneNumber}</p>

</body>
</html>
