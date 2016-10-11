/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.ids.service;

import com.hxwr.lds.entities.Client;

/**
 *
 * @author 35194
 */
public interface ICustomerSrv {
    
    public Client validateCustomer(String fName, String lName);
    
}
