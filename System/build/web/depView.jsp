<%-- 
    Document   : depView
    Created on : Jul 5, 2018, 3:15:05 AM
    Author     : nora
--%>
<%@page import="org.mano.service.DepartmentBean"%>
<%@page import="org.mano.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>DepID</th>
                        <th>DepName</th>
                        <th>DepFloor</th>
                        <th>Employee Number<th/>
                                               
                    </tr>
                </thead>
                <tbody>
                    <%
                        DepartmentBean eb = new DepartmentBean();
                        List<Department> list = eb.getDepartments();
                        for (Department e : list) {
                    %>
 
                    <tr>
                        <td><%=String.valueOf(e.getDepId())%></td>
                        <td><%=e.getDepName()%></td>
                        <td><%=e.getDepFloor()%></td>
                        
                        <td >
                            
                               <% DepartmentBean empp= new DepartmentBean();
                                 Department emp= new Department();
                               %>
                                <%= empp.allEmpNum(emp)%>
                                
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
                
                <div>
                    <form method="post" action="empAddNew.jsp" >
                    <input type="submit" value="add Employee"/>
                    </form>
                </div> 
                
    </body>
</html>
