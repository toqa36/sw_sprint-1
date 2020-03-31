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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author toqa khaled
 */
@Path("account")
public class AccountController {
    @GET
    @Path("/register/{name}/{email}/{password}/{gender}/{address}/{nationality}/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public String register(@PathParam("name") String name, @PathParam("email") String email, @PathParam("password") String password,
            @PathParam("gender") String gender, @PathParam("address") String address, @PathParam("nationality") String nationality, @PathParam("status") String status) throws ClassNotFoundException, SQLException {
        ArrayList<UsersModel> tmp = new ArrayList();
        String query = "select email from users where users.email='" + email + "'";
        Connection con = null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", "toqa", "123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        if (rs.next()) {
            UsersModel m = new UsersModel();
            m.setEmail(rs.getString("email"));
            tmp.add(m);
        }
        if (tmp.size() != 0) {
            return "this account taken before please choose another one";
        } else if (status.equals("admin")) {
            return "you can not register as an admin";
        } else {
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
}
