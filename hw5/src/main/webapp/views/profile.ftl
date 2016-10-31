<!DOCTYPE html>
<html lang="en">
<head>
    <title>Profile</title>
</head>

<body>
<#if error??>
<div class="alert">Пароль и логин изменены</div>
</#if>

<form class="form-signin" action="profile" method="post">
    Изменить логин
    <input type="text" name="username" class="form-control">
    Изменить пароль
    <input type="password" name="password" class="form-control">
    <button id="login-btn" class="btn btn-sm" type="submit">Изменить</button>
</form>
<#if first??>
${first}
${last}
</#if>



</body>
</html>