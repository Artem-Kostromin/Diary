<#import "parts/common.ftl" as c>

<@c.page>
 <#--   <div>
        <form method="post">
            <input type="text" name="studentname" placeholder="Имя учащегося"/>
            <input type="text" name="classNumber" placeholder="Класс"/>
            <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>-->

    <div>Список учащихся</div>
    <#list users as user>
        <div>
            <a href="http://localhost:8080/homeTasks/?foo=${user.username}">${user.username}</a>
            <span>${user.password}</span>
        </div>
    </#list>
</@c.page>




