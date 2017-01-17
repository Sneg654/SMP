<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>ORG</h2>
<table border="1">
    <tr>
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
        <tr>
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

        </tr>
        <%--#end--%>
    </c:forEach>
</table>
<c:forEach var="i" begin="1" end="10" step="1">
    <c:out value="${i}" />
    <br />
</c:forEach>
<a href="/smp">Welcome page</a>
</body>
</html>