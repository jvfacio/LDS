/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.dao.impl;

//import com.hxwr.lds.*;
import com.hxwr.lds.dao.ILoanDao;
import com.hxwr.lds.entities.Loan;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Training
 */
public class LoanDao implements ILoanDao{
    
    private SessionFactory sessionFactory;
    @Override
    public void addLoanDetails(Loan loan) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            session.save(loan);
            transaction.commit();
            System.out.println("\n\n Details Added \n");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Loan getByLoanID(Integer loanID) {
        Session session = null;

        session = sessionFactory.openSession();

        Query query = session.createQuery("from Loan where loanID = :loanID");

        query.setInteger("loanID", loanID);

        Iterator<Loan> iter = query.iterate();

        if (iter.hasNext()) {
            return iter.next();
        } else {
            return null;
        }
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory factory) {
        sessionFactory = factory;
    }
}
