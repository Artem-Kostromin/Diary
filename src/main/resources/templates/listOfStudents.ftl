<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        <form method="post">
            <input type="text" name="studentname" placeholder="Имя учащегося"/>
            <input type="text" name="classNumber" placeholder="Класс"/>
            <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список учащихся</div>
    <#list students as student>
        <div>
            <b>${student.studentname}</b>
            <span>${student.classNumber}</span>
        </div>
    </#list>
</@c.page>




