<#import "parts/common.ftl" as c>
<@c.page>
    <p>Здесь будут выкладываться полезные материалы!</p>
    Домашнее задание:
    <#list homeTasks as homeTask>
        <div>
            <b>${homeTask.date}</b>
            <span>${homeTask.body}</span>
        </div>
    </#list>

</@c.page>

