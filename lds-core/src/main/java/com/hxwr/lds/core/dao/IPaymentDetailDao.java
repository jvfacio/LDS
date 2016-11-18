/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.core.dao;

import com.hxwr.lds.core.entities.PaymentDetail;

/**
 *
 * @author Training
 */
public interface IPaymentDetailDao {
    
    public void addPaymentDetail(PaymentDetail paymentDetail);
    public PaymentDetail getByPaymentID(Integer paymentDetailID);
//    public List<PaymentDetail> getTotalsbyLoanID(Loan loan);
    
}
