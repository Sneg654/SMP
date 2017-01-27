<%--
  Created by IntelliJ IDEA.
  User: Sergey_Stefoglo
  Date: 1/16/2017
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>Add New Employee</h1>
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

        <td width="200">
            <a href="/smp/state/list">Склад</a><br/>
            <a href="/smp/upl/">Загрузка файла</a><br/>
            <a href="/smp/users/list">Пользователи</a><br/>
            <a href="/smp/org/list">Организации</a><br/>
            <a href="/smp/provider/list">Поставщики</a><br/>


        </td>
        <td>
<form:form method="post" action="save">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  />
                <form:hidden path="userId"  /></td>
        </tr>
        <tr>
            <td>Login :</td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td>Phone :</td>
            <td><form:input path="phone" /></td>
        </tr>
        <tr>
            <td>Role :</td>
            <td><form:input path="role" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
        </td>
    </tr>
</table>
</body>
</html>
