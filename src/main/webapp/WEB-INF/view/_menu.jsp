<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <div class="nav-wrapper container">
        <a class="brand-logo">Forum</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li>
                <a href='<c:url value="/" />'>Главная</a>
            </li>
            <li>
                <a href='<c:url value="/post/create" />'>Новая тема</a>
            </li>
            <li>
<%--                <a href='<c:url value="/logout" />'>Выйти</a>--%>
                <a href='#'>Выйти</a>
            </li>
        </ul>
    </div>
</nav>