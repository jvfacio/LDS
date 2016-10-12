/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds;

import com.hxwr.lds.entities.Loan;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Training
 */
public class LoanDao {
    public void addLoanDetails(Loan loan) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfig.openSession();

            transaction = session.beginTransaction();

            session.save(loan);
            transaction.commit();
            System.out.println("\n\n Details Added \n");
        }
        catch (HibernateException e) {
            if(transaction != null) transaction.rollback();
            throw e;
        }
        finally {
            if(session != null) session.close();
        }
    }
    
}
