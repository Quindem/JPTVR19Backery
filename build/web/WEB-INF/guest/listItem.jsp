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
        <div class="row row-cols-1 row-cols-md-4 g-1">
            <c:forEach var="item" items="${listItem}">
                <form action="buyItemForm" method="POST">
                    <input type="text" class="d-none" name="itemID" value="${item.id}">
                    <div class="col">
                        <div class="card" style="border: none; border-radius: none">
                            <img src="insertCover/${item.cover.path}" class="card-img-top" alt="..." style="border-radius: none; height: 410px">
                            <div class="card-body">
                                <h6 class="card-text">${item.name}</h6>
                                    <div class="btn-group w-100 mt-4 mb-4" role="group" aria-label="Basic radio toggle button group">
                                        <c:forEach var="conf" items="${item.conf}">                                       
                                                <input value="${conf}" type="radio" class="btn-check" name="option${item.id}" id="${item.id}_${conf}" autocomplete="off" checked style="w-max">
                                                <label class="btn btn-outline-dark" for="${item.id}_${conf}">${conf}</label>
                                        </c:forEach>
                                    </div>                     
                                <div class="d-flex justify-content-between align-items-end">
                                    <p class="card-text">${item.price} €</p>
                                    <c:choose>
                                        <c:when test="${item.quantity == 0}"><button type="subbmit" class="btn btn-success" disabled>Купить</button></c:when> 
                                        <c:otherwise><button type="subbmit" class="btn btn-outline-success">Купить</button></c:otherwise>   
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </c:forEach>
        </div>          
        
        
        <script>
            
        </script>
    </body>
</html>
