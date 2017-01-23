<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<h2>ORG</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Удалить</th>

    </tr>
    <c:forEach var="org" items="${orgs}">
        <tr>
            <td>${org.orgId}</td>
            <td>${org.orgName}</td>
            <td></td>
        </tr>
    </c:forEach>
</table>
   <br/>
   <br/>
   <br/>
   <br/>
   <br/>
   <br/>

<a href="/smp">Welcome page</a>
