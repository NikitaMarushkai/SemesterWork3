<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <meta name="author" content="Nikita">
    <link rel="stylesheet" href="../../resources/Styles/HockeyStyles.css">
    <title>Список команд</title>
</head>
<body id="teamlist_body">
<div id="content">
    <div id="team-block">
        <c:forEach items="${teams}" var="team">
            <div id="team_item">
                <h2 class="inner">${team.name}</h2>
                <img class="inner image" src="${team.image}">
                <p class="inner" style="font-size: 30px">${team.descr}</p>
                <a style="font-size: 15px" href="${team.siteLink}">Официальный сайт</a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
