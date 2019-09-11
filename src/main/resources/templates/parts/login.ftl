<#macro login path>
    <div>
        <form action="${path}" method="post">
            <input type="text" name="username" placeholder="Имя">
            <input type="text" name="password" placeholder="Пароль">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Войти</button>
        </form>
    </div>
</#macro>