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
        
        Session hibernateSession = HibernateConfig.openSession();
        
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

}
