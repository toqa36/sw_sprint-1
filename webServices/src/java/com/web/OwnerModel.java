/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

/**
 *
 * @author toqa khaled
 */

public class OwnerModel extends UsersModel{
    OwnerController oc= new OwnerController();
     public void putProduct(String item,int price,String description)
     {oc.putProduct(item, price, description);}
    
}
