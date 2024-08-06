<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Car</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <style>
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>
    <div class="container form-container">
        <h2 class="text-center">Add New Car</h2>
        <form action="addCar" method="post">
            <div class="form-group">
                <label for="brand">Brand:</label>
                <input type="text" class="form-control" id="brand" name="brand" required>
            </div>
            
            <div class="form-group">
                <label for="model">Model:</label>
                <input type="text" class="form-control" id="model" name="model" required>
            </div>
            
            <div class="form-group">
                <label for="carAge">Car Age:</label>
                <input type="number" class="form-control" id="carAge" name="carAge" required>
            </div>
            
            <div class="form-group">
                <label for="availability">Availability (1 for available, 0 for not available):</label>
                <input type="number" class="form-control" id="availability" name="availability" required>
            </div>
            
            <div class="form-group">
                <label for="pricePerDay">Price per Day:</label>
                <input type="number" class="form-control" id="pricePerDay" name="pricePerDay" step="0.01" required>
            </div>
            
            <div class="form-group">
                <label for="transmission">Transmission:</label>
                <input type="text" class="form-control" id="transmission" name="transmission" required>
            </div>
            
            <div class="form-group">
                <label for="fuelType">Fuel Type:</label>
                <input type="text" class="form-control" id="fuelType" name="fuelType" required>
            </div>
            
            <button type="submit" class="btn btn-primary btn-block">Add Car</button>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js" integrity="sha384-pzjw8f+ua7Kw1TIqPsQFBzUq8ll1P6zI5XYuqsbSfFWpi1MquVdAyjUar5+76PVCp+" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgT5zVIY5YFNnVE8QkP3/5hs91P5YdyyxD4zV7V0zAB46T+EOuE" crossorigin="anonymous"></script>
</body>
</html>
