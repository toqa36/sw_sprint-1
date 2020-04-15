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
       return a.getAllUsers(status);}
    @GET
    @Path("/notification/{email}/{status}")
    @Produces(MediaType.APPLICATION_JSON)
        public ArrayList<UsersModel> getnotification(@PathParam("email")String email,@PathParam("status")String status) throws SQLException, ClassNotFoundException
        {
            return a.notification(email, status);
        }
        

    
    public void managePrands(){
        a.managePrands();
    }
    
    @GET
    @Path("/insert/{email}/{status}/{name}/{email}/{password}/{gender}/{address}/{nationality}/{status}/{decission}")
    @Produces(MediaType.APPLICATION_JSON)
    public String acceptAdmins(@PathParam("email")String email1,
            @PathParam("status")String status1,@PathParam("name") String name2,
            @PathParam("email") String email2,@PathParam("password") String password2, 
            @PathParam("gender") String gender2,@PathParam("address") String address2, 
            @PathParam("nationality") String nationality2, @PathParam("status") String status2,
            @PathParam("decission") String decission2) throws ClassNotFoundException, SQLException{
      return  a.acceptAdmins(email1,status1,name2,email2,password2,gender2,address2,nationality2,
              status2,decission2);
    }  //ans@gmail.com
    
    
    @GET
    @Path("/ac/{name}/{email}/{password}/{gender}/{address}/{nationality}/{status}/{decission}")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@PathParam("name") String name2,
            @PathParam("email") String email2,@PathParam("password") String password2, 
            @PathParam("gender") String gender2,@PathParam("address") String address2, 
            @PathParam("nationality") String nationality2, @PathParam("status") String status2,
            @PathParam("decission") String decission2) throws ClassNotFoundException, SQLException{
        return a.insert(name, email2, password, gender, address, nationality, status, decission2);
    
    }
}
