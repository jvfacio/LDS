/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.session;

import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.service.ICustomerSrv;
import java.io.IOException;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author Training
 */
@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ClientSession implements Serializable {
  
    @Autowired
    private ICustomerSrv customerSrv;
    
    private Client client = null;
    
    public boolean isLoggedIn() {
        return client != null;
    }
    
    public Client getClient() throws IOException {
        if(client != null)
            client = customerSrv.getCustomer(client.getId());
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client; 
    }
}
