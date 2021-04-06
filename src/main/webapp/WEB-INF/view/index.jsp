<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <title>Forum</title>
</head>
<body>
<c:import url="_menu.jsp"/>
<div class="container row">
    <div class="row valign-wrapper">
        <h5 class="col s12 center-align">Темы</h5>
    </div>
    <div class="card">
        <div class="card-content">
            <table class="highlight">
                <thead>
                <tr>
                    <th>Заголовок</th>
                    <th>Автор</th>
                    <th class="center-align">Дата</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>
                            <a href='<c:url value="/post/view?id=${post.id}"/>'>${post.name}</a>
                        </td>
                        <td>
                            ${post.user.username}
                        </td>
                        <td class="center-align">
                            <fmt:formatDate type="time" value="${post.created.time}" pattern="dd.MM.yyyy"/>
                        </td>
                        <td class="right-align">
                            <c:if test="${post.user.id == userId}">
                                <a href='<c:url value="/post/update?id=${post.id}"/>'>
                                    <i class="material-icons">edit</i>
                                </a>
                                <a href='<c:url value="/post/delete?id=${post.id}"/>'>
                                    <i class="material-icons">delete</i>
                                </a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>