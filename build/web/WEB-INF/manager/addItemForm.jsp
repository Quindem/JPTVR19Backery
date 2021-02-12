<%-- 
    Document   : addItem
    Created on : 16.12.2020, 8:56:27
    Author     : Alebro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление предмета</title>
    </head>
    <body>
        <h1>Добавить предмет</h1>
        <form action="createItem" method="POST">
            <div class="row">
                <div class="block"><span>Название предмета</span></div>
                <div class="block"><input type="text" name="name" placeholder="Введите название"></div>
            </div>
            <div class="row">
                <div class="block"><span>Цена предмета</span></div>
                <div class="block"><input type="text" name="price" placeholder="Введите цену"></div>
            </div>
            </div>
            <div class="row">
                <div class="block"><span>Тип предмета</span></div>
                <select id="itemChoice" name="itemId">
                    <c:forEach var="item" items="${listItemTypes}">
                        <option value="${item.id}" id="${item.id}">${item.type}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="row">
                <div class="block"><span>Количество предметов</span></div>
                <div class="block"><input type="text" name="quantity" placeholder="Введите количество"></div>
            </div>
            <input type="submit" name="submit" value="Добавить">
        </form>
    </body>
</html>
