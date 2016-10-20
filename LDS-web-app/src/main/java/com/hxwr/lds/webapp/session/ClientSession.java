/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.session;

import com.hxwr.lds.entities.Client;
import java.io.Serializable;

/**
 *
 * @author Training
 */
public class ClientSession implements Serializable {
  
    private Client client = null;
    
    public boolean isLoggedIn() {
        return client != null;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client; 
    }
}
