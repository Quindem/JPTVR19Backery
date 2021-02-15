
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление покупател</title>
    </head>
    <body>
        <form action="login" method="POST">
            <div class="col-md-4 offset-md-4">
                <h3 class="mb-3 mt-5">Вход</h3>
                <div class="input-group mb-3">
                    <span class="input-group-text">Логин</span>
                    <input name="login" type="text" aria-label="Логин" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Пароль</span>
                    <input name="password" type="password" aria-label="Пароль" class="form-control">
                </div>
                <input type="submit" name="submit" value="Войти" class="btn btn-outline-dark w-100">
            </div>
        </form>
    </body>
</html>
