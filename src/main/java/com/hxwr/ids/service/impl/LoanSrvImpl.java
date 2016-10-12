/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.ids.service.impl;

import com.hxwr.ids.service.ILoanSrv;
import com.hxwr.lds.dao.ILoanDao;
import com.hxwr.lds.entities.Loan;

/**
 *
 * @author Training
 */
public class LoanSrvImpl implements ILoanSrv {
    
    private ILoanDao loanDao;

    public ILoanDao getLoanDao() {
        return loanDao;
    }

    public void setLoanDao(ILoanDao loanDao) {
        this.loanDao = loanDao;
    }
    
    
    @Override
     public Loan getLoanByID(int loanID){
         
         return null;
     }
    
}
