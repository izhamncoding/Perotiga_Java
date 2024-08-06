<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Car Details - Admin Panel - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>
    <div class="container mt-4">
        <h2>Edit Car Details - Admin Panel</h2>
        
        <% if (session.getAttribute("editError") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= session.getAttribute("editError") %>
            </div>
        <% } %>
        
        <form action="editCar" method="POST">
            <div class="form-group">
                <label for="brand">Brand:</label>
                <input type="text" class="form-control" id="brand" name="brand" value="${car.brand}" required>
            </div>
            <div class="form-group">
                <label for="model">Model:</label>
                <input type="text" class="form-control" id="model" name="model" value="${car.model}" required>
            </div>
            <div class="form-group">
                <label for="carAge">Car Age:</label>
                <input type="number" class="form-control" id="carAge" name="carAge" value="${car.carAge}" required>
            </div>
            <div class="form-group">
                <label for="availability">Availability:</label>
                <select class="form-control" id="availability" name="availability" required>
                    <option value="1" ${car.availability == 1 ? 'selected' : ''}>Available</option>
                    <option value="0" ${car.availability == 0 ? 'selected' : ''}>Not Available</option>
                </select>
            </div>
            <div class="form-group">
                <label for="pricePerDay">Price Per Day:</label>
                <input type="text" class="form-control" id="pricePerDay" name="pricePerDay" value="${car.pricePerDay}" required>
            </div>
            <div class="form-group">
                <label for="transmission">Transmission:</label>
                <input type="text" class="form-control" id="transmission" name="transmission" value="${car.transmission}" required>
            </div>
            <div class="form-group">
                <label for="fuelType">Fuel Type:</label>
                <input type="text" class="form-control" id="fuelType" name="fuelType" value="${car.fuelType}" required>
            </div>
            <input type="hidden" name="id" value="${car.id}">
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="carListAdmin" class="btn btn-secondary">Cancel</a>
        </form>
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
