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
        <h1>Добавление денег</h1>
        
        <form action="customerChoice" method="POST">
            <select id="customerChoice" name="customerID">
                <option value="">Выберите покупателя</option>
                <c:forEach var="customer" items="${listCustomer}">
                    <option value="${customer.id}" id="${customer.id}">${customer.name} ${customer.surname} ${customer.phone} ${customer.email}</option>
                </c:forEach>
            </select>
                <input type="submit" value="Выбрать">
        </form>
                
        <form action="addMoney" method="POST" id="addMoney">
            <span>В данный момент денег: ${customer.money} евро</span><br>
            <input type="number" name="money" id="name" placeholder="Введите сколько добавить">
            <input type="submit" value="Добавить">
            <input name="customerID" style="display: none" value="${customer.id}">
        </form>
    </body>
    
    <script>
        addMoney = document.getElementById("addMoney");
        customer = '${customer}';
        
        if (customer === ""){
            addMoney.style.display = "none";
        } else {
            addMoney.style.display = "block";
            customerChoice = document.getElementById("customerChoice");
            customerChoice.value = '${customer.id}';
        }
        
    </script>
</html>
