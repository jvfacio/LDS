package com.hxwr.lds.webapp.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.service.ICustomerSrv;
import com.hxwr.lds.webapp.IRestClient;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

/**
 *
 * @author 35194
 */
@Service
public class CustomerSrvImpl implements ICustomerSrv {
    
    /**
     * logger
     */
    private static final Logger log = Logger.getLogger(CustomerSrvImpl.class);
    
    @Autowired
    private IRestClient restClient;

    @Override
    public Client validateCustomer(String username, String password) throws IOException {
        
        log.debug("Validate the customer");
        Client client = restClient.makeRequest(
                "GET", "/client/getclientbynickname/" 
                       + UriUtils.encodePathSegment(username, StandardCharsets.UTF_8.name())
                , Client.class);
        if(client != null && client.getPass().equals(password))
            return client;
        else
            return null;
    }
    @Override
    public Client getCustomer(String nickName) throws IOException {
        return restClient.makeRequest(
            "GET", "/client/getclientbynickname/" 
                   + UriUtils.encodePathSegment(nickName, StandardCharsets.UTF_8.name()),
            Client.class);
        
    }
    
    @Override
    public Client getCustomer(int id) throws IOException  {
        return restClient.makeRequest(
                "GET", "/client/" + id,
                Client.class);
    }
    
    @Override 
    public Client refresh(Client client) throws IOException  {
        return getCustomer(client.getId());
    }

    @Override
    public Client register(Client client) throws IOException {
        Client newClient = 
            restClient.makeRequest("POST", "/client/", client, Client.class);
        client.setId(newClient.getId());
        return newClient;
    }

    @Override
    public List<Client> getAllClients() throws IOException {
       return Arrays.asList(
            restClient.makeRequest(
                "GET", "/clients/",
                Client[].class
            )
       );
    }
}
