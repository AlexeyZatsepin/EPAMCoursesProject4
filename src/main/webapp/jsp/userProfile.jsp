<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700|Merriweather:400italic,400' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="../../css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="../../css/style.css"> <!-- Resource style -->
    <script src="../../js/modernizr.js"></script> <!-- Modernizr -->

    <title>
        <c:out value="${user.getFirstName()}"/>
        <c:out value="${user.getSecondName()}"/>
        | Banking
    </title>
</head>
<body>
<a class="cd-nav-trigger cd-text-replace" href="#primary-nav">Menu<span aria-hidden="true" class="cd-icon"></span></a>

<div class="cd-projects-container">
    <ul class="cd-projects-previews">
        <li>
            <a href="#0">
                <div class="cd-project-title">
                    <h2>My payments</h2>
                    <p>Show list of my payments</p>
                </div>
            </a>
        </li>

        <li>
            <a href="#0">
                <div class="cd-project-title">
                    <h2>Credit cards</h2>
                    <p>Manage your cards here</p>
                </div>
            </a>
        </li>

        <li>
            <a href="#0">
                <div class="cd-project-title">
                    <h2>Create bill</h2>
                    <p>Select recipient and amount</p>
                </div>
            </a>
        </li>

        <li>
            <a href="#0">
                <div class="cd-project-title">
                    <h2>Edit Profile</h2>
                    <p>Edit your account, manage data</p>
                </div>
            </a>
        </li>
    </ul> <!-- .cd-projects-previews -->

    <ul class="cd-projects">
        <li>
            <div class="preview-image">
                <div class="cd-project-title">
                    <h2>My payments</h2>
                    <p>Show list of my payments</p>
                </div>
            </div>

            <div class="cd-project-info">
                <p>
                    <%@ include file="fragments/paymentsView.jsp" %>
                </p>
            </div> <!-- .cd-project-info -->
        </li>

        <li>
            <div class="preview-image">
                <div class="cd-project-title">
                    <h2>Credit cards</h2>
                    <p>Manage your cards here</p>
                </div>
            </div>

            <div class="cd-project-info">
                <p>
                    <%@ include file="fragments/cardList.jsp" %>
                </p>
            </div> <!-- .cd-project-info -->
        </li>

        <li>
            <div class="preview-image">
                <div class="cd-project-title">
                    <h2>Create bill</h2>
                    <p>Select recipient and amount</p>
                </div>
            </div>

            <div class="cd-project-info">
                <p>
                    <%@ include file="fragments/createBill.jsp" %>
                </p>
            </div> <!-- .cd-project-info -->
        </li>

        <li>
            <div class="preview-image">
                <div class="cd-project-title">
                    <h2>Edit Profile</h2>
                    <p>Edit your account, manage data</p>
                </div>
            </div>

            <div class="cd-project-info">
                <p>
                    <%@ include file="fragments/editProfile.jsp" %>
                </p>
            </div> <!-- .cd-project-info -->
        </li>
    </ul> <!-- .cd-projects -->

    <button class="scroll cd-text-replace">Scroll</button>
</div> <!-- .cd-project-container -->

<nav class="cd-primary-nav" id="primary-nav">
    <ul>
        <li class="cd-label">Navigation</li>
        <li><a href="/Controller?command=GET_SERVICES">Our services</a></li>
        <li><a href="/Controller?command=GET_ADRESSES">Our addresses</a></li>
        <li><a href="/Controller?command=SEND_MAIL">Contact us</a></li>
        <li><a href="/Controller?command=LOG_OUT">Exit</a></li>
    </ul>
</nav> <!-- .cd-primary-nav -->
<script src="../../js/jquery-2.1.1.js"></script>
<script src="../../js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>