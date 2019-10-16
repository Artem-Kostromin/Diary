<#import "parts/common.ftl" as c>

<@c.page>
    <div>Домашние задания ${userName} </div>
    <#list homeTasks as homeTask>
        <div>
            <b>${homeTask.date}</b>
            <span>${homeTask.body}</span>
        </div>
    <#else>
        У данного пользователя пока нет домашнего задания.
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