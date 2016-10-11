/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.dao.impl;

import com.hxwr.lds.HibernateConfig;
import com.hxwr.lds.dao.ICustomerDao;
import com.hxwr.lds.entities.Client;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author 35194
 */
public class CustomerDao extends HibernateDaoSupport implements ICustomerDao {

    private static final Logger log = Logger.getLogger(CustomerDao.class);

    public void addCustomerDetails(Client customer) {
        try {
            Session session = HibernateConfig.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            session.close();
            transaction.commit();

            System.out.println("\n\n Details Added \n");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error in customerDao");
        }

    }

    public Client getByName(String fName, String lName) {

        log.debug("getByName in the dao implementation");
        
        Session hibernateSession = getSessionFactory().openSession();

//        Session hibernateSession = HibernateConfig.openSession();
//        
        Query query = hibernateSession.createQuery(
                "from Client where name = :name and lastName = :lastName");
        query.setString("name", fName);
        query.setString("lastName", lName );
//        
        Iterator<Client> iter = query.iterate();
        if (iter.hasNext()) {
            return iter.next();
        }
        else {
            return null;
        }

        //getHibernateTemplate().find("from Client where name = :name and lastName = :lastName");
        
        //return null;
    }

}
