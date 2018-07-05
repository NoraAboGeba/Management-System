<%-- 
    Document   : header
    Created on : Jul 3, 2018, 3:17:40 AM
    Author     : nora
--%>
<%@page import="org.mano.service.DepartmentBean"%>
<%@page import="org.mano.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
    <center>
        <div id="mystyle" style="border: none;"> 
            <h1> Welcome To Home Page</h1> <br><br> <br>
                <%=new Date()%></br> <br><br> <br> </br>
                
                <h1>Departments</h1>
                <div>
            <table>
                <thead>
                    <tr>
                        
                        <th>DepName</th>
                                                
                                               
                    </tr>
                </thead>
                <tbody>
                    <%
                        DepartmentBean eb = new DepartmentBean();
                        List<Department> list = eb.getDepartments();
                        for (Department e : list) {
                    %>
 
                    <tr>
                        
                        <td><a href="depView.jsp"><%=e.getDepName()%></a></td> 
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
                
                
                   
        </div>
    </center>
</body>
</html>
 