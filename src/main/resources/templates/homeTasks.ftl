<#import "parts/common.ftl" as c>

<@c.page>
    Здесь будет домашка!
    <div>Домашние задания ученика </div>
    <#list homeTasks as homeTask>
        <div>
            <b>${homeTask.date}</b>
            <span>${homeTask.body}</span>
        </div>
    </#list>
    <div>
        <form <#--action="/homeTasks/**" -->method="post">
            <input type="text" name="date" placeholder="Дата">
            <input type="text" name="body" placeholder="Задание">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Сохранить</button>
        </form>
    </div>
</@c.page>