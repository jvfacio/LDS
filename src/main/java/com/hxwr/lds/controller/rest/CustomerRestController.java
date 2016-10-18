/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller.rest;

import com.hxwr.lds.entities.Client;
import com.hxwr.lds.service.ICustomerSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Training
 */
@RestController
@RequestMapping("/rest")
public class CustomerRestController {
    
    @Autowired
    private ICustomerSrv customerSrv;
    
    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable("id") int id) {
        return customerSrv.getCustomer(id);
    }
    
    @GetMapping("/client/{nickName}")
    public Client getCustomer(@PathVariable("nickName") String nickName){
        return customerSrv.getCustomer(nickName);
    }
}
