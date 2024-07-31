<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/31/2024
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quan Ly Nguoi Dung</title>
</head>
<body>
<div align="center">
    <form method="post">
        <caption><h1>Xoa Nguoi Dung</h1></caption>
        <table border="1" cellpadding="10">
            <tr>
                <td>ID: </td>
                <td>${requestScope["user"].getId()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["user"].getName()}</td>
            </tr>
            <tr>
                <td>Ager: </td>
                <td>${requestScope["user"].getAge()}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${requestScope["user"].getCountry()}</td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Xoa</button>
                    <button type="submit"><a href="/users">Quay lại</a></button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
