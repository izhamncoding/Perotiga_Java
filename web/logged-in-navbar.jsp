<style>
    .navbar {
        box-shadow: 1px 1px 5px -1px #000;
    }

    .navbar-nav .nav-link {
        color: #2E8B57;
    }

    .navbar-nav .nav-link:hover {
        color: #ffffff !important;
        background-color: transparent !important;
        outline: 2px solid #ffffff;
    }
</style>

<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
        type="text/css" />

<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Perotiga Rental System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${sessionScope.userRole == 1}">
                            <a class="nav-link" href="userHome.jsp">Home</a>
                        </c:when>
                        <c:when test="${sessionScope.userRole == 2 || sessionScope.userRole == 3}">
                            <a class="nav-link" href="adminHome.jsp">Home</a>
                        </c:when>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${sessionScope.userRole == 1}">
                            <a class="nav-link" href="carListUser">Car</a>
                        </c:when>
                        <c:when test="${sessionScope.userRole == 2 || sessionScope.userRole == 3}">
                            <a class="nav-link" href="carListAdmin">Car</a>
                        </c:when>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${sessionScope.userRole == 1}">
                            <a class="nav-link" href="proposalListUser">My Proposals</a>
                        </c:when>
                        <c:when test="${sessionScope.userRole == 2 || sessionScope.userRole == 3}">
                            <a class="nav-link" href="proposalListAdmin">Proposal Admin</a>
                        </c:when>
                    </c:choose>
                </li>
                <c:if test="${sessionScope.userRole == 2 || sessionScope.userRole == 3}">
                    <li class="nav-item">
                        <a class="nav-link" href="userList">User List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="addCar.jsp">Add Car</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">About</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
