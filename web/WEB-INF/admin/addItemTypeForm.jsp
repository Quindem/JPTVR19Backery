<%-- 
    Document   : addItemType
    Created on : Feb 12, 2021, 12:18:49 PM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addItemType" method="POST">
            <div class="row">
                <div class="block"><span>Название типа</span></div>
                <div class="block"><input type="text" name="name" placeholder="Введите название"></div>
            </div>
            <input type="submit" value="Добавить">
        </form>
    </body>
</html>
