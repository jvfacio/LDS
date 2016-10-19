/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.service.impl;

import com.hxwr.lds.service.ILoanSrv;
import com.hxwr.lds.dao.ILoanDao;
import com.hxwr.lds.entities.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Training
 */
@Service
public class LoanSrvImpl implements ILoanSrv {
    
    @Autowired
    private ILoanDao loanDao;

    public ILoanDao getLoanDao() {
        return loanDao;
    }

    public void setLoanDao(ILoanDao loanDao) {
        this.loanDao = loanDao;
    }
    
    
    @Override
     public Loan fetchLoanByID(int loanID){
         
         return loanDao.getByLoanID(loanID);
     }
     
     @Override
     public void addLoanDetails(Loan loan) {
         loanDao.addLoanDetails(loan);
     }
    
}
