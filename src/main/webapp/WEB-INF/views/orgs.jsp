<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<table>
    <tr colspan="2">
        <font size="8">Система Управления Продуктами (СУП)</font>
    </tr>
    <tr>
        <td><font size="5">Пользователи</font></td>
        <td>


        </td>
    </tr>
    <tr>

        <td width="200" valign="top">
            <a href="/smp/state/list">Склад</a><br/>
            <a href="/smp/upl/">Загрузка файла</a><br/>
            <a href="/smp/users/list">Пользователи</a><br/>
            <a href="/smp/org/list">Организации</a><br/>
            <a href="/smp/provider/list">Поставщики</a><br/>


        </td>
        <td>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Удалить</th>
        <th>Редактировать пользователей</th>
    </tr>
    <c:forEach var="org" items="${orgs}">
        <tr>
            <td>${org.orgId}</td>
            <td>${org.orgName}</td>
            <td>
                <form:form method="post" action="/smp/org/delete" acceptCharset="UTF-8">
                    <input type="hidden" name="orgId" value="${org.orgId}">
                    <input type="submit" name="delete" value="Удалить"/>

                </form:form>
            </td>
            <td>
                <form:form method="post" action="/smp/users/listLite" acceptCharset="UTF-8">
                    <input type="hidden" name="orgId" value="${org.orgId}">
                    <input type="submit" name="edit" value="Редактировать"/>

                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<br/>
<br/>
<br/>
<br/>

<br/>
<form:form method="post" action="/smp/org/add" acceptCharset="UTF-8">

    <input type="text" name="orgName">
    <input type="submit" value="создать"/>
</form:form>
        </td>
    </tr>
</table>
