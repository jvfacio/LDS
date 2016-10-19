/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.dao.impl;

import com.hxwr.lds.dao.ICustomerDao;
import com.hxwr.lds.entities.Client;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 35194
 */

@Repository
public class CustomerDao implements ICustomerDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    private static final Logger log = Logger.getLogger(CustomerDao.class);

        public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory factory) {
        sessionFactory = factory;
    }
    
    @Override
    public void addCustomerDetails(Client customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();

            System.out.println("\n\n Details Added \n");

        } catch (HibernateException e) {
            if(transaction != null) transaction.rollback();
            throw e;
        }
        finally {
            if(session != null) session.close();
        }
        

    }
    
    @Override
    public Client getById(int clientId) {
        Session hibernateSession = null;
        try {
            hibernateSession = sessionFactory.openSession();
            return (Client) hibernateSession.get(Client.class, clientId);
        }
        finally {
            //if (hibernateSession != null) hibernateSession.close();
        }
    }
    
    @Override
    public Client getByName(String fName, String lName) {
        
        Session hibernateSession = null;
        try {
            hibernateSession = sessionFactory.openSession();
            Query query = hibernateSession.createQuery(
                    "from Client where name = :name and lastName = :lastName");
            query.setString("name", fName);
            query.setString("lastName", lName );

            Iterator<Client> iter = query.iterate();
            if (iter.hasNext()) {
                return iter.next();
            }
            else {
                return null;
            }
        }
        finally {
            //if (hibernateSession != null) hibernateSession.close();
        }
    }
    
    @Override
    public Client getByLoginInfo(String nickname, String password) {
        
        Session hibernateSession = null;
        try {
            hibernateSession = sessionFactory.openSession();
            Query query = hibernateSession.createQuery(
                    "from Client where nickName = :nickname and pass = :password");
            query.setString("nickname", nickname);
            query.setString("password", password);

            Iterator<Client> iter = query.iterate();
            if (iter.hasNext()) {
                return iter.next();
            }
            else {
                return null;
            }
        }
        finally {
            //if (hibernateSession != null) hibernateSession.close();
        }
    }
    
    @Override
    public Client refresh(Client client) {
        return getById(client.getId()); 
    }
}