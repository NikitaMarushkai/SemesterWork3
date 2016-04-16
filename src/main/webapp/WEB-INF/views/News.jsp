<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <meta name="author" content="Nikita">
    <link rel="stylesheet" href="../../resources/Styles/HockeyStyles.css">
    <title>Новости</title>
    <style>
        img {
            width: 70%;
            height: 500px;
            opacity: 1;
        }

        h1 {
            text-align: center;
            color: red;
        }

        p {
            text-align: right;
        }

        #add_news {
            width: 70%;
            text-align: center;
            background-color: cornflowerblue;
            margin-left: 20%;
            height: 60px;
            border-radius: 15px;
        }

        #add {
            font-size: 30px;
            font-weight: bold;
            font-style: italic;
        }

        a:hover {
            color: red;
        }
    </style>
</head>
<body id="main-body">
<sec:authorize access="hasRole('admin')">
    <div id="add_news">
        <a id="add" href="/static/addPost">Добавить новость</a>
    </div>
</sec:authorize>
<div id="menu" align="left">
    <ul id="m_list">
        <li class="list_element"><a href="/index" class="newslink">На главную</a></li>
        <li class="list_element"><a href="/teamList" class="newslink">Список команд</a></li>
        <li class="list_element"><a href="/timeTable" class="newslink">Расписание</a></li>
        <li class="list_element"><a href="/static/international" class="newslink">Международный хоккей</a></li>
    </ul>
</div>
<div id="content">
    <div class="news-block" style="text-align: center;">
        <c:forEach items="${news}" var="post">
            <div style=" border-bottom: 2px solid darkblue">
                <h1>${post.name}</h1>
                <img src="${post.image}">
                <h2>${post.content}</h2>
                <p><i>${post.creationDate}</i></p>
                <sec:authorize access="hasRole('admin')">
                    <a href="/admin/addPost/delete?name=${post.id}" name="delete">Удалить новость</a>
                </sec:authorize>
            </div>
        </c:forEach>
        <h1>${alert}</h1>
    </div>
</div>
</body>
</html>