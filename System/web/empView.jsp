<%-- 
    Document   : empView
    Created on : Jul 3, 2018, 3:20:13 AM
    Author     : nora
--%>

<%@page import="org.mano.service.EmployeeBean"%>
<%@page import="org.mano.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>EmpID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Salary</th>
                        <th>City</th>
                        <th>DepId</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        EmployeeBean emp = new EmployeeBean();
                        List<Employee> lis = emp.getEmployees();
                        for (Employee e : lis) {
                    %>
 
                    <tr>
                        <td><%=String.valueOf(e.getEmpId())%></td>
                        <td><%=e.getFullName()%></td>
                        <td><%=String.valueOf(e.getAge())%></td>
                        <td><%=String.valueOf(e.getSalary())%></td>
                        <td><%=e.getCity()%></td>
                        <td><%=String.valueOf(e.getDepId())%></td>
                        <td style="border: none;">
                            <div>
                                <form method="post" action="empUpdate.jsp">
                                    <input type="hidden" id="updateId" name="updateId" value="<%=String.valueOf(e.getEmpId())%>"/> 
                                    <input type="submit" value="Modify..."/> 
                                </form>
                            </div>
                        </td>
                        
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
 