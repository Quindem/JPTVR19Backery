
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление покупател</title>
    </head>
    <body>
        <h1>Добавление покупателя!</h1>
        ${info}
        <form action="login" method="POST">
            <div class="row">
                <div class="block"><span>Логин</span></div>
                <div class="block"><input type="text" name="login" placeholder="Введите имя"></div>
            </div>
            <div class="row">
                <div class="block"><span>Пароль</span></div>
                <div class="block"><input type="password" name="password" placeholder="Введите фамилию"></div>
            </div>
            
            <input type="submit" name="submit" value="Войти">
        </form>
    </body>
</html>
