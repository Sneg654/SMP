<%--
  Created by IntelliJ IDEA.
  User: Sergey_Stefoglo
  Date: 1/18/2017
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/smp/state/saveStore">
    <table>
        <tr>
            <td> </td>
            <td><form:hidden path="send" readonly="true"/></td>
        </tr>
        <tr>
            <td> Номер</td>
            <td><form:input path="nomeclatureID" readonly="true"/></td>
        </tr>
        <tr>
            <td>Номеклатура</td>
            <td><form:input path="name" readonly="true"/></td>
        </tr>
        <tr>
            <td> Минимальное количество</td>
            <td><form:input path="min"/></td>
        </tr>
        <tr>
            <td> Максимальное количество</td>
            <td><form:input path="max"/></td>
        </tr>
        <tr>
            <td> Кратность</td>
            <td><form:input path="fold"/></td>
        </tr>
        <tr>
            <td> Цена</td>
            <td><form:input path="cost"/></td>
        </tr>

        <tr>
            <td> Количество</td>
            <td><form:input path="count"/></td>
        </tr>
        <tr>
            <td> Поставщик</td>
            <td>
                <form:input path="provider.name" readonly="true"/>
            </td>
        </tr>
        <tr>
            <td> Выбрать нвого поставщика</td>
            <td><select id="newProviderId" name="newProviderId">
                <option value="-1">не менять </option>
                <option value="0">удалить поставщика</option>

                <c:forEach items="${provs}" var="prov">

                    <option value="${prov.providerId}">${prov.name}</option>

                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td> Проверять</td>

            <td><form:checkbox path="check"/></td>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>
</body>
</html>
