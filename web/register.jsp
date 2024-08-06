<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <style>
        .form-signin {
            width: 100%;
            max-width: 600px;
            padding: 15px;
            margin: auto;
        }
        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            margin-bottom: 10px;
        }
        .form-signin input[type="submit"] {
            font-size: 16px;
            font-weight: bold;
            padding: 10px;
        }
    </style>
</head>
<body class="text-center">
    <%@ include file="index-navbar.jsp" %>

    <form class="form-signin mt-4" action="register" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Register</h1>
        <label for="username" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        <label for="name" class="sr-only">Name</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Name" required>
        <label for="email" class="sr-only">Email address</label>
        <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required>
        <label for="address" class="sr-only">Address</label>
        <input type="text" id="address" name="address" class="form-control" placeholder="Address" required>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <label for="phone_num" class="sr-only">Phone Number</label>
        <input type="text" id="phone_num" name="phone_num" class="form-control" placeholder="Phone Number" required>
        <label for="ic_num" class="sr-only">IC Number</label>
        <input type="text" id="ic_num" name="ic_num" class="form-control" placeholder="IC Number" required>
        <button class="btn btn-lg btn-success btn-block" type="submit">Register</button>
    </form>

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
