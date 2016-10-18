/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.dao;

import com.hxwr.lds.entities.Client;
import java.util.List;

/**
 *
 * @author 35194
 */
public interface ICustomerDao {
    
    public void addCustomerDetails(Client customer);
    
    public Client getByName(String fName, String lName);
    public Client getById(int clientId);
    public Client getByLoginInfo(String username, String password);
    public Client refresh(Client client);
    public List<Client> getAllClients();
}
