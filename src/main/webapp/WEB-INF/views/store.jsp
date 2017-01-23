<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<h2>ORG</h2>
<table border="1">
    <tr>
        <th></th>
        <th>nomeclatureID</th>
        <th>Id</th>
        <th>Name</th>
        <th>min</th>
        <th>max</th>
        <th>fold</th>
        <th>cost</th>
        <th>providerId</th>
        <th>send</th>
        <th>check</th>
    </tr>
    <%--<c:out value="${stateStores.lenght}"> </c:out>--%>
    <c:forEach var="store" items="${stateStores}">
        <%--#foreach($store in $stateStores)--%>
        <%--<form:form method="post" action="/smp/state/det/${store.nomeclatureID}/${store.orgId}">--%>
        <form:form method="post" action="/smp/state/det"  acceptCharset="UTF-8" >

            <tr>
                <td>
                    <input type="hidden" name="id"  value="${store.nomeclatureID}"  >
                    <input type="hidden" name="orgId"  value="${store.orgId}" >
                    <input type="submit" name="change" value="change"/>

                </td>

                <td>${store.nomeclatureID}</td>
                <td>${store.orgId}</td>
                <td>${store.name}</td>
                <td>${store.min}</td>
                <td>${store.max}</td>
                <td>${store.fold}</td>
                <td>${store.cost}</td>
                <td>${store.providerId}</td>
                <td>${store.send}</td>
                <td>${store.check}</td>
                <c:set var="store" value="${store}" scope="request"/>
            </tr>

        </form:form>

              <%--<c:set var="store" value="${store}" scope="request"/>--%>
        <%--#end--%>
    </c:forEach>





</table>

<a href="/smp">Welcome page</a>
</body>
</html>