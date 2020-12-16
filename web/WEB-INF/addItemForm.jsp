<%-- 
    Document   : addItem
    Created on : 16.12.2020, 8:56:27
    Author     : Alebro
--%>

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
            <div class="row">
                <div class="block"><span>Количество предмтов</span></div>
                <div class="block"><input type="text" name="quantity" placeholder="Введите количество"></div>
            </div>
            <input type="submit" name="submit" value="Добавить">
        </form>
    </body>
</html>
