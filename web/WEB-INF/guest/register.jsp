
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление покупателя</title>
    </head>
    <body>
        <form action="createUser" method="POST">
            <div class="col-md-4 mt-5 offset-md-4">
                <h3 class="mb-3">Регистрация</h3>
                <div class="input-group mb-3">
                    <span class="input-group-text">Логин</span>
                    <input name="login" type="text" aria-label="Логин" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Пароль</span>
                    <input name="password" type="password" aria-label="Пароль" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Имя и Фамилия</span>
                    <input name="name" type="text" aria-label="First name" class="form-control">
                    <input name="surname" type="text" aria-label="Last name" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Телефон</span>
                    <input name="phone" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Почта</span>
                    <input name="email" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>
          
                <input type="submit" name="submit" value="Регистрация" class="btn btn-outline-dark w-100">
            </div>
        </form>
    </body>
</html>
