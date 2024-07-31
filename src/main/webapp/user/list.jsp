<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/31/2024
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quan Ly Nguoi Dung</title>
</head>
<body>
<center>
    <h1>Quan Ly Nguoi Dung</h1>
    <form action="${pageContext.request.contextPath}/users" method="get">
        <input type="text" name="name" placeholder="Nhap ten nguoi dung">
        <input type="hidden" name="action" value="search">
        <button type="submit">Tìm kiếm</button>
    </form>
    <h2>
        <a href="/users?action=create">Them moi</a>
    </h2>

    <div>
        <h3>Sắp xếp theo:</h3>
        <a href="${pageContext.request.contextPath}/users?action=sortByIdASC">ID tăng dần</a> |
        <a href="${pageContext.request.contextPath}/users?action=sortByIdDESC">ID giảm dần</a> |
        <a href="${pageContext.request.contextPath}/users?action=sortByNameASC">Tên tăng dần</a> |
        <a href="${pageContext.request.contextPath}/users?action=sortByNameDESC">Tên giảm dần</a> |
        <a href="${pageContext.request.contextPath}/users?action=sortByAgeASC">Tuổi tăng dần</a> |
        <a href="${pageContext.request.contextPath}/users?action=sortByAgeDESC">Tuổi giảm dần</a>
    </div>
</center>
<div align="center">
    <table border="1" cellpadding="10">
        <caption><h2>Danh sach nguoi dung</h2></caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Age</td>
            <td>Country</td>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.age}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Sua</a>
                    <a href="/users?action=delete&id=${user.id}">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
