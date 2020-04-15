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

public class adminstratorController  {

    public ArrayList<UsersModel> getAllUsers(String status) throws ClassNotFoundException, SQLException  {
        ArrayList<UsersModel> tmp = new ArrayList();
        if(status.equals("admin")){
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
    
}