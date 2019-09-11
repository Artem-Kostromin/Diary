<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <h2>Добро пожаловать на страницу регистрации!</h2>
   <#-- ${message}-->

    <@l.login "/login"/>

    <a href="/registration">Создание новой учетной записи</a>
</@c.page>


