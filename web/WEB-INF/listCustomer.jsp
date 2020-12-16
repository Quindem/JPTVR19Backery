<%-- 
    Document   : listCustomer
    Created on : 16.12.2020, 8:44:21
    Author     : Alebro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список покупателей</title>
    </head>
    <body>
        <h1>Список покупателей</h1>
        <table border="1">
                <tr>
                    <td>Имя</td>
                    <td>Фамилия</td>
                    <td>Телефон</td>
                    <td>Почта</td>
                </tr>
            <c:forEach var="customer" items="${listCustomers}">
                <tr>
                    <td>${customer.name}</td>
                    <td>${customer.surname}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.email}</td>
                </tr>
            </c:forEach>
        </table>
        
        <a href="index">Назад</a>
    </body>
</html>
