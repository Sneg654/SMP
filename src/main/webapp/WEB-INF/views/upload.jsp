<%--
  Created by IntelliJ IDEA.
  User: Sergey_Stefoglo
  Date: 1/17/2017
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<form method="POST" action="/smp/uploadFile" enctype="multipart/form-data">
<table>
    <tr colspan="2">
        <font size="8">Система Управления Продуктами (СУП)</font>
    </tr>
    <tr>
        <td><font size="5">Загрузить файл</font></td>
        <td align="right">
             Выберети учереждение:
                <select id="choseOrgId" name="choseOrgId">

                    <c:forEach items="${orgs}" var="org">

                        <option value="${org.orgId}">${org.orgName}</option>

                    </c:forEach>
                </select>


        </td>
    </tr>
    <tr>

        <td width="200" valign="top">
            <jsp:include page="left_menu.jsp"/>
        </td>
        <td>

    Файл <input type="file" name="file">


    <input type="submit" value="Загрузить">

    </td>
    </tr>
    <tr>
       <td/>
        <br/>
        <br/>
        <br/>
        <td align="center"> <font size="6" color="red">${message}</font></td>
    </tr>
    </table>
</form>
</body>
</html>

