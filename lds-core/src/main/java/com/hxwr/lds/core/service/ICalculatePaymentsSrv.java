package com.hxwr.lds.core.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.entities.PaymentDetail;
import java.util.ArrayList;

/**
 *
 * @author 35194
 */
public interface ICalculatePaymentsSrv {
    
    /**
     * Generate the loan report object
     * @param loan loan data
     * @return a loan report data
     */
    
    public ArrayList<PaymentDetail> CalculatePayments(Loan loan);
}
