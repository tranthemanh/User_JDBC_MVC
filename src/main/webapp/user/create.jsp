<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 7/31/2024
  Time: 11:28 AM
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
        <table border="1" cellpadding="10">
            <caption>
                <h1>Them moi nguoi dung</h1>
            </caption>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" name="name" id="name" size="30"/>
                </td>
            </tr>
            <tr>
                <td>Age:</td>
                <td>
                    <input type="text" name="age" id="age" size="15"/>
                </td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>
                    <input type="text" name="country" id="country" size="25"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Them</button>
                    <button type="submit"><a href="/users">Quay lại</a></button>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
