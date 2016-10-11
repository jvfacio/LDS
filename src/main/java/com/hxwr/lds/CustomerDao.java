/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds;

import com.hxwr.lds.entities.Client;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 35194
 */
public class CustomerDao {

    public void addCustomerDetails(Client customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfig.openSession();
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
    
    public Client getByName(String fName, String lName) {
        
        Session hibernateSession = null;
        try {
            hibernateSession = HibernateConfig.openSession();
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
            if (hibernateSession != null) hibernateSession.close();
        }
    }
    
    public Client getByLoginInfo(String nickname, String password) {
        
        Session hibernateSession = null;
        try {
            hibernateSession = HibernateConfig.openSession();
            Query query = hibernateSession.createQuery(
                    "from Client where nickname = :nickname and password = :password");
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
            if (hibernateSession != null) hibernateSession.close();
        }
    }
}
