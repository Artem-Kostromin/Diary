<#import "parts/common.ftl" as c>
<@c.page>
    <p>Привет, ${username}!</p>
    Домашнее задание:
    <#list homeTasks as homeTask>
        <div>
            <b>${homeTask.date}</b>
            <span>${homeTask.body}</span>
        </div>
    </#list>

</@c.page>

