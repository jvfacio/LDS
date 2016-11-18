/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.dao;

import com.hxwr.lds.core.dao.IPaymentDetailDao;
import com.hxwr.lds.core.entities.PaymentDetail;
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
public class PaymentDetailDao implements IPaymentDetailDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPaymentDetail(PaymentDetail paymentDetail) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            session.save(paymentDetail);
            transaction.commit();
            System.out.println("\n\n Payment Added \n");
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
    public PaymentDetail getByPaymentID(Integer paymentDetailID) {
        Session hibernateSession = null;
        try {
            hibernateSession = sessionFactory.openSession();
            return (PaymentDetail) hibernateSession.get(PaymentDetail.class, paymentDetailID);
        } finally {
            //if (hibernateSession != null) hibernateSession.close();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory factory) {
        sessionFactory = factory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

//    @Override
//    public List<PaymentDetail> getTotalsbyLoanID(Loan loan) {
//        Criteria crit = getSession().createCriteria(PaymentDetail.class)
//                .setFetchMode("loan", FetchMode.JOIN)
//                .add(Restrictions.eq("loan.loanID", loan.getLoanID()))
//                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//        return  crit.list();
//    }
}
