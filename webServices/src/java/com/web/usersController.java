/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author toqa khaled
 */
@Path("users")
public class usersController {
    
    @GET
    @Path("/login/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
     
     public String logIn(@PathParam("email")String email,@PathParam("password") String password) throws ClassNotFoundException, SQLException{
         ArrayList<UsersModel> tmp =new ArrayList();
         UsersModel m=new UsersModel();
         String query="select * from users where email='"+email+"' and password='"+password+"'" ;
        Connection con=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(query);
         
         if(rs.next()){
            m.setEmail(rs.getString("email"));
            tmp.add(m);
        }
         if(tmp.size()==1){
             return "you are logged in";
         }
         else
             return "mail or password incorrect";
     }
    
}
