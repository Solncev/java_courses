<!doctype html>
<html lang="en">
<head>
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/css/login.css" rel="stylesheet" type="text/css"/>
    <link href="/css/signin.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="container">
    <#if error?? && error>
        <div class="alert">Неверный логин или пароль</div>
    </#if>
    <form class="form-signin" action="login" method="post">
        <input type="text" name="username" class="form-control">
        <input type="password" name="password" class="form-control">
        <button id="login-btn" class="btn btn-sm" type="submit">Войти</button>
    </form>
</div>

</body>
<script src="/js/jquery-1.10.2.min.js"></script>
</html>






<#--<#include "base.ftl">-->

<#--<#macro content>-->
<#--<a href="/guest">Guest</a>-->
<#--<form method="post" action="login">-->
<#--<input type="text" name="login"-->
<#--<#if login?has_content>-->
<#--value="${login}"-->
<#--</#if>-->
<#-->-->

<#--<input type="password" name="password">-->

<#--<br>-->
<#--<#if err?has_content>-->
<#--<h3>${err}</h3>-->
<#--</#if>-->
<#--<br>-->

<#--<input type="submit" value="login">-->
<#--</form>-->
<#--<script src-->
<#--</#macro>-->


