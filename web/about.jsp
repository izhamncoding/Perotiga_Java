<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>About Perotiga Rental System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <style>
        
    </style>
</head>
<body>
    <%@ include file="logged-in-navbar.jsp" %>

    <section class="page-section bg-primary text-white mb-0 py-4" id="location">
        <div class="container">
            <h2 class="page-section-heading text-center text-uppercase text-white">Our Location</h2>
            <div class="divider-custom divider-light">
                <div class="divider-custom-line"></div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <iframe
                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3984.6603711960317!2d101.4669195!3d3.063013!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31cc5361bb8204cf%3A0xbb4ec2c716dea019!2sPerodua%20klang%20branch%20(miela)!5e0!3m2!1sen!2smy!4v1622389876817!5m2!1sen!2smy"
                        width="100%" height="400" style="border: 2px solid #000000" allowfullscreen=""
                        loading="lazy">
                    </iframe>
                </div>
                <div class="col-lg-6">
                    <div class="p-4">
                        <h3 class="text-uppercase mb-4">Address</h3>
                        <p>No 37A 1st Floor, Jalan Tiara 2a/Ku1, Bandar Baru Klang, 41150 Klang, Selangor</p>
                        <p>Our office is located above Perodua Store in Bandar Baru Klang.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="page-section bg-light text-white mb-0 mt-2 py-4" id="about">
        <div class="container">
            <h2 class="page-section-heading text-center text-uppercase text-secondary">About</h2>
            <div class="divider-custom">
                <div class="divider-custom-line"></div>
            </div>
            <div class="row mb-5">
                <div class="col-lg-8 mx-auto text-center">
                    <p class="lead text-dark">Perotiga Rental System, where convenience meets reliability in the world of car
                        rentals. Our platform is designed to simplify the process of renting a car, offering a diverse
                        range of vehicles to suit every need. Whether you're planning a weekend getaway or a business
                        trip, our user-friendly interface and dedicated team ensure a seamless experience from start to
                        finish. Discover more about our commitment to quality service and customer satisfaction below.
                    </p>
                </div>
            </div>
        </div>

        <section class="page-section portfolio bg-primary" style="padding-top: 70px; padding-bottom: 70px;">
            <div class="container">
                <h2 class="page-section-heading text-center text-uppercase text-light mb-2">Services</h2>
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                </div>
                <div class="row">
                    <div class="col-lg-8 mx-auto text-center">
                        <p class="lead">We are focuses on giving our customer the best rental service website
                            possible mainly focusing on local car brands with a mixture of imported cars.
                        </p>
                    </div>
                </div>
            </div>
        </section>

        <div class="copyright mt-4 text-center text-dark">
            <div class="container"><small>Copyright &copy; Perotiga 2024</small></div>
        </div>

        <script src="js/bootstrap.bundle.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js"
            integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
            crossorigin="anonymous"></script>
    </section>
</body>

</html>
