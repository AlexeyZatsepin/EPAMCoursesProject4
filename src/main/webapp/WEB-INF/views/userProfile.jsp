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
        | Banking</title>
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
                    <c:forEach items="${user.getCards()}" var="card">
                        <p><c:out value="${card.getPayment()}"/></p>
                    </c:forEach>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quod dicta aliquid nemo repellendus distinctio minus dolor aperiam suscipit, ea enim accusantium, deleniti qui sequi sint nihil modi amet eligendi, quidem animi error labore voluptatibus sed. Qui magnam labore, iusto nostrum. Praesentium non, impedit accusantium consequatur officia architecto, mollitia placeat aperiam tenetur pariatur voluptatibus corrupti vitae deserunt! Nostrum non mollitia deserunt ipsam. Sunt quaerat natus cupiditate iure ipsa voluptatibus recusandae ratione vitae amet distinctio, voluptas, minus vero expedita ea fugit similique sit cumque ad id facere? Ab quas, odio neque quis ratione. Natus labore sit esse, porro placeat eum hic.
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
                    <c:forEach items="${user.getCards()}" var="card">
                        <p><c:out value="${card}"/></p>
                    </c:forEach>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quod dicta aliquid nemo repellendus distinctio minus dolor aperiam suscipit, ea enim accusantium, deleniti qui sequi sint nihil modi amet eligendi, quidem animi error labore voluptatibus sed. Qui magnam labore, iusto nostrum. Praesentium non, impedit accusantium consequatur officia architecto, mollitia placeat aperiam tenetur pariatur voluptatibus corrupti vitae deserunt! Nostrum non mollitia deserunt ipsam. Sunt quaerat natus cupiditate iure ipsa voluptatibus recusandae ratione vitae amet distinctio, voluptas, minus vero expedita ea fugit similique sit cumque ad id facere? Ab quas, odio neque quis ratione. Natus labore sit esse, porro placeat eum hic.
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
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quod dicta aliquid nemo repellendus distinctio minus dolor aperiam suscipit, ea enim accusantium, deleniti qui sequi sint nihil modi amet eligendi, quidem animi error labore voluptatibus sed. Qui magnam labore, iusto nostrum. Praesentium non, impedit accusantium consequatur officia architecto, mollitia placeat aperiam tenetur pariatur voluptatibus corrupti vitae deserunt! Nostrum non mollitia deserunt ipsam. Sunt quaerat natus cupiditate iure ipsa voluptatibus recusandae ratione vitae amet distinctio, voluptas, minus vero expedita ea fugit similique sit cumque ad id facere? Ab quas, odio neque quis ratione. Natus labore sit esse, porro placeat eum hic.
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quod dicta aliquid nemo repellendus distinctio minus dolor aperiam suscipit, ea enim accusantium, deleniti qui sequi sint nihil modi amet eligendi, quidem animi error labore voluptatibus sed. Qui magnam labore, iusto nostrum. Praesentium non, impedit accusantium consequatur officia architecto, mollitia placeat aperiam tenetur pariatur voluptatibus corrupti vitae deserunt! Nostrum non mollitia deserunt ipsam. Sunt quaerat natus cupiditate iure ipsa voluptatibus recusandae ratione vitae amet distinctio, voluptas, minus vero expedita ea fugit similique sit cumque ad id facere? Ab quas, odio neque quis ratione. Natus labore sit esse, porro placeat eum hic.
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quod dicta aliquid nemo repellendus distinctio minus dolor aperiam suscipit, ea enim accusantium, deleniti qui sequi sint nihil modi amet eligendi, quidem animi error labore voluptatibus sed. Qui magnam labore, iusto nostrum. Praesentium non, impedit accusantium consequatur officia architecto, mollitia placeat aperiam tenetur pariatur voluptatibus corrupti vitae deserunt! Nostrum non mollitia deserunt ipsam. Sunt quaerat natus cupiditate iure ipsa voluptatibus recusandae ratione vitae amet distinctio, voluptas, minus vero expedita ea fugit similique sit cumque ad id facere? Ab quas, odio neque quis ratione. Natus labore sit esse, porro placeat eum hic.
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quod dicta aliquid nemo repellendus distinctio minus dolor aperiam suscipit, ea enim accusantium, deleniti qui sequi sint nihil modi amet eligendi, quidem animi error labore voluptatibus sed. Qui magnam labore, iusto nostrum. Praesentium non, impedit accusantium consequatur officia architecto, mollitia placeat aperiam tenetur pariatur voluptatibus corrupti vitae deserunt! Nostrum non mollitia deserunt ipsam. Sunt quaerat natus cupiditate iure ipsa voluptatibus recusandae ratione vitae amet distinctio, voluptas, minus vero expedita ea fugit similique sit cumque ad id facere? Ab quas, odio neque quis ratione. Natus labore sit esse, porro placeat eum hic.
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
                    <c:out value="${user}"/>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, quod dicta aliquid nemo repellendus distinctio minus dolor aperiam suscipit, ea enim accusantium, deleniti qui sequi sint nihil modi amet eligendi, quidem animi error labore voluptatibus sed. Qui magnam labore, iusto nostrum. Praesentium non, impedit accusantium consequatur officia architecto, mollitia placeat aperiam tenetur pariatur voluptatibus corrupti vitae deserunt! Nostrum non mollitia deserunt ipsam. Sunt quaerat natus cupiditate iure ipsa voluptatibus recusandae ratione vitae amet distinctio, voluptas, minus vero expedita ea fugit similique sit cumque ad id facere? Ab quas, odio neque quis ratione. Natus labore sit esse, porro placeat eum hic.
                </p>
            </div> <!-- .cd-project-info -->
        </li>
    </ul> <!-- .cd-projects -->

    <button class="scroll cd-text-replace">Scroll</button>
</div> <!-- .cd-project-container -->

<nav class="cd-primary-nav" id="primary-nav">
    <ul>
        <li class="cd-label">Navigation</li>
        <li><a href="#0">Our services</a></li>
        <li><a href="#0">Our addresses</a></li>
        <li><a href="#0">Contact us</a></li>
    </ul>
</nav> <!-- .cd-primary-nav -->
<script src="../../js/jquery-2.1.1.js"></script>
<script src="../../js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>