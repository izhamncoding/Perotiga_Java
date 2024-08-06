<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Proposal - Admin Panel - Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <style>
    </style>
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>
    <div class="container mt-4">
        <h2>Edit Proposal Details</h2>
        <div class="row">
            <div class="col-md-6">
                <div class="card mb-3">
                    <div class="card-header">
                        Proposal Details
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <tr>
                                <th>Proposal ID</th>
                                <td>${proposal.id}</td>
                            </tr>
                            <tr>
                                <th>User Name</th>
                                <td>${proposal.user.name}</td>
                            </tr>
                            <tr>
                                <th>User Email</th>
                                <td>${proposal.user.email}</td>
                            </tr>
                            <tr>
                                <th>Rental Date</th>
                                <td>${proposal.rentalDate}</td>
                            </tr>
                            <tr>
                                <th>Status</th>
                                <td>
                                    <c:choose>
                                        <c:when test="${proposal.status eq 'Pending'}">
                                            <span class="badge badge-warning">Pending</span>
                                        </c:when>
                                        <c:when test="${proposal.status eq 'Approved'}">
                                            <span class="badge badge-success">Approved</span>
                                        </c:when>
                                        <c:when test="${proposal.status eq 'Rejected'}">
                                            <span class="badge badge-danger">Rejected</span>
                                        </c:when>
                                    </c:choose>
                                </td>
                            </tr>
                            <tr>
                                <th>Created At</th>
                                <td>${proposal.createdAt}</td>
                            </tr>
                            <tr>
                                <th>Updated At</th>
                                <td>${proposal.updatedAt}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        Car Details
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <tr>
                                <th>Car Brand</th>
                                <td>${proposal.car.brand}</td>
                            </tr>
                            <tr>
                                <th>Car Model</th>
                                <td>${proposal.car.model}</td>
                            </tr>
                            <tr>
                                <th>Price Per Day</th>
                                <td>${proposal.car.pricePerDay}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="mt-4">
            <form action="editProposalAdmin" method="post" class="mt-3">
                <button type="submit" name="action" value="approve" class="btn btn-success">Approve</button>
                <button type="submit" name="action" value="reject" class="btn btn-danger">Reject</button>
                <input type="hidden" name="proposalId" value="${proposal.id}">
                <a href="proposalListAdmin" class="btn btn-secondary">Back to Proposal List</a>
            </form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
            integrity="sha384-..."
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+pbuKbTvHdLYQEGZBf8..."></script>
</body>
</html>
