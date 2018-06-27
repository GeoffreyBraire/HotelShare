<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">

        <title>Spring Boot Example</title>
        <!-- <th:block th:include="fragments/headerinc :: head"></th:block> -->
    </head>
    <body>
        <div class="container">
            <div th:fragment="header">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#" th:href="@{/}">Home</a>
                            <ul class="nav navbar-nav">
                                <li><a href="#" th:href="">Persons</a></li>
                                <li><a href="#" th:href="">Create Person</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
   <!-- <div class="container"> -->
           <!--  <th:block th:include="fragments/header :: header"></th:block> -->
        </div>
    </body>
</html>