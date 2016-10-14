/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.service.impl;

import com.hxwr.lds.service.ICustomerSrv;
import com.hxwr.lds.dao.ICustomerDao;
import com.hxwr.lds.entities.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 35194
 */
@Service
public class CustomerSrvImpl implements ICustomerSrv{
    
    /**
     * logger
     */
    private static final Logger log = Logger.getLogger(CustomerSrvImpl.class);
    
    /**
     * persist layer 
     */
    @Autowired
    private ICustomerDao customerDao;

    public ICustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Client validateCustomer(String username, String password) {
        
        log.debug("Validate the customer");
        return customerDao.getByLoginInfo(username, password);
        
    }
    
    @Override 
    public Client refresh(Client client) {
        return customerDao.refresh(client);
    }

    @Override
    public void register(Client client) {
        customerDao.addCustomerDetails(client);
    }
}
