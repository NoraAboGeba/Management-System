/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mano.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mano.model.Employee;
import org.mano.service.EmployeeBean;

/**
 *
 * @author nora
 */ 
@WebServlet(name = "AddNewServlet", urlPatterns = {"/AddNewServlet"})
public class AddNewServlet extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee emp = new Employee();
        emp.setEmpId(Integer.parseInt(request.getParameter("EmpId")));
        emp.setFullName(request.getParameter("FullName"));
        emp.setAge(Integer.parseInt(request.getParameter("age")));
        emp.setSalary(Double.parseDouble(request.getParameter("salary")));
        emp.setCity(request.getParameter("city"));
        emp.setDepId(Integer.parseInt(request.getParameter("designation")));
        EmployeeBean eb = new EmployeeBean();
        eb.addNew(emp);
        response.sendRedirect("empView.jsp");
 
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
 
    

