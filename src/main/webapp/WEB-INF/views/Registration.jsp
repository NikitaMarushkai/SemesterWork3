<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <meta name="author" content="Nikita">
    <link rel="stylesheet" href="../../resources/Styles/RegLoginStyles.css">
    <title>Зарегистрироваться</title>
</head>
<body>
<div id="login_form">
    <div id="login_inner">
        <p>${exception}</p>
        <form name="login" action="/register" method="post">
            <input class="field" type="text" required placeholder="Имя" name="name"><br>
            <input class="field" type="text" required placeholder="Фамилия" name="surname"><br>
            <input class="field" type="text" placeholder="Отчество" name="patronymic"><br>
            <input class="field" type="text" required placeholder="Логин" name="login"><br>
            <input class="field" type="email" required placeholder="E-mail" name="email"><br>
            <input class="field" type="password" required placeholder="Пароль" name="password"><br>
            <input class="field" type="password" required placeholder="Повторите пароль" name="password-check"><br>
            <textarea name="comment" class="field" id="personal">Информация о себе</textarea><br>
            <textarea readonly class="field" id="agreement">Ваша личная информация будет передана туда куда я хочу и я не несу за это никаких
            последствий, да и вообще, регистрируясь на этом сайте - вы продаете себя в рабство хоккейным клубам.
            Надеюсь что вы согласны...</textarea><br>
            <label id="remember"><input type="checkbox" name="agree" required>Я прочитал и согласен с данным соглашением</label><br>
            <input class="field" id="btn" type="submit" name="submit" value="Зарегистрироваться">
        </form>
    </div>
</div>
</body>
</html>