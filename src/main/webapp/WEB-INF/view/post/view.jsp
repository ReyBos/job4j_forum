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
<c:import url="../_menu.jsp"/>
<div class="container row">
    <div class="row valign-wrapper">
        <h5 class="col s12 center-align">
            ${post.name}
        </h5>
    </div>
    <div class="col s10 offset-s1">
        <div class="card horizontal">
            <div class="card-stacked row" style="margin-bottom: 0;">
                <div class="card-content" style="padding-bottom: 10px; padding-top: 10px">
                    <div class="row" style="margin-bottom: 0;">
                        <p class="input-field col s12" style="margin-bottom: 8px">
                            <strong>${post.user.username}</strong>, <fmt:formatDate type="time" value="${post.created.time}" pattern="dd.MM.yyyy HH:mm:ss"/>
                        </p>
                        <p class="input-field col s12">
                            ${post.desc}
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:forEach items="${post.comments}" var="comment">
        <div class="col s10 offset-s1">
            <div class="card horizontal">
                <div class="card-stacked row" style="margin-bottom: 0;">
                    <div class="card-content" style="padding-bottom: 10px; padding-top: 10px">
                        <div class="row" style="margin-bottom: 0;">
                            <p class="input-field col s12" style="margin-bottom: 8px">
                                <strong>${comment.user.username}</strong>, <fmt:formatDate type="time" value="${comment.created.time}" pattern="dd.MM.yyyy HH:mm:ss"/>
                            </p>
                            <p class="input-field col s12">
                                    ${comment.desc}
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

    <div class="col s6 offset-s3" style="margin-top: 25px;">
        <div class="card horizontal">
            <div class="card-stacked row">
                <form class="col" action="<c:url value='/comment/save'/>" method="post">
                    <div class="card-content" style="padding: 8px 16px">
                        <input hidden name="post.id" value="${post.id}">
                        <div class="row" style="margin-bottom: 0">
                            <div class="input-field col s12">
                                <input id="name" type="text" name="desc" class="validate" required>
                                <label class="active" for="name">Новое сообщение</label>
                            </div>
                        </div>
                    </div>
                    <div class="card-action center-align" style="padding: 8px">
                        <button type="submit" class="waves-effect waves-light btn">
                            отправить
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>