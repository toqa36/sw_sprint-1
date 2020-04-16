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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author toqa khaled
 */

public class usersController {
 
     public String logIn(String email, String password,String status) throws ClassNotFoundException, SQLException{
         ArrayList<UsersModel> tmp =new ArrayList();
         UsersModel m=new UsersModel();

          if (!isValidEmail(email)){

             return "Please Enter Correct Email ";     
         }

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
         if(status.equals("admin")){
         
         if(tmp.size()==1){
             query = "insert into adminlogin(email,password,status) values(?,?,?)";
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, email);
            s.setString(2, password);
            s.setString(3, status);
            s.executeUpdate();
             
             return "you are logged in";
         }
         else
             return "mail or password incorrect";
         }
         if(tmp.size()==1){
             return "you are logged in";
         }
         else
             return "mail or password incorrect";
   
     }
    // public String  notification()
     
    public String register( String name,String email, String password, String gender, String address,  String nationality,String status) throws ClassNotFoundException, SQLException {
        ArrayList<UsersModel> tmp = new ArrayList();
          ArrayList<UsersModel> cname = new ArrayList();
          

        String query = "select * from users , notification where users.email='"+email+"' and users.name='"+name+"'or notification.email='"+email+"' and notification.name='"+name+"'" ;

         if (!isValidEmail(email)){
        return "Please Enter Correct Email";}
       

        Connection con = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        if (rs.next()) {
            UsersModel mail = new UsersModel();
            UsersModel namee = new UsersModel();
            mail.setEmail(rs.getString("email"));
            namee.setName(rs.getString("name"));
            tmp.add(mail);
            cname.add(namee);
        }
        if (  tmp.size()!=0 || cname.size()!=0) {
            return "this account taken before please choose another one or the name is already exist";
        } else if (status.equals("admin")) {
           query = "insert into notification(name,email,password,gender,address,nationality,status) values(?,?,?,?,?,?,?)";
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, name);
            s.setString(2, email);
            s.setString(3, password);
            s.setString(4, gender);
            s.setString(5, address);
            s.setString(6, nationality);
            s.setString(7, status);
            s.executeUpdate();
            return "Your Registeration Confirmed And You Will Wait For Accepting";
          
        }
      else {
            query = "insert into users(name,email,password,gender,address,nationality,status) values(?,?,?,?,?,?,?)";
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, name);
            s.setString(2, email);
            s.setString(3, password);
            s.setString(4, gender);
            s.setString(5, address);
            s.setString(6, nationality);
            s.setString(7, status);
            s.executeUpdate();
            return "your registeration confirmed";
        }
    }
       private static boolean isValidEmail(String email)
    {
        boolean ret = true;
        int index;
        index = email.indexOf("@");

        if(email==null || email.trim().length()==0)
        {
            ret = false;
        }
        else if (index == -1){
             ret = false;
        
        }
        else
        {

            index = email.indexOf(".com");

             index = email.indexOf("@gmail.com");


            if(index == -1)
            {
                ret = false;
            }
        }

        return ret;
    }
     
    
}