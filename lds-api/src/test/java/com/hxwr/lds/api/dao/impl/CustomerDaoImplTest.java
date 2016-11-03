/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.dao.impl;

import com.hxwr.lds.core.dao.ICustomerDao;
import com.hxwr.lds.core.entities.Client;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * this test use the same 
 * @author 35194
 *    
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//    "file:src/main/webapp/WEB-INF/spring/api-servlet.xml",
//    "file:src/main/webapp/WEB-INF/spring/databse-context.xml",
//    "file:src/main/webapp/WEB-INF/spring/hibernate-context.xml"})
public class CustomerDaoImplTest {

    @Autowired
    @Qualifier("customerDao")
    ICustomerDao customerDao;
    
    //@Test
    public void test_ml_always_return_true() {

        //assert correct type/impl
        assertThat(customerDao, instanceOf(ICustomerDao.class));
        Client client = customerDao.getById(1);
        System.out.println("client:" + client);
        
        
        //assert true
        assertThat(true, is(true));

    }
    
    

}
