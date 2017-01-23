<%--
  Created by IntelliJ IDEA.
  User: Sergey_Stefoglo
  Date: 1/21/2017
  Time: 6:31 PM
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
    <title>Поставщики</title>
</head>
<form:form method="post" action="/smp/provider/save">
    <table>
          <tr>
            <td>Наименование </td>
            <td>
                <form:input path="name"  />
                <form:hidden path="providerId"  />
            </td>
        </tr>
        <tr>
            <td>Телефон</td>
            <td><form:input path="phone" /></td>
        </tr>
        <tr>
            <td> Описание</td>
            <td><form:input path="description"/></td>
        </tr>

    </table>
    <input type="submit" value="Save" />
</form:form>
</body>
</html>
