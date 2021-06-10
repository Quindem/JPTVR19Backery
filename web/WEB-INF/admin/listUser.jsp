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
        <h1>Список пользователей</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Логин</th>
                    <th scope="col">Имя Фамилия</th>
                    <th scope="col">Роль</th>
                    <th scope="col">Телефон</th>
                    <th scope="col">Почта</th>
                    <th scope="col">Счёт</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${listUser}">
                    
                        <tr class="align-middle">
                            <th scope="row">${user.id}</th>
                            <td>${user.login}</td>
                            <td>${user.name} ${user.surname}</td>
                            <td>${listRole[user.roleID - 1].type}</td>
                            <td>${user.phone}</td>
                            <td>${user.email}</td>
                            <td>${user.money}</td>
                            <td>
                                <form action="showUserHistory" method="POST">
                                    <input name="userID" value="${user.id}" style="display: none">
                                    <input type="submit" name="submit" value="Истоия покупок" class="btn btn-success"></td>
                                </form>
                            <td>
                                <form action="editUserForm" method="POST">
                                    <input name="userID" value="${user.id}" style="display: none">
                                    <input type="submit" name="submit" value="Изменить" class="btn btn-dark">
                                </form>
                            </td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <a href="index">Назад</a>
    </body>
</html>
