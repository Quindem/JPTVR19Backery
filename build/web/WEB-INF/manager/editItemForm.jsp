<%-- 
    Document   : editItemList
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
        <form action="editItem" method="POST" enctype="multipart/form-data" class="col-md-4 offset-md-4">
            <h3>Изменить предмет</h3>
            <input class="d-none" value="${item.id}" name="itemID">

            <div class="input-group mb-3 mt-3">
                <input value="${item.name}" name="name" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Название">
            </div>
            <div class="input-group mb-3">
                <input value="${item.quantity}" name="quantity" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Количество">
                <span class="input-group-text">шт.</span>
            </div>
            <div class="input-group mb-3">
                <input value="${item.price}" name="price" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Цена">
                <span class="input-group-text">€</span>
            </div>
            <div class=" row mb-3  d-none">
              <label for="description" class="form-label">Описание</label>
              <input class="form-control" type="text" name="description" id="description">
            </div>
            
 
            <label for="customRange2" class="form-label">Количество конфигураций</label>
            <input id="confRange" type="range" value="0" class="form-range" min="0" max="8" id="customRange2">
            
            <div class="input-group mb-2" id="confDiv">
                <input value="${item.conf[0]}" id="conf1" name="conf1" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input value="${item.conf[1]}" id="conf2" name="conf2" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input value="${item.conf[2]}" id="conf3" name="conf3" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="ccoonfDiv">
                <input value="${item.conf[3]}" id="conf4" name="conf4" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input value="${item.conf[4]}" id="conf5" name="conf5" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input value="${item.conf[5]}" id="conf6" name="conf6" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input value="${item.conf[6]}" id="conf7" name="conf7" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <div class="input-group mb-2" id="confDiv">
                <input value="${item.conf[7]}" id="conf8" name="conf8" type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)" placeholder="Конфигурации">
            </div>
            <input class="w-100 btn btn-dark" type="submit" name="submit" value="Изменить">
        </form>
                
                
        <input class="d-none" value="${item.conf.size()}" id="confSize">
        
    </body>
    
    <script>
        const confRange = document.getElementById("confRange");
        const confList = [];
        lastValue = 0;
        
        const confSize = parseInt(document.getElementById("confSize").value);
        document.getElementById("confRange").value = confSize;
        for (var i = 0; i < confRange.max; i++){
            name = "conf" + (i + 1);
            confList.push(document.getElementById(name));
            confList[i].style = "display: none";
        }
        for(var i = 0; i < confSize; i++){
            console.log(i);
            confList[i].style = "display: block";
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
</html>
