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
<table>
    <tr colspan="2">
        <font size="8">Система Управления Продуктами (СУП)</font>
    </tr>
    <tr>
        <td width="200"><font size="5">Редактирование поставищика</font></td>
        <td>


        </td>
    </tr>
    <tr>

        <td width="200" valign="top">
            <jsp:include page="../left_menu.jsp"/>



        </td>
        <td  valign="top">
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
            <td><form:textarea path="description"/></td>
        </tr>

    </table>
    <input type="submit" value="Сохранить" />
</form:form>
        </td>
    </tr>
</table>
</body>
</html>
