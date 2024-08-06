<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Car - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <style>
        
    </style>
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>

    <div class="container mt-4">
        <h2>Book Car</h2>
        <div class="card mb-4">
            <div class="card-body">
                <h5 class="card-title">Car Details</h5>
                <p class="card-text">Brand: ${car.brand}</p>
                <p class="card-text">Model: ${car.model}</p>
                <p class="card-text">Transmission: ${car.transmission}</p>
                <p class="card-text">Fuel Type: ${car.fuelType}</p>
                <p class="card-text">Price per Day: ${car.pricePerDay}</p>
            </div>
        </div>
        
        <div class="card mb-4">
            <div class="card-body">
                <!-- User Information (read-only) -->
                <h5 class="card-title">User Information</h5>
                <p class="card-text">Name: ${user.name}</p>
                <p class="card-text">Email: ${user.email}</p>
                <p class="card-text">Address: ${user.address}</p>
            </div>
        </div>
        
        <!-- Booking Form -->
        <div class="card">
            <div class="card-body">
                <form action="bookCar" method="POST" id="bookCarForm">
                    <input type="hidden" name="carId" value="${car.id}">
                    
                    <!-- Start Date -->
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" class="form-control" id="startDate" name="startDate" required>
                    </div>
                    
                    <!-- End Date -->
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" class="form-control" id="endDate" name="endDate" required>
                    </div>
                    
                    <!-- Total Cost Calculation -->
                    <div class="form-group">
                        <label for="totalCost">Total Cost (RM):</label>
                        <input type="text" class="form-control" id="totalCost" name="totalCost" readonly>
                    </div>
                    
                    <!-- Calculate Button -->
                    <button type="button" class="btn btn-primary" onclick="calculateTotal()">Calculate Total</button>
                    
                    <!-- Submit Button -->
                    <button type="submit" class="btn btn-success">Book Car</button>
                </form>
                    <p class="card-text"><strong>Please pay face-to-face at our office<strong></p>

                <!-- Back Button -->
                <a href="carListUser" class="btn btn-secondary mt-2">Back to Car List</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
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
        function calculateTotal() {
            var startDate = new Date(document.getElementById("startDate").value);
            var endDate = new Date(document.getElementById("endDate").value);
            var pricePerDay = ${car.pricePerDay};
            
            // Calculate the number of days
            var timeDiff = Math.abs(endDate.getTime() - startDate.getTime());
            var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
            
            // Calculate total cost
            var totalCost = diffDays * pricePerDay;
            
            // Display total cost in the input field
            document.getElementById("totalCost").value = totalCost.toFixed(2);
        }
    </script>
</body>
</html>
