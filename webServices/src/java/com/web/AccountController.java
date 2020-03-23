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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author toqa khaled
 */
@Path("account")
public class AccountController {
    @GET
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    
    public ArrayList<model> register(String email/*,String password,String email,String gender,String address,String nationality*/) throws ClassNotFoundException, SQLException{
        ArrayList<model> tmp =new ArrayList();
        String query="select * from users where email=email"; 
        Connection con=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
       // DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(query);
        
        while(rs.next()){
            model m=new model();
            m.setId(rs.getInt("id"));
            m.setName(rs.getString("name"));
            m.setEmail(rs.getString("email"));
            tmp.add(m);
        }
        
        return tmp;
        
    }
    
    
}
