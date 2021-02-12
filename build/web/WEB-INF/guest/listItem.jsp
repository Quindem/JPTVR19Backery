<%-- 
    Document   : listItem
    Created on : 16.12.2020, 10:33:36
    Author     : Alebro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список предметов</title>
    </head>
    <body>
        <h1>Спимок предметов</h1>
        <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Название</td>
                    <td>Цена</td>
                    <td>Количество</td>
                </tr>
            <c:forEach var="item" items="${listItem}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price} евро</td>
                    <td>${item.quantity} шт.</td>
                </tr>
            </c:forEach>
        </table>
        
        <a href="index">Назад</a>
    </body>
</html>
