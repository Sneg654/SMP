<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Users</h2>
<%@ page isELIgnored="false" %>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Login</th>
    </tr>
    <%--#foreach($usr in $users)--%>

<c:forEach var="usr" items="${users}">
        <tr>
            <td>${usr.userId}</td>
            <td>${usr.name}</td>
            <td>${usr.login}</td>
        </tr>
    <%--#end--%>
    </c:forEach>
</table>

<a href="/smp">Welcome page</a>
