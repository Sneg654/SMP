<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<h2>provider</h2>
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
        <th>phone</th>
        <th>description</th>
        <th>Редактировать</th>
        <th>Удалить</th>
    </tr>
    <c:forEach var="provider" items="${providers}">
        <tr>
            <td>${provider.providerId}</td>
            <td>${provider.name}</td>
            <td>${provider.phone}</td>
            <td>${provider.description}</td>

            <td>
                <form:form method="post" action="/smp/provider/provcorrect" acceptCharset="UTF-8">
                    <input type="hidden" name="providerId" value="${provider.providerId}">
                    <input type="submit" name="edit" value="Редактировать"/>
                </form:form>

            </td>


            <td>
                <form:form method="post" action="/smp/provider/delete" acceptCharset="UTF-8">
                    <input type="hidden" name="providerId" value="${provider.providerId}">
                    <input type="submit" name="delete" value="Удалить"/>
                </form:form>

            </td>
        </tr>
    </c:forEach>
</table>


<form:form method="post" action="/smp/provider/provform" acceptCharset="UTF-8">

    <input type="submit" name="change" value="Добавить нового поставщика"/>
</form:form>

        </td>
    </tr>
</table>

