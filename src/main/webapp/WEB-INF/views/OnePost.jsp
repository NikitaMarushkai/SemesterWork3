<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текущая новость</title>
    <link rel="stylesheet" href="../../resources/Styles/HockeyStyles.css">
</head>
<body id="main-news-body">
<div>
    <a href="/">На главную</a>
</div>
<div id="post">
    <div align="center" id="post-self">
        <h1>${post.name}</h1>
        <img src="${post.image}">
        <h2>${post.content}</h2>
        <p><i>${post.creationDate}</i></p>
        <div align="left" id="post-comment">
            <c:forEach items="${comments}" var="comment">
                <div id="comment">
                    <h5>${comment.user.username} прокомментировал(а)</h5>
                    <p id="text">${comment.text}</p>
                    <p align="right"><i>${comment.creationDate}</i></p>
                    <sec:authorize access="hasRole('admin')">
                        <a href="/admin/deleteComment?id=${comment.commentId}">Удалить комментарий</a>
                    </sec:authorize>
                </div>
            </c:forEach>
            <sec:authorize access="isAuthenticated()">
                <form method="post" name="addCommentForm" action="/addComment">
                    <label>Введите текст комментария здесь
                        <textarea id="text_area" cols="60" rows="15" wrap="hard" name="text"></textarea>
                    </label>
                    <input type="hidden" name="postID" value="${post.id}">
                    <input type="submit" value="Добавить!">
                </form>
            </sec:authorize>
        </div>
    </div>
</div>
<%--<script src="/resources/Scripts/NewsWork.js"></script>--%>
</body>
</html>
