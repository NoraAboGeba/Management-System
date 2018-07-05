/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mano.service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mano.model.Employee;

/**
 *
 * @author nora
 */
public class EmployeeBean {
    
   
 
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/HrSystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
 
    public void addNew(Employee e) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            pstmt = con.prepareStatement("INSERT INTO Employee(EmpId,fullName,age,salary,city,DepId) VALUES(?,?,?,?,?,?)");
            pstmt.setInt(1, e.getEmpId());
            pstmt.setString(2, e.getFullName());
            pstmt.setInt(3, e.getAge());
            pstmt.setDouble(4, e.getSalary());
            pstmt.setString(5, e.getCity());
            pstmt.setInt(6, e.getDepId());
            pstmt.execute();
        } catch (SQLException | ClassNotFoundException ex) {
 
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public void delete(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            pstmt =   (PreparedStatement) con.createStatement();
            pstmt.execute("DELETE FROM Employee WHERE EmpId='" + String.valueOf(id)+"' ");
        } catch (SQLException | ClassNotFoundException ex) {
 
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public void update(Employee e) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            pstmt = con.prepareStatement("UPDATE Employee SET FullName=?, age=?, salary=?,city=?, DepId=? WHERE EmpId=?");
            pstmt.setInt(1, e.getEmpId());
            pstmt.setString(2, e.getFullName());
            pstmt.setInt(3, e.getAge());
            pstmt.setDouble(4, e.getSalary());
            pstmt.setString(5, e.getCity());
            pstmt.setInt(6, e.getDepId());
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
 
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public Employee getEmployee(int id) {
        Employee emp = null;
        Connection con = null;
         PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            pstmt = (PreparedStatement) con.createStatement();
            ResultSet rs = pstmt.executeQuery("SELECT * FROM Employee WHERE EmpId='" + id+"'");
            if (rs.next()) {
                emp = new Employee();
                emp.setEmpId(rs.getInt(1));
                emp.setFullName(rs.getString(2));
                emp.setAge(rs.getInt(3));
                emp.setSalary(rs.getInt(4));
                emp.setCity(rs.getString(5));
                emp.setDepId(rs.getInt(6));
            }
        } catch (SQLException | ClassNotFoundException ex) {
 
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emp;
    }
 
    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
         PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            pstmt = (PreparedStatement) con.createStatement();
            ResultSet rs = pstmt.executeQuery("SELECT * FROM Employee ORDER BY EmpId");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpId(rs.getInt(1));
                emp.setFullName(rs.getString(2));
                emp.setSalary(rs.getDouble(3));
                emp.setAge(rs.getInt(4));
                emp.setCity(rs.getString(5));
                emp.setDepId(rs.getInt(6));
                list.add(emp);
            }
        } catch (SQLException | ClassNotFoundException ex) {
 
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                
            }
        }
        return list;
    }
 
}
 
    

