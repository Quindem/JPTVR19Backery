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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" ">
        <title>Добавление предмета</title>
    </head>
    <body> 
        <form action="createItem" method="POST" enctype="multipart/form-data" class="col-md-4 offset-md-4">
            <h3>Добавить предмет</h3>
            <div class="input-group mb-3 mt-3">
                <input name="name" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Название">
            </div>
            <div class="input-group mb-3">
                <input name="quantity" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Количество">
                <span class="input-group-text">шт.</span>
            </div>
            <div class="input-group mb-3">
                <input name="price" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Цена">
                <span class="input-group-text">€</span>
            </div>
            <div class="mb-3">
                <input class="form-control" type="file" name="file" id="formFile">
            </div>
            <div class=" row mb-3  d-none">
              <label for="description" class="form-label">Описание</label>
              <input class="form-control" type="text" name="description" id="description">
            </div>
            
 
            <label for="customRange2" class="form-label">Количество конфигураций</label>
            <input id="confRange" type="range" value="0" class="form-range" min="0" max="8" id="customRange2">
            
            <div class="input-group mb-2" id="confDiv">
                <input id="conf1" name="conf1" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input id="conf2" name="conf2" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input id="conf3" name="conf3" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="ccoonfDiv">
                <input id="conf4" name="conf4" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input id="conf5" name="conf5" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input id="conf6" name="conf6" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input id="conf7" name="conf7" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input id="conf8" name="conf8" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <input class="w-100" type="submit" name="submit" value="Добавить">
        </form>
        
        
        <!-- 
        <div class="row">
            <div class="block"><span>Тип предмета</span></div>
            <select id="itemChoice" name="itemId">
                <c:forEach var="item" items="${listItemTypes}">
                    <option value="${item.id}" id="${item.id}">${item.type}</option>
                </c:forEach>
            </select>
        </div>
        -->
        
        <script>
            const confRange = document.getElementById("confRange");
            const confList = [];
            lastValue = 0;
            for (var i = 0; i < confRange.max; i++){
                
                name = "conf" + (i + 1);
                confList.push(document.getElementById(name));
                confList[i].style = "display: none";
                
            }
            confRange.addEventListener("change", () => {
                if (confRange.value > lastValue){
                    for (var i = 0; i < confRange.value; i++){
                        confList[i].style = "display: block";
                    }
                } else {
                    for (var i = 7; i > confRange.value - 1; i--){
                        confList[i].style = "display: none";
                    }
                }
                lastValue = confRange.value;
            });
        </script>
    </body>
</html>
