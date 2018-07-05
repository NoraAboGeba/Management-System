<%-- 
    Document   : empUpdate
    Created on : Jul 3, 2018, 4:00:46 AM
    Author     : nora
--%>

<%@page import="org.mano.model.Employee"%>
<%@page import="org.mano.service.EmployeeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <title>Employee Update Page</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <%
            int id = Integer.parseInt(request.getParameter("updateId"));
            EmployeeBean ebb = new EmployeeBean();
            Employee e = ebb.getEmployee(id);
        %>
        <div id="mystyle" class="myform">
            <form id="form" name="form" action="UpdateServlet" method="post">
                <h1>Update Employee ID:<%=e.getEmpId()%></h1>
                <p>Modify the following information to update employee ID:<%=e.getEmpId()%></p>
                <label><input type="hidden" name="empId" id="empId" value="<%=e.getEmpId()%>"/><span class="small"></span></label>                    
                <label>Name<span class="small">Enter name</span></label>
                <input type="text" name="fullName" id="empName" value="<%=e.getFullName()%>"/>
                <label>Age<span class="small">Enter Age</span></label>
                <input type="text" name="age" id="age" value="<%=e.getAge()%>"/>
                <label>Salary<span class="small">Enter Age</span></label>
                <input type="text" name="salary"  value="<%=e.getSalary()%>"/>
                <label>City<span class="small">Enter City</span></label>
                <input type="text" name="salary" id="city" value="<%=e.getCity()%>"/>
                <label>DepId<span class="small">Enter designation</span></label>
                <input type="text" name="DepId" id="depid" value="<%=e.getDepId()%>"/>                           
                <button type="submit">Update Employee</button>
                <div class="spacer"></div>
            </form>
        </div>   
    </body>
</html>
 
