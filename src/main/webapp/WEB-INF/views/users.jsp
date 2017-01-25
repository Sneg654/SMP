<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page isELIgnored="false" %>
<table>
    <tr colspan="2">
        <font size="8">Система Управления Продуктами (СУП)</font>
    </tr>
    <tr>
        <td><font size="5">Пользователи</font></td>
        <td></td>
    </tr>
    <tr>

        <td width="200"></td>
        <td>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Login</th>
                    <th>Редактировать</th>
                    <th>Удалить</th>

                </tr>
                <%--#foreach($usr in $users)--%>

                <c:forEach var="usr" items="${users}">
                    <form:form method="post" action="/smp/users/usercorrect" acceptCharset="UTF-8">
                        <tr>
                        <td>
                            <input type="hidden" name="userId" value="${usr.userId}">
                                ${usr.userId}</td>
                        <td>${usr.name}</td>
                        <td>${usr.login}</td>
                        <td><input type="submit" name="change" value="Редактировать"/></td>
                    </form:form>
                    <td>
                        <form:form method="post" action="/smp/users/delete" acceptCharset="UTF-8">
                            <input type="hidden" name="userId" value="${usr.userId}">
                            <input type="submit" name="delete" value="Удалить"/>
                        </form:form>

                    </td>
                    </tr>

                    <%--#end--%>
                </c:forEach>
            </table>
            <form:form method="post" action="/smp/users/userform" acceptCharset="UTF-8">

                <input type="submit" name="change" value="Добавить пользователя"/>

            </form:form>
        </td>
    </tr>
</table>
