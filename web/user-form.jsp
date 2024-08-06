<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <form action="user?action=update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="${user.username}" required>
        <br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required>
        <br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${user.address}" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="${user.password}" required>
        <br>
        <label for="userRole">User Role:</label>
        <input type="text" id="userRole" name="userRole" value="${user.userRole}" required>
        <br>
        <label for="phoneNum">Phone Number:</label>
        <input type="text" id="phoneNum" name="phoneNum" value="${user.phoneNum}" required>
        <br>
        <label for="icNum">IC Number:</label>
        <input type="text" id="icNum" name="icNum" value="${user.icNum}" required>
        <br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
