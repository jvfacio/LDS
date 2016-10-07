/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds;

import com.hxwr.lds.entities.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

}
