
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление покупател</title>
    </head>
    <body>
        <h1>Добавление покупателя!</h1>
        
        <form action="createCustomer" method="POST">
            <div class="row">
                <div class="block"><span>Имя пользователя</span></div>
                <div class="block"><input type="text" name="name" placeholder="Введите имя"></div>
            </div>
            <div class="row">
                <div class="block"><span>Фамилия пользователя</span></div>
                <div class="block"><input type="text" name="surname" placeholder="Введите фамилию"></div>
            </div>
            <div class="row">
                <div class="block"><span>Номер телефона</span></div>
                <div class="block"><input type="text" name="phone" placeholder="Введите телефон"></div>
            </div>
            <div class="row">
                <div class="block"><span>Электронная почта</span></div>
                <div class="block"><input type="text" name="email" placeholder="Введите почту"></div>
            </div>
            <input type="submit" name="submit" value="Добавить">
        </form>
    </body>
</html>
