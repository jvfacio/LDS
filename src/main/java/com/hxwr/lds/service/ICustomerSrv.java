/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.service;

import com.hxwr.lds.entities.Client;

/**
 *
 * @author 35194
 */
public interface ICustomerSrv {
    
    public Client validateCustomer(String nickname, String password);
    public Client refresh(Client client);
    public Client getCustomer(int id);
    public void register(Client client);
}
