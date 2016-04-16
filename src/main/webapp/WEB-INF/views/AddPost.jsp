<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <meta name="author" content="Nikita">
    <link rel="stylesheet" href="../../resources/Styles/HockeyStyles.css">
    <title>Создать новость</title>
    <style>
        body {
            background: url('../../resources/images/main_background.jpg') no-repeat center;
            background-size: cover;
        }

        #form {
            position: absolute;
            left: 30%;
            top: 30%;
            width: 50%;
            text-align: center;
            vertical-align: middle;
            height: 300px;
        }

        .news {
            position: relative;
            border: 1px solid red;
            width: 90%;
        }
    </style>
</head>
<body>
<div id="form">
    <form name="addNews" action="/admin/addPost/news" method="post">
        <textarea name="head" class="news" rows="5" placeholder="Имя новости"></textarea><br>
        <textarea name="content" class="news" rows="5" placeholder="Содержание"></textarea><br>
        <label>Фото (Путь до файла)<input id="file" type="file" name="photo"></label><br>
        <input type="submit" value="Готово">
    </form>
</div>
</body>
</html>
