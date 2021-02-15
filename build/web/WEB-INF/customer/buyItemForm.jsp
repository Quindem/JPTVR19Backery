<%-- 
    Document   : buyItemForm
    Created on : 16.12.2020, 11:00:03
    Author     : Alebro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Покупка товара</title>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-7 offset-md-2">
                    <form action="buyItem" method="POST" class="d-flex">
                        <input type="text" class="d-none" name="itemID" value="${item.id}">
                        <input type="text" class="d-none" name="confIndex" value="${confIndex}">
                        <div class="w-50 me-3">
                            <img src="insertCover/${item.cover.path}" class="card-img-top" alt="..." style="border-radius: none">
                        </div>
                        <div class="d-flex flex-column justify-content-start mt-1">
                            <p class="fs-3 fw-bold">${item.name} (${conf})</p>
                            <p class="fs-4">Цена: ${item.price}€</p>
                            <p class="fs-4">Осталось на складе: ${item.quantity}</p>
                            <button type="subbmit" class="btn btn-outline-dark">Подтвердить покупку</button>
                        </div>        
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
