<#include "base.ftl">

<#macro content>
Secret Text.

<ul>
    <#if users?has_content>
        <#list users as u>
            <li><p>${u}</p></li>
        </#list>
    <#else>
        You don't have any friends.
    </#if>
</ul>
</#macro>