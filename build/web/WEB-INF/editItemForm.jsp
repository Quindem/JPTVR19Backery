<%-- 
    Document   : editItemForm
    Created on : 16.12.2020, 9:23:07
    Author     : Alebro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="choiceItem" method="POST">
            <select id="itemChoice" name="itemId">
                <option value="">Выберите товар</option>
                <c:forEach var="item" items="${listItem}">
                    <option value="${item.id}" id="${item.id}">${item.name} ${item.price} евро ${item.quantity} шт.</option>
                </c:forEach>
            </select>
            <input type="submit" value="Выбрать">
        </form>
        
        <form action="editItem" method="POST" id="inputForm">
            <div class="row">
                <div class="block"><span>Название предмета</span></div>
                <div class="block"><input type="text" name="name" placeholder="Введите название" value="${item.name}"></div>
            </div>
            <div class="row">
                <div class="block"><span>Цена предмета</span></div>
                <div class="block"><input type="text" name="price" placeholder="Введите цену" value="${item.price}"></div>
            </div>
            <div class="row">
                <div class="block"><span>Количество предмтов</span></div>
                <div class="block"><input type="text" name="quantity" placeholder="Введите количество" value="${item.quantity}"></div>
            </div>
            <input type="submit" name="submit" value="Изменить">
            <input name="itemID" id="itemID" style="display: none" value="${item.id}">
        </form>
    </body>
    
    <script>
        item = '${item}';
        itemChoice = document.getElementById("itemChoice");
        inputForm = document.getElementById("inputForm");
        if (item === ""){          
            inputForm.style.display = 'none';
        } else {
            inputForm.style.display = 'block';
            id = '${item.id}';
            itemChoice.value = id;
            
        }
    </script>
</html>
