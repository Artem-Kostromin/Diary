<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
${message?ifExcists}
<@l.login "/registration"/>
</@c.page>
