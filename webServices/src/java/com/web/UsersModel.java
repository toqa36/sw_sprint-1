/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author toqa khaled
 */
@Path("users")
public class UsersModel {

    String name;
    String email;
    String password;
    String status;
    String gender;
    String address;
    String nationality;

    usersController uc = new usersController();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @GET
    @Path("/login/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String logIn(@PathParam("email") String email, @PathParam("password") String password) throws ClassNotFoundException, SQLException {
        return uc.logIn(email, password);
    }

    @GET
    @Path("/register/{name}/{email}/{password}/{gender}/{address}/{nationality}/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public String register(@PathParam("name") String name, @PathParam("email") String email, @PathParam("password") String password,
            @PathParam("gender") String gender, @PathParam("address") String address, @PathParam("nationality") String nationality, @PathParam("status") String status) throws ClassNotFoundException, SQLException {
        return uc.register(name, email, password, gender, address, nationality, status);
    }
}
