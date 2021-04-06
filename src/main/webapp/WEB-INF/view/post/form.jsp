<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:if test="${post.id == 0}">Новая тема</c:if>
            <c:if test="${post.id != 0}">Редактирование темы</c:if>
        </h5>
    </div>
    <div class="col s8 offset-s2">
        <div class="card horizontal">
            <div class="card-stacked row">
                <form class="col" action="<c:url value='/post/save'/>" method="post">
                    <div class="card-content">
                        <input hidden name="id" value="${post.id}">
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="name" type="text" name="name" class="validate" required value="${post.name}">
                                <label class="active" for="name">Заголовок</label>
                            </div>
                            <div class="input-field col s12">
                                <input id="text" type="text" name="desc" class="validate" required value="${post.desc}">
                                <label class="active" for="text">Описание</label>
                            </div>
                        </div>
                    </div>
                    <div class="card-action center-align">
                        <button type="submit" class="waves-effect waves-light btn">
                            сохранить
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