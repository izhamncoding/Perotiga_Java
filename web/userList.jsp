<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>
    <div class="container mt-4">
        <h2>User List</h2>
        <c:if test="${param.success == 'true'}">
            <div class="alert alert-success" role="alert">
                User deleted successfully.
            </div>
        </c:if>
        <c:if test="${param.error == 'true'}">
            <div class="alert alert-danger" role="alert">
                Failed to delete user: ${errorMessage}
            </div>
        </c:if>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Username</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                    <c:if test="${sessionScope.userRole == 3}">
                        <th>Actions</th>
                    </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${user.username}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.address}</td>
                        <td>${user.phoneNum}</td>
                        <c:if test="${sessionScope.userRole == 3}">
                            <td>
                                <a href="editUser?id=${user.id}" class="btn btn-primary btn-sm">Edit</a>
                                <a href="javascript:void(0);" onclick="confirmDelete(${user.id})" class="btn btn-danger btn-sm">Delete</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
            integrity="sha384-..."
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-..."
            crossorigin="anonymous"></script>
            
    <script>
    function confirmDelete(userId) {
        if (confirm("Are you sure you want to delete this user?")) {
            window.location.href = "deleteUser?id=" + userId;
        }
    }
    </script>
</body>
</html>
