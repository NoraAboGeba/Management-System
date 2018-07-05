/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mano.model;

/**
 *
 * @author nora
 */
public class Employee {
    private int EmpId;
    private String fullName;
    private int age;
    private double salary;
    private String city;
    private int DepId;
    
    //setters and getters
    //employeeId
     public void setEmpId(int Id) {
         
         this.EmpId=Id;
         }
     
     public int getEmpId() {
       return this.EmpId;
    
     }

     //employeeName
     
    public String getFullName() {
        
        return this.fullName;
        }
     public void setFullName(String name) {
        this.fullName=name;
        }

     //employeeAge
    public int getAge() {
         return this.age;
        }

     public void setAge(int age) {
        this.age=age;
         }
     
     //employeeSalary
    public double getSalary() {
       return this.salary; 
       }
    
     public void setSalary(double salary) {
         this.salary=salary;
         }
     
     //employeeCity
    public String getCity() {
      return this.city;
    }
     public void setCity(String city) {
        
       this.city=city;
       }

     
     //employeeDepartmentId
    public int getDepId() {
       return this.DepId; 
       }

    public void setDepId(int DepId) {
       this.DepId=DepId;
        }

   

   
    
    
}//class clossing
