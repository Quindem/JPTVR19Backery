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
        <h1>Покупка товара</h1>
        <form action="buyItem" method="POST">
            <span>Выберите покупателя</span><br>
            <select id="customerChoice" name="customerID">
                <option value="">Выберите покупателя</option>
                <c:forEach var="customer" items="${listCustomer}">
                    <option value="${customer.id}" id="${customer.id}">${customer.name} ${customer.surname} ${customer.phone} ${customer.email}</option>
                </c:forEach>
            </select>
                <br>
            <span>Выберите товар</span><br>
            <select id="itemChoice" name="itemID">
                <option value="">Выберите товар</option>
                <c:forEach var="item" items="${listItem}">
                    <option value="${item.id}" id="${item.id}">${item.name} ${item.price} евро ${item.quantity} шт.</option>
                </c:forEach>
            </select>  
            <input type="submit" value="Купить">
        </form>
    </body>
</html>
