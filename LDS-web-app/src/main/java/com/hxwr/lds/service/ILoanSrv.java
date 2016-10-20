/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.service;

import com.hxwr.lds.entities.Loan;

/**
 *
 * @author Training
 */
public interface ILoanSrv {
    
    public Loan fetchLoanByID(int loanID);
    public void addLoanDetails(Loan loan);
}
