<%@page import="db.Empleado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <link rel="shortcut icon" href="logo.ico">
        <title>Mostrar Empleados</title>
    </head>
    <body background="page.jpg">
        <table border=1>
            <thead>
                <tr>
                    <th>User Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>DOB</th>
                    <th>Email</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Empleado> users = (List<Empleado>) request.getAttribute("users");
                    if (users != null)
                    {
                        for (Empleado user : users)
                        {
                %>
                <tr>
                    <td><%=user.getUserid()%></td>
                    <td><%=user.getFirstName()%></td>
                    <td><%=user.getLastName()%></td>
                    <td><%=user.getDob()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><a href="UserController?action=edit&userId=<%=user.getUserid()%>">Update</a></td>
                    <td><a href="UserController?action=delete&userId=<%=user.getUserid()%>">Delete</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <p><a href="UserController?action=insert">Add User</a></p>
    </body>
</html>