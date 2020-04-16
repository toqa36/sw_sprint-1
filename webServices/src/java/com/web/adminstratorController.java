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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author toqa khaled
 */

public class adminstratorController  {

    public ArrayList<UsersModel> getAllUsers(String status, String email) throws ClassNotFoundException, SQLException  {
        ArrayList<UsersModel> tmp = new ArrayList();
        if(status.equals("admin")&&CheckLogIn(email,status)){
        String query = "select * from users";
        Connection con = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            UsersModel m = new UsersModel();
            m.setName(rs.getString("name"));
            m.setEmail(rs.getString("email"));
            m.setGender(rs.getString("gender"));
            m.setStatus(rs.getString("status"));
            m.setAddress(rs.getString("address"));
            m.setNationality(rs.getString("nationality"));
            m.setStatus(rs.getString("status"));
            tmp.add(m);
        }
        return tmp;
        }
        else
            return tmp;
       
    }
     public ArrayList<UsersModel> notification(String email,String status) throws ClassNotFoundException, SQLException{
     
      ArrayList<UsersModel> content = new ArrayList();
      UsersModel data=new UsersModel();
        if(CheckLogIn(email,status)){
        ArrayList<UsersModel> tmp = new ArrayList();
        if(status.equals("admin")){
        String query = "select * from notification";
        Connection con = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            UsersModel m = new UsersModel();
            m.setName(rs.getString("name"));
            m.setEmail(rs.getString("email"));
            m.setGender(rs.getString("gender"));
            m.setStatus(rs.getString("status"));
            m.setAddress(rs.getString("address"));
            m.setNationality(rs.getString("nationality"));
            m.setStatus(rs.getString("status"));
            tmp.add(m);
        }
        return tmp;
        }
        else
            return tmp;
     }
        else
            return content;
     }
     
     
    
     public void managePrands(){}
    
    public String acceptAdmins(String Adminemail,String Adminstatus,String name,String Useremail,String password,
            String gender,String address,String nationality,String status,String decission) throws ClassNotFoundException, SQLException{
    ArrayList<UsersModel> content = new ArrayList();
      UsersModel data=new UsersModel();
        if(CheckLogIn(Useremail,Adminstatus)&&decission.equals("accept")){
            insert( name, Useremail,password,gender ,address, nationality,status,decission);
            
      /*  String query = "select * from notification  where email='"+email1+"'";
        Connection con = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
         if(rs.next()){
            data.setEmail(rs.getString("email"));
            content.add(data);
        }
         if(content.size()==1){
             if(decission.equals("accept")){
                 query =  "insert into users (name,email,password,gender,address,nationality,status) values(?,?,?,?,?,?,?)";
            PreparedStatement s = con.prepareStatement(query);
            s.setString(1, name);
            s.setString(2, email2);
            s.setString(3, password);
            s.setString(4, gender);
            s.setString(5, address);
            s.setString(6, nationality);
            s.setString(7, status);
            s.executeUpdate(); 
            return "Is Accepted To Be Admin";
             }
             else
        return "Is Rejected";
         }
        /* else
             return "Not Founded";*/
        
       return "Is Accepted To Be Admin";
        }
        else
         return "Is Rejected";
       // return Useremail + "--"+Adminemail;
        
    }
    public String insert (String name,String email,String password, String gender,String address,
    String nationality,String status, String decission) throws ClassNotFoundException, SQLException{

          ArrayList<UsersModel> tmp = new ArrayList();
 String query = "select * from notification  where email='"+email+"'";
       /*  if (!isValidEmail(email)){
        return "Please Enter Correct Email";}*/
         Connection con = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
         if (rs.next()) {
            UsersModel mail = new UsersModel();
            mail.setEmail(rs.getString("email"));
        
            tmp.add(mail);
          
        }
         if(tmp.size()!=0){
             
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
            return "Is Accepted To Be Admin";
             }
       
         else
             return "Not Foounded";
    }
    private static boolean CheckLogIn(String email ,String status) throws ClassNotFoundException, SQLException{
         boolean ret = false;
          ArrayList<UsersModel> content = new ArrayList();
      UsersModel data=new UsersModel();
         if(status.equals("admin")){
        String query = "select * from adminlogin where email='"+email+"'";
        Connection con = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            data.setEmail(rs.getString("email"));
            content.add(data);
        }
         if(content.size()==1){
             ret = true;
       
        return ret ;
         }
        }
        else
            return ret; 
         
     return ret;
     }
    

}

    


