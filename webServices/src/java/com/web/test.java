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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author toqa khaled
 */
@Path("test") // identify class
public class test {
    
   @GET
   @Path("/getdata") // identify method
   @Produces(MediaType.APPLICATION_JSON)
   
//   public String get(){
//       return "test";
//   }
   
   
     public ArrayList<model> getAllUsers() throws SQLException, ClassNotFoundException {
       ArrayList<model> tmp = new ArrayList();
         Connection con = null;
         String query = "select * from test";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        
       
        //if(status.equals("admin")){
       
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
             model m = new model();
            m.setName(rs.getString("name"));
            m.setEmail(rs.getString("email"));
            tmp.add(m);
        }
        return tmp;
        }
   
   
    
}
