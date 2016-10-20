/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.core.service;

import com.hxwr.lds.core.entities.Client;
import java.util.List;

/**
 *
 * @author 35194
 */
public interface ICustomerSrv {
    
    public Client validateCustomer(String nickname, String password);
    public Client refresh(Client client);
    public Client getCustomer(int id);
    public List<Client> getAllClients();
    public void register(Client client);
    public Client getCustomer(String nickName);
}
