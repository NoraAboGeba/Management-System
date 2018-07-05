<%-- 
    Document   : index
    Created on : Jul 2, 2018, 12:39:41 AM
    Author     : nora
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <title>New Employee</title>
    </head>
    <body>
        
        <form method="post" action="AddNewServlet">
            <div id="mystyle" class="myform">
                <form id="form" name="form" action="AddNewEmployee" method="post">
                    <h1>Employee</h1>
                    <p>To add new Employee enter following information</p>
                    <label>Employee ID<span class="small">Enter Employee ID</span></label>
                    <input type="text" name="EmpId" id="empId" />
                    <label>Full Name<span class="small">Enter name</span></label>
                    <input type="text" name="fullName" id="empName" />
                    <label>Age<span class="small">Enter phone number</span></label>
                    <input type="text" name="age" id="age" />
                    <label>Salary<span class="small">Enter salary</span></label>
                    <input type="text" name="salary" id="salary" />
                     <label>City<span class="small">Enter City</span></label>
                    <input type="text" name="city" id="city" />
                     <label>DepartmentId<span class="small">Enter Department Id</span></label>
                    <input type="text" name="DepId" id="DepId" />                          
                    <button type="submit">Add New Employee</button>
                    <div class="spacer"></div>
                </form>
            </div>
        </form>    
    </body>
</html>
 