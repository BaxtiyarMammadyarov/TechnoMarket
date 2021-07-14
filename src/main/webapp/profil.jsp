<%@ page import="az.mycompany.TechnoMarket.model.Users" %><%--
  Created by IntelliJ IDEA.
  User: Baxtiyar
  Date: 13/07/2021
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profil</title>
</head>
<body>
<%
HttpSession httpSession=request.getSession();
    Users users= (Users) httpSession.getAttribute("user");
%>
<table>
    <tr>
        <td>Ad</td>
        <td><%=users.getName()%></td>
    </tr>
    <tr>
        <td>Soyad</td>
        <td><%=users.getSurname()%></td>
    </tr>
    <tr>
        <td>Istifadəçi adı</td>
        <td><%=users.getUsername()%></td>
    </tr>
    <tr>
        <td>Elektron poçt</td>
        <td><%=users.getEmail()%></td>
    </tr>
    <tr>
        <td>Telefon</td>
        <td><%=users.getPhone()%></td>
    </tr>
    <tr>
        <td>Qeydiyyar tarixi</td>
        <td><%=users.getDateTime()%></td>
    </tr>
</table>

</body>
</html>
