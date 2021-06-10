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
        <form action="editUser" method="POST">
            <input type="text" value="${user.id}" name="userID" style="display: none">
            <div class="col-md-4 offset-md-4">
                <h3 class="mb-3">Изменение пользователя ${user.login}</h3>
                <div class="input-group mb-3">
                    <span class="input-group-text">Имя и Фамилия</span>
                    <input name="name" value="${user.name}" type="text" aria-label="First name" class="form-control">
                    <input name="surname" value="${user.surname}" type="text" aria-label="Last name" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <select name="role" id="roleSelect" class="form-select" id="inputGroupSelect01">
                        <c:forEach var="role" items="${listRole}">
                            <option value="${role.id}">${role.type}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Телефон</span>
                    <input name="phone" value="${user.phone}" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Почта</span>
                    <input name="email" value="${user.email}" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>

                <div class="input-group">
                    <input name="money" value=${user.money} type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
                    <span class="input-group-text">€</span>
                </div>
                    
                <input type="submit" name="submit" value="Изменить" class="btn btn-primary mt-3 w-100">
            </div>
        </form>
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
