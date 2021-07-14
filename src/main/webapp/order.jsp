<%@ page import="az.mycompany.TechnoMarket.model.Product" %>
<%@ page import="az.mycompany.TechnoMarket.model.Users" %><%--
  Created by IntelliJ IDEA.
  User: Baxtiyar
  Date: 15/07/2021
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Users users= (Users) request.getSession().getAttribute("user");
%>
<h1><%=users.getName()+" "+users.getSurname()+" sifarisniz qeyde alindi"%></h1>
</body>
</html>
