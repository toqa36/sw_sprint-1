/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.util.ArrayList;
import static org.apache.coyote.http11.Constants.a;

/**
 *
 * @author toqa khaled
 */
public class customerModel extends UsersModel{

    
    customerController cc = new customerController();

      public ArrayList<String> viewProduct(){return cc.viewProduct();}
      public void buyProduct(){cc.buyProduct();}
    
   
}
