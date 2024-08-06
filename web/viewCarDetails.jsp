<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Car Details - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>

    <div class="container mt-4">
        <h2>Car Details</h2>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${car.brand} ${car.model}</h5>
                <p class="card-text">Car Age: ${car.carAge} years</p>
                <p class="card-text">Transmission: ${car.transmission}</p>
                <p class="card-text">Fuel Type: ${car.fuelType}</p>
                <p class="card-text">Price per Day: ${car.pricePerDay}</p>
                <c:choose>
                    <c:when test="${userRole == 1}">
                        <a href="carListUser" class="btn btn-primary">Back to Car List</a>
                    </c:when>
                    <c:otherwise>
                        <a href="carListAdmin" class="btn btn-primary">Back to Car List</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
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
</body>
</html>
