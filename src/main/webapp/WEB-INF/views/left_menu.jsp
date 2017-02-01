<%--
  Created by IntelliJ IDEA.
  User: Sergey_Stefoglo
  Date: 1/27/2017
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<a href="/smp/state/list">Склад</a><br/>
<a href="/smp/upl/">Загрузка файла</a><br/>



<a href="/smp/provider/list">Поставщики</a><br/>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/smp/users/list">Пользователи</a><br/>
    <a href="/smp/org/list">Организации</a><br/>
</sec:authorize>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<a href="/smp/logout">Выход</a>
