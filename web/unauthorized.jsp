<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unauthorized Access - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <style>
        .error-container {
            width: 100%;
            max-width: 400px;
            margin: auto;
            text-align: center;
            padding: 20px;
            margin-top: 50px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        h1 {
            font-size: 24px;
            color: #dc3545;
        }
        p {
            font-size: 18px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <%@ include file="index-navbar.jsp" %>

    <div class="error-container">
        <h1>Unauthorized Access</h1>
        <p>You do not have permission to access this page.</p>
        <a href="index.jsp" class="btn btn-primary mt-3">Go to Home</a>
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
