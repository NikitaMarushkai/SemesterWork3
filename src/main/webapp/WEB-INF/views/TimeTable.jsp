<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <meta name="author" content="Nikita">
    <title>Расписание игр</title>
    <style>
        h1 {
            font-style: italic;
            font-size: 80px;
            color: white;
        }

        body {
            background: url("../../resources/images/hoc.jpg") no-repeat;
            background-size: 100%;
        }

        a {
            font-size: 80px;
            color: white;
        }

        g {
            margin: 0;
            padding: 0;
            outline: none;

        }

        caption {
            font-size: 80px;
            color: white;
            font-style: italic;
            font-weight: bold;
        }

        td {
            font-size: 40px;
            color: darkblue;
            font-weight: bold;
            border: 1px solid darkblue;
        }

        table {
            background: azure;

        }
    </style>
</head>
<body>
<sec:authorize access="isAnonymous()">
    <h1>Вам нужно <a href="/login.jsp">войти</a>, чтобы видеть расписание</h1>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div>
        <div id="1" align="left" style="top:1em; width:49%; height:50px; float:left">
            <table>
                <caption>Игры запада</caption>
                <c:forEach items="${east}" var="contest">
                    <tr>
                        <td>${contest.team1}</td>
                        <td>${contest.team2}</td>
                        <td>${contest.contest}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div align="right" id="2" style="top:1em; width:49%; height:50px; float:right">
            <table>
                <caption>Игры востока</caption>
                <c:forEach items="${west}" var="contest">
                    <tr>
                        <td>${contest.team1}</td>
                        <td>${contest.team2}</td>
                        <td>${contest.contest}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</sec:authorize>
</body>
</html>
