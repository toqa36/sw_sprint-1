/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    AccountController(){}
    @GET
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    
    //public String register(String name,String password,String email,String gender,String address,String nationality) 
      public String register(/*String email/*,String password,String email,String gender,String address,String nationality*/) throws ClassNotFoundException, SQLException{
        ArrayList<UsersModel> tmp =new ArrayList();
        String query="select * from users where email='moahmed@gmail.com'"; 
        Connection con=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
      
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(query);
        
        if(rs.next()){
            UsersModel m=new UsersModel();
            m.setEmail(rs.getString("email"));
            tmp.add(m);
        }
        if(tmp.size()!=0)
            return "this account taken before please choose another one";
        else{
           query="insert into users values('mohamed','mohamed@gmail.com','369','male','maadi','egyptaiano','user')"; 
            PreparedStatement s= con.prepareStatement(query);
            s.executeUpdate();
        return "your registeration confirmed"; } 
    }   
}
