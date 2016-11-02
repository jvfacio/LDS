/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.dao;

//import com.hxwr.lds.*;
import com.hxwr.lds.core.dao.ILoanDao;
import com.hxwr.lds.core.entities.Loan;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Training
 */
@Repository
public class LoanDao implements ILoanDao{
    
    
    @Autowired
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

    @Override
    public Loan getByLoanID(Integer loanID) {
        Session hibernateSession = null;
        try {
            hibernateSession = sessionFactory.openSession();
            return (Loan) hibernateSession.get(Loan.class, loanID);
        }
        finally {
            //if (hibernateSession != null) hibernateSession.close();
        }
    }
    
    @Override
    public Loan refresh(Loan loan) {
        return getByLoanID(loan.getLoanID());
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory factory) {
        sessionFactory = factory;
    }
}
