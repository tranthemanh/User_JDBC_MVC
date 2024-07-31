<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/31/2024
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quan Ly Nguoi Dung</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="10">
            <caption><h1>Sua Nguoi Dung</h1></caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value="${user.id}"/>"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="30" value="<c:out value="${user.name}"/>">
                </td>
            </tr>
            <tr>
                <th>Age:</th>
                <td>
                    <input type="text" name="age" size="15" value="<c:out value="${user.age}"/>">
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" size="25" value="<c:out value="${user.country}"/>">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Sua</button>
                    <button type="submit"><a href="/users">Quay lại</a></button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
