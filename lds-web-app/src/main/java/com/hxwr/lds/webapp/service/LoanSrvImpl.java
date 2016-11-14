package com.hxwr.lds.webapp.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.hxwr.lds.core.service.ILoanSrv;
import com.hxwr.lds.core.entities.Loan;
import org.springframework.stereotype.Service;

/**
 *
 * @author Training
 */
@Service
public class LoanSrvImpl implements ILoanSrv {
    
    
    @Override
     public Loan fetchLoanByID(int loanID){
         
        throw new UnsupportedOperationException();
     }
     
     @Override
     public void addLoanDetails(Loan loan) {
        throw new UnsupportedOperationException();
     }
    
}
