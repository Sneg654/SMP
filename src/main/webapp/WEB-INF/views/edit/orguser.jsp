<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sergey_Stefoglo
  Date: 1/24/2017
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<table>
    <tr colspan="2">
        <font size="8">Система Управления Продуктами (СУП)</font>
    </tr>
    <tr>
        <td width="200"><font size="5">Редактирование Пользователя</font></td>
        <td>


        </td>
    </tr>
    <tr>

        <td width="200" valign="top">
            <jsp:include page="../left_menu.jsp"/>


        </td>
        <td>
<form:form method="post" action="/smp/users/saveList" modelAttribute="users" acceptCharset="UTF-8">
 <table border="1">
 <tr>
     <td> Есть права </td>
     <td>Имя пользователя</td>

 </tr>

     <c:forEach items="${users}" var="user">
    <tr>
         <td>
             <c:if test="${user.added}">
                 <input type="checkbox" name="id${user.userId}" checked value="!id_${user.userId}" >
             </c:if>
             <c:if test="${!user.added}">
                 <input type="checkbox" name="id${user.userId}" value="!id_${user.userId}" >
             </c:if>
            </td>
         <td>${user.name}</td>
    </tr>

     </c:forEach>
 </table>
    <input type="hidden" name="orgId"  value="${orgId}">
    <input type="submit" value="Сохранить">
 </form:form>
        </td>
    </tr>
</table>
</body>
</html>
