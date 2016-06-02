<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текущая новость</title>
</head>
<body>
<div>
    <div>
        <h1>${post.name}</h1>
        <img src="${post.image}">
        <h2>${post.content}</h2>
        <p><i>${post.creationDate}</i></p>
        <div>
            <c:forEach items="${post.comments}" var="comment">
                <h5>${comment.user.username} прокомментировал(а)</h5>
                <p>${comment.text}</p>
                <p><i>${comment.creationDate}</i></p>
            </c:forEach>
            <sec:authorize access="isAuthenticated()">
                <form name="addCommentForm" action="/addComment">
                    <label>Введите текст комментария здесь
                        <input type="text" name="textComment">
                    </label>
                    <input type="hidden" name="postID" value="${post.id}">
                    <button onclick="addComment(${post.id}, this.form)" value="Добавить">Добавить</button>
                </form>
            </sec:authorize>
        </div>
    </div>
</div>
<script src="/resources/Scripts/NewsWork.js"></script>
</body>
</html>
