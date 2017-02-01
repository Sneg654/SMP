<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<table>
    <tr colspan="2">
        <font size="8">Система Управления Продуктами (СУП)</font>
    </tr>
    <tr>
        <td><font size="5">Склад</font></td>
        <td align="right">
            <form:form method="post" action="/smp/state/listByOrg">
                <select id="choseOrgId" name="choseOrgId">

                    <c:forEach items="${orgs}" var="org">

                        <option value="${org.orgId}">${org.orgName}</option>

                    </c:forEach>
                </select>
                <input type="submit" value="Найти"/>
            </form:form>
        </td>
    </tr>
    <tr>

        <td width="200" valign="top">
            <jsp:include page="left_menu.jsp"/>
        </td>
        <td>
            Наименование учереждения: ${orgName}
            <table border="1">
                <tr>

                    <th>Номеклатура</th>
                    <%--<th>Id</th>--%>
                    <th>Наименование</th>
                    <th>Минимум</th>
                    <th>Максимум</th>
                    <th>Кратность</th>
                    <th>Цена</th>
                    <th>Поставщик</th>
                    <%--<th>send</th>--%>
                    <th>Проверять</th>
                    <th>Редактировать</th>
                </tr>
                <%--<c:out value="${stateStores.lenght}"> </c:out>--%>
                <c:forEach var="store" items="${stateStores}">
                    <%--#foreach($store in $stateStores)--%>
                    <%--<form:form method="post" action="/smp/state/det/${store.nomeclatureID}/${store.orgId}">--%>
                    <form:form method="post" action="/smp/state/det" acceptCharset="UTF-8">

                        <tr>

                            </td>

                            <td>${store.nomeclatureID}</td>
                            <%--<td>${store.orgId}</td>--%>
                            <td>${store.name}</td>
                            <td>${store.min}</td>
                            <td>${store.max}</td>
                            <td>${store.fold}</td>
                            <td>${store.cost}</td>
                            <td>
                            ${store.provider.name}
                            </td>
                                <%--<td>${store.send}</td>--%>
                            <td>
                                <c:if test="${store.check}">
                                    <input type="checkbox" checked readonly="true" disabled="true">

                                </c:if>
                                <c:if test="${!store.check}">
                                    <input type="checkbox" readonly="true" disabled="true">
                                </c:if>
                            </td>
                            <td>
                                <input type="hidden" name="id" value="${store.nomeclatureID}">
                                <input type="hidden" name="orgId" value="${store.orgId}">
                                <input type="submit" name="change" value="Редактировать"/>

                                    <c:set var="store" value="${store}" scope="request"/>
                        </tr>

                    </form:form>

                    <%--<c:set var="store" value="${store}" scope="request"/>--%>
                    <%--#end--%>
                </c:forEach>


            </table>

        </td>
    </tr>
</table>
<a href="/smp/logout">Выход</a>
</body>
</html>