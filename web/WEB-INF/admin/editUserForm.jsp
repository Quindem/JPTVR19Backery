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
        <title>Список покупателей</title>
    </head>
    <body>
        <h1>Список покупателей</h1>
        <form action="editUser" method="POST">
            <select id="customerChoice" name="customer">
                <option value="">Выберите покупателя</option>
                <c:forEach var="customer" items="${listUser}">
                    <option value="${customer.id}" id="${customer.id}">${customer.name} ${customer.surname} ${customer.phone} ${customer.email}</option>
                </c:forEach>
            </select>
            
            <div class="row">
                <div class="block"><span>Имя пользователя</span></div>
                <div class="block"><input type="text" name="name" id="name" placeholder="Введите имя"></div>
            </div>
            <div class="row">
                <div class="block"><span>Фамилия пользователя</span></div>
                <div class="block"><input type="text" name="surname" id="surname" placeholder="Введите фамилию"></div>
            </div>
            <div class="row">
                <div class="block"><span>Номер телефона</span></div>
                <div class="block"><input type="text" name="phone" id="phone" placeholder="Введите телефон"></div>
            </div>
            <div class="row">
                <div class="block"><span>Электронная почта</span></div>
                <div class="block"><input type="text" name="email" id="email" placeholder="Введите почту"></div>
            </div>
            <input type="submit" name="submit" value="Изменить">
        </form>
    </body>
    
    <script>
        customerChoice = document.getElementById("customerChoice");
        listCustomer = '${listCustomer}';
        
        nameInput = document.getElementById("name");
        surnameInput = document.getElementById("surname");
        phoneInput = document.getElementById("phone");
        emailInput = document.getElementById("email");
        
        customerChoice.addEventListener("change", () => {
           option = document.getElementById(customerChoice.value);
           obj = option.innerHTML.split(" ");
           
           console.log(obj[0]);
           
           nameInput.value = obj[0];
           surnameInput.value = obj[1];
           phoneInput.value = obj[2];
           emailInput.value = obj[3];
        });
       
    </script>
</html>
