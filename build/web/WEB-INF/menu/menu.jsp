<%-- 
    Document   : menu
    Created on : Jan 25, 2021, 2:35:10 PM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Библиотека</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-link" href="listItem">Список предметов</a>
            <a class="nav-link" href="addMoneyForm">Пополнить кошелёк</a>
            <a class="nav-link" href="buyItemForm">Купить товар</a>
            
            <a class="nav-link" href="addItem">Добавить предмет</a>
            <a class="nav-link" href="editItemForm">Изменить данные предмета</a>

            <a class="nav-link" href="listUser">Список пользователей</a>

            <a class="nav-link" href="register">Регистрация</a>
            <a class="nav-link" href="loginForm">Вход</a>
            <a class="nav-link" href="logout">Выход</a>
        </div>
    </div>
  </div>
</nav>