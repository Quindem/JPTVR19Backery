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
        <a href="addItem" class="btn btn-outline-secondary btn-lg w-100">Добавить новый товар</a>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Фотография</th>
                    <th scope="col">Название</th>
                    <th scope="col">Количество</th>
                    <th scope="col">Цена</th>
                    <th scope="col"></th>
                  </tr>
            </thead>
            <tbody>  
                <c:forEach var="item" items="${listItem}">
                    <tr>
                        <th scope="row">${item.id}</th>
                        <td> <img src="insertCover/${item.cover.path}" alt="..." class="w-25"></td>
                        <td>${item.name}</td>
                        <td>${item.quantity}</td>
                        <td>${item.price}€</td>
                        <td>
                            <form action="editItemForm" method="POST">
                                <input class="d-none" value="${item.id}" name="itemID">
                                <button type="subbmit" class="btn btn-secondary">Изменить</button>
                            </form>
                        </td>             
                    </tr>
                </c:forEach>   
            </tbody>
        </table>
    </body>
    
    <script>
        
    </script>
</html>
