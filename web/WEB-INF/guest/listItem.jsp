<%-- 
    Document   : listItem
    Created on : 16.12.2020, 10:33:36
    Author     : Alebro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список предметов</title>
    </head>
    <body>
        <h1>Спимок предметов</h1>
        <div class="row row-cols-1 row-cols-md-4 g-1">
            <c:forEach var="item" items="${listItem}">
                <div class="col">
                    <div class="card" style="border: none; border-radius: none">
                        <img src="https://i.imgur.com/yQSJhdv.jpg" class="card-img-top" alt="..." style="border-radius: none">
                        <div class="card-body">
                            <h6 class="card-text">${item.name}</h6>
                                <div class="mt-3 mb-2 d-flex justify-content-between flex-wrap align-content-between" style="min-height: 85px">
                                    <c:forEach var="conf" items="${item.conf}">
                                        <input type="radio" class="btn-check" name="options" id="${conf}" autocomplete="off" checked style="w-max">
                                        <label class="btn btn-secondary" for="${conf}">${conf}</label>
                                    </c:forEach>
                                </div>                      
                            <p class="card-text">${item.price} €</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>          
        
    </body>
</html>
