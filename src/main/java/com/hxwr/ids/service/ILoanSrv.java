/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.ids.service;

import com.hxwr.lds.entities.Loan;

/**
 *
 * @author Training
 */
public interface ILoanSrv {
    
    public Loan fetchLoanByID(int loanID);
}
