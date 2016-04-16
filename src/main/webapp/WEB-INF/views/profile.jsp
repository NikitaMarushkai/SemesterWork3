<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <meta name="author" content="Nikita">
    <link rel="stylesheet" href="../../resources/Styles/ProfileStyles.css">
    <title>Профиль</title>
</head>
<body>
<div class="content">
    <table cellspacing="1">
        <h1>Это ваш профиль,${userName}</h1>
        <tr>
            <td>Имя</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td>${surname}</td>
        </tr>
        <tr>
            <td>Отчество</td>
            <td>${patronymic}</td>
        </tr>
        <tr>
            <td>Логин</td>
            <td>${login}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${email}</td>
        </tr>
        <tr>
            <td>Информация о себе</td>
            <td>${comment}</td>
        </tr>
        <tr>
            <td colspan="2">Новый пароль</td>
        </tr>
        <form:form action="/profile/changePassword">
            <tr>
                <td colspan="2"><input name="oldPassword" type="password" placeholder="Ваш старый пароль"/></td>
            </tr>
            <tr>
                <td colspan="2"><input name="newPassword" type="password" placeholder="Ваш новый пароль"/></td>
            </tr>
            <tr>
                <td colspan="2"><input name="newPasswordCheck" type="password" placeholder="Ещё раз"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Применить"></td>
            </tr>
        </form:form>
        <tr>
            <td style="color: #ff35dd">${passwordChangeException}</td>
        </tr>
    </table>
</div>
</body>
</html>