/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author toqa khaled
 */

@Path("admin")
public class AdminstratorModel extends UsersModel {
    adminstratorController a = new adminstratorController();
    
    @GET
    @Path("/getAllUsers/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UsersModel> getAllUsers(@PathParam("status")String status) throws SQLException, ClassNotFoundException
    {
       return a.getAllUsers(status);
        
    }
    
    public void managePrands(){
        a.managePrands();
    }
    
    public void acceptAdmins(){
        a.acceptAdmins();
    }
   
    
    
    
    
    
   
    
      
}