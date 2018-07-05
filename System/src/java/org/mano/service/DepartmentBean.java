/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mano.service;


/**
 *
 * @author nora
 */


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
import org.mano.model.Department;
public class DepartmentBean {
    
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/HrSystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1111";
    

    
        public void addNew(Department d){
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            pstmt = con.prepareStatement("INSERT INTO DEpartment(DeppId,DepName,DepFloor) VALUES(?,?,?)");
            pstmt.setInt(1, d.getDepId());
            pstmt.setString(2, d.getDepName());
            pstmt.setString(3, d.getDepFloor());
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
                Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
 
    public Department getDepartment(int id) {
        Department dep = null;
        Connection con = null;
         PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            pstmt = (PreparedStatement) con.createStatement();
            ResultSet rs = pstmt.executeQuery("SELECT * FROM Department WHERE DepId='" + id+"'");
            if (rs.next()) {
                dep = new Department();
                dep.setDepId(rs.getInt(1));
                dep.setDepName(rs.getString(2));
                dep.setDepFloor(rs.getString(3));
                
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
                Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dep;
    }
 

         public List<Department> getDepartments() {
        List<Department> list = new ArrayList<>();
        Connection con = null;
         PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            pstmt = (PreparedStatement) con.createStatement();
            ResultSet rs = pstmt.executeQuery("SELECT DepName FROM Department ORDER BY DepId");
            while (rs.next()) {
                Department dep = new Department();
                
                dep.setDepName(rs.getString(2));
                
                
                list.add(dep);
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

    public void allEmpNum(Department d){
        Department dep;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            
              pstmt = (PreparedStatement) con.createStatement();
            ResultSet rs = pstmt.executeQuery("Select count(EmpId) from Employee;");
            
               if (rs.next()) {
                dep = new Department();
                dep.setDepId(rs.getInt(1));
                dep.setDepName(rs.getString(2));
                dep.setDepFloor(rs.getString(3));
                
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
                Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
         }

    public void employeeNum(Department d) {
           Connection con = null;
           PreparedStatement pstmt = null;
           try {
               Class.forName(JDBC_DRIVER);
               con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
               pstmt = con.prepareStatement("select count(*) FROM Employee "
                       + "join Department ON (Employee.DepId = Department.DepId)WHERE"
                       + " Department.DepName ='"+d.getDepName()+"' "
                      +"group by Department.DepName ;");
              
               pstmt.setString(2, d.getDepName());
               

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
                   Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }





}
