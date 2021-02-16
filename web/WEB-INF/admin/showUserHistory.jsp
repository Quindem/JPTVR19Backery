<%-- 
    Document   : editCustomerForm
    Created on : 15.12.2020, 18:20:03
    Author     : Alebro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Изменение пользователя</title>
    </head>
    <body onload="funonload();" class="d-flex align-items-center">
        <div class="container">
            <div class="row">
                    <table class="table">
                        <thead>
                          <tr>
                                <th scope="col">#</th>
                                <th scope="col">Назвние товара</th>
                                <th scope="col"></th>
                          </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="history" items="${listHistory}">
                                <tr>
                                    <th scope="row">${history.id}</th>
                                    <td>${history.item.name}</td>
                                    <td class="w-25"><img src="insertCover/${history.item.cover.path}" alt="..." class="w-50"></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </div>
        </div>
    </body>
    
    <script>
        function funonload() {
            select = document.getElementById("roleSelect")
            select.value = '${user.roleID}';
        }
        
        const userID = "${user.id}";
        if (userID === "1"){
            document.getElementById("roleSelect").disabled = true;
        }
    </script>
</html>
