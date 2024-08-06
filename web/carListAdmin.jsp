<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car List - Admin Panel - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>
    <div class="container mt-4">
        <h2>Car List - Admin Panel</h2>

        <c:choose>
            <c:when test="${empty cars}">
                <div class="alert alert-warning" role="alert">
                    No cars found or error retrieving cars.
                </div>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <c:forEach var="car" items="${cars}" varStatus="loop">
                        <div class="col-md-4 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${car.brand} ${car.model}</h5>
                                    <p class="card-text">Age: ${car.carAge}</p>
                                    <p class="card-text">Availability: ${car.availability == 1 ? 'Available' : 'Not Available'}</p>
                                    <a href="editCar?id=${car.id}" class="btn btn-primary btn-sm">Edit</a>
                                    <form action="deleteCar" method="get" style="display: inline;">
                                        <input type="hidden" name="id" value="${car.id}">
                                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                    </form>
                                    <a href="viewCarDetails?id=${car.id}" class="btn btn-info btn-sm">View Details</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
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
