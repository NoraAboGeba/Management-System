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
public class Department {
    
    
    private int DepId;
    private String DepName;
    private String DepFloor;
    
    
    //setters and getters
    //employeeId
     public void setDepId(int Id) {
         
         this.DepId=Id;
         }
     
     public int getDepId() {
       return this.DepId;
    
     }

     //employeeName
     
    public String getDepName() {
        
        return this.DepName;
        }
     public void setDepName(String name) {
        this.DepName=name;
        }

     
     //employeeCity
    public String getDepFloor() {
      return this.DepFloor;
    }
     public void setDepFloor(String floor) {
        
       this.DepFloor=floor;
       }

}