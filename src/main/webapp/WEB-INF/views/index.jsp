<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <meta name="author" content="Nikita">
    <link rel="stylesheet" type="text/css" href="../../resources/Styles/HockeyStyles.css">
    <title>HockeyBox</title>
</head>
<body id="main-body">
<div class="content">
    <div align="right" class="login">
        <sec:authorize access="isAnonymous()">
            <a href="<c:url value="/login.jsp"/>">
                <spring:message code="label.login"/>
            </a>
            <a href="<c:url value="/static/reg"/>">
                <spring:message code="label.registration"/>
            </a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <h3>Здравствуйте, <a href="<c:url value="/profile/show"/>">${username}</a></h3>
            <a href="<c:url value="/logout"/>"><spring:message code="label.logout"/></a>
        </sec:authorize>
    </div>
    <h1>
        HOCKEY-BOX. All about hockey.
    </h1>
    <br>
    <table>
        <tr>
            <td class="head"><a href="<c:url value="/teamList"/>" class="hlink">
                <spring:message code="label.teamlist"/></a></td>
            <td class="head"><a href="<c:url value="/timeTable"/>" class="hlink">
                <spring:message code="label.timetable"/></a></td>
            <td class="head"><a href="<c:url value="/showNews"/>" class="hlink">
                <spring:message code="label.news"/></a></td>
            <td class="head"><a href="<c:url value="/static/international"/>" class="hlink">
                <spring:message code="label.international"/></a></td>
            <sec:authorize access="hasRole('admin')">
                <td class="head"><a href="<c:url value="/adminConsole"/>" class="hlink">
                    <spring:message code="label.admin"/></a></td>
            </sec:authorize>
        </tr>
    </table>
    <table cellspacing="4" cellpadding="2" id="standings">
        <caption id="standings_head">Турнирная таблица КХЛ</caption>
        <tr>
            <th class="table_head">Клуб</th>
            <th class="table_head" title="Игры">И</th>
            <th class="table_head" title="Выигрыши">В</th>
            <th class="table_head" title="Выигрыши в овертайме">ВО</th>
            <th class="table_head" title="Выигрыши по булитам">ВБ</th>
            <th class="table_head" title="Проигрыши по булитам">ПБ</th>
            <th class="table_head" title="Проигрыши в овертайме">ПО</th>
            <th class="table_head" title="Проигрыши">П</th>
            <th class="table_head" title="Шайб заброшено">Ш</th>
            <th class="table_head" title="Очки">О</th>
        </tr>
        <tr>
            <td class="side" colspan="10">Запад</td>
        </tr>
        <c:forEach items="${west}" var="west">
        <tr>
            <td class="table_content">${west.team}</td>
            <td class="table_content">${west.games}</td>
            <td class="table_content">${west.wins}</td>
            <td class="table_content">${west.overTimeWins}</td>
            <td class="table_content">${west.bullitWins}</td>
            <td class="table_content">${west.bullitFaults}</td>
            <td class="table_content">${west.overTimeFaults}</td>
            <td class="table_content">${west.faults}</td>
            <td class="table_content">${west.goals}</td>
            <td class="table_content">${west.score}</td>
        </tr>
        </c:forEach>
        <tr>
            <td class="side" colspan="10">Восток</td>
        </tr>
        <c:forEach items="${east}" var="east">
        <tr>
            <td class="table_content">${east.team}</td>
            <td class="table_content">${east.games}</td>
            <td class="table_content">${east.wins}</td>
            <td class="table_content">${east.overTimeWins}</td>
            <td class="table_content">${east.bullitWins}</td>
            <td class="table_content">${east.bullitFaults}</td>
            <td class="table_content">${east.overTimeFaults}</td>
            <td class="table_content">${east.faults}</td>
            <td class="table_content">${east.goals}</td>
            <td class="table_content">${east.score}</td>
        </tr>
        </c:forEach>
</div>
</body>
</html>
