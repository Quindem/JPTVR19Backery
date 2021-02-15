<%-- 
    Document   : addMoneyForm
    Created on : 16.12.2020, 10:40:04
    Author     : Alebro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление денег</title>
    </head>
    <body>     
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <form action="addMoney" method="POST" id="addMoney">
                        <input class="d-none" value="${user.id}" name="userID" type="text">
                        <p class="fs-4">Полполение счёта</p>
                        <p class="fs-5">На счету имеется ${user.money}€</p>
                        <div class="input-group mb-2">
                            <input name="money" type="text" class="form-control" aria-label="">
                            <span class="input-group-text">€</span>
                        </div>
                        <button type="subbmit" class="btn btn-outline-secondary w-100">Пополнить</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
    
    <script>
        
    </script>
</html>
