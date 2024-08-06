<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.ProposalWithCarDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>My Proposals - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <style>
    </style>
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>

    <div class="container mt-4">
        <h2>My Proposals</h2>
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Car Brand & Model</th>
                    <th>Rental Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<ProposalWithCarDetails> proposals = (List<ProposalWithCarDetails>) request.getAttribute("proposals");
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    if (proposals != null) {
                        for (ProposalWithCarDetails proposal : proposals) {
                %>
                <tr>
                    <td><%= proposal.getCarBrand() %> <%= proposal.getCarModel() %></td>
                    <td><%= proposal.getRentalDate() != null ? proposal.getRentalDate().format(dateTimeFormatter) : "" %></td>
                    <td><%= proposal.getStatus() %></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <a href="userHome.jsp" class="btn btn-primary">Back to User Home</a>
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
