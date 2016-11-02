/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.core.service;

import com.hxwr.lds.core.entities.Client;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 35194
 */
public interface ICustomerSrv {
    
    public Client validateCustomer(String nickname, String password)
            throws IOException ;
    public Client refresh(Client client)
            throws IOException ;
    public Client getCustomer(int id)
            throws IOException ;
    public List<Client> getAllClients()
            throws IOException ;
    public void register(Client client)
            throws IOException ;
    public Client getCustomer(String nickName)
            throws IOException ;
}
