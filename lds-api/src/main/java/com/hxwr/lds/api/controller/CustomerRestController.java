
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.controller;

import com.hxwr.lds.core.dao.ICustomerDao;
import java.util.List;
import com.hxwr.lds.core.entities.Client;
import javax.ws.rs.Consumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Training
 */
@RestController
public class CustomerRestController {
    
    @Autowired
    private ICustomerDao customerDao;
    
    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return customerDao.getAllClients();
    }
    
   @PostMapping("/client")
   @Consumes("application/json")
   public void postClient(@RequestBody Client cl){
       System.out.println(cl.getName());
       System.out.println(cl.getNickName());
       customerDao.addCustomerDetails(cl);
       System.out.println("Finish");      
    }
    
    
    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable("id") int id) {
        return customerDao.getById(id);
    }
    
    @GetMapping("/client/getclientbynickname/{nickName}")
    public Client getCustomer(@PathVariable("nickName") String nickName){
        return customerDao.getByNickName(nickName);
    }
}
